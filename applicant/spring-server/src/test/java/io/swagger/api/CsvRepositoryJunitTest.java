package io.swagger.api;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.swagger.api.CsvRepository;
import io.swagger.model.Applicant;
import io.swagger.model.NewApplicant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CsvRepositoryJunitTest {

	static final String dummyCsvLinesForJunitTests[] = {
			"000000000,Smith,Jane,(416)000-0000,ECE,BSC,2,Eligible,,20170101",
			"000000001,Jones,John,(416)000-0001,CSC,BSC,1,Eligible,,20170101"
		};

	// The Spring Bean container uses this static class as a marker of where to inject.
	// This may NOT be the conventional way of wiring up test classes, but it's the cleanest way I could find.
	// The idea here is that we want to use a specialized constructor of CviRepository
	// (the one that takes a list of CSV lines). The method marked @Bean will return the instance we want
	// the test to use.
	//	
	@Configuration
	static public class ContextConfiguration {
		@Bean
		//TODO: figure out how to factor this code into other Junit tests.. (one line not worth much bother)
		public ApplicantRepository csvRepoBeanFromFileNamedByDataResource() {
			return (new CsvRepository(Arrays.asList(dummyCsvLinesForJunitTests)));
		}
	}
	
	@Autowired
	private CsvRepository testApplicantRepo;
	
	@Test
	public void test() {
		List<Applicant> applicantsFromCsvFile = testApplicantRepo.getApplicants();
		Applicant jane = applicantsFromCsvFile.get(0);
		//how to check if id is set somehow sane?
		//well, to prod my code let's assume that id for these two much be either 0 or 1 and are different
		assertEquals(jane.getFamilyname(), "Smith");
		assertEquals(jane.getGivenname(), "Jane");
		assertEquals(jane.getPhonenumber(), "(416)000-0000");
		assertEquals(jane.getProgram(), "BSC");
		assertTrue(jane.getYear() == 2);
		assertEquals(jane.getWorkstatus(), "Eligible");
		assertEquals(jane.getDateofapplication(),"20170101");
		assertTrue(jane.getId() == 0 || jane.getId() == 1);
		
		Applicant john = applicantsFromCsvFile.get(1);
		assertEquals(john.getFamilyname(), "Jones");
		assertEquals(john.getGivenname(), "John");
		assertTrue(john.getId() == 0 || john.getId() == 1);
		assertTrue(john.getId() != jane.getId());
	}
	

	@Test
	public void testFind() {
		List<Applicant> applicantsFromCsvFile = testApplicantRepo.getApplicants();
		Applicant firstOne = null;
		for(Applicant anApplicant: applicantsFromCsvFile) {
			firstOne = anApplicant;
		}
		assertTrue(firstOne != null);
		Applicant shouldBeSameAsFirstOne = testApplicantRepo.find(firstOne.getId());
		assertTrue(firstOne.equals(shouldBeSameAsFirstOne));
	}
	
	@Test
	public void testAddDelete() {
		NewApplicant a = new NewApplicant();
		a.setStudentnumber(771734940);
		a.setFamilyname("Zaleski");
		a.setGivenname("Mathew");
		a.setPhonenumber("222-2222");
		a.setStudentdepartment("CS");
		a.setProgram("PHD");
		a.setYear(42);
		a.setWorkstatus("OKAY");
		a.setWorkstatusexplain("citizen");
		a.setDateofapplication("today"); //TODO: "today" will bite someone sooner or later
		this.testApplicantRepo.add(a);
		boolean found = false;
		long insertedId = -1;
		for(Applicant anApplicant: testApplicantRepo.getApplicants()){
			if (anApplicant.getFamilyname().equals("Zaleski") ){
				assertFalse(found);
				found = true;
				insertedId = anApplicant.getId();
			}
		}
		assertTrue(insertedId != -1);
		//now delete it
		testApplicantRepo.delete(insertedId);
		//now make sure it's gone!
		for(Applicant anApplicant: testApplicantRepo.getApplicants()){
			if (anApplicant.getId() == insertedId ){
				fail("still applicant there. delete failed");
			}
		}	
	}

}
