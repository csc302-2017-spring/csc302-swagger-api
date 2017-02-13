package io.swagger.api;

import static org.junit.Assert.*;

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
public class CvsTest {

	// Way elaborate Spring test bean injection infrastructure.
	// This static class is used as a marker of where to inject. 
	// It gives the test writer a spot to modify the bean before it is injected.
	// TODO: we do this because the constructor of CviRepository we want to create is not the default one.
	// so the @Bean thing will get the instance into the container and then wiring will find it.
	//	
	@Configuration
	static public class ContextConfiguration {
		CsvRepository mock; //TODO: this is nonsense?
		@Bean
	    public CsvRepository mockme(){
	    	// there exists a system property set in src/main/resources/application.properties 
	    	// naming the csv file containing the mock data.
	    	// We want Spring to inject the value of the property here using its @Value("${data.source}")
	    	// thing here but I can't find requisite incantation.
			//@Value("${data.source}")
			//String datapath;
			String datapath = "applicants.csv"; //giving up for now
	        CsvRepository mock = new CsvRepository();
	        mock.setDatapath(datapath);
	        return mock;
	    }
	}
	
	@Autowired
	private CsvRepository victim;
	
	@Test
	public void test() {
		List<Applicant> applicantsFromCsvFile = victim.getApplicants();
		Applicant jane = applicantsFromCsvFile.get(0);
		//how to check if id is set somehow sane?
		//well, to prod my code let's assume that id for these two much be either 0 or 1 and are different
		assertEquals(jane.getFamilyname(), "Doe");
		assertEquals(jane.getGivenname(), "Jane");
		assertEquals(jane.getPhonenumber(), "(416)000-0000");
		assertEquals(jane.getProgram(), "BSC");
		assertTrue(jane.getYear() == 2);
		assertEquals(jane.getWorkstatus(), "Eligible");
		assertEquals(jane.getDateofapplication(),"20170101");
		assertTrue(jane.getId() == 0 || jane.getId() == 1);
		
		Applicant john = applicantsFromCsvFile.get(1);
		assertEquals(john.getFamilyname(), "Doe");
		assertEquals(john.getGivenname(), "John");
		assertTrue(john.getId() == 0 || john.getId() == 1);
		assertTrue(john.getId() != jane.getId());
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
		a.setDateofapplication("today"); //TODO: today should bite someone sooner or later
		this.victim.add(a);
		boolean found = false;
		long insertedId = -1;
		for(Applicant anApplicant: victim.getApplicants()){
			if (anApplicant.getFamilyname().equals("Zaleski") ){
				assertFalse(found);
				found = true;
				insertedId = anApplicant.getId();
			}
		}
		assertTrue(insertedId != -1);
		//now delete it
		victim.delete(insertedId);
		//now make sure it's gone!
		for(Applicant anApplicant: victim.getApplicants()){
			if (anApplicant.getId() == insertedId ){
				fail("still applicant there. delete failed");
			}
		}	
	}

}
