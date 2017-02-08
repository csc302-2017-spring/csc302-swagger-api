package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.swagger.api.CsvRepository;
import io.swagger.model.Applicant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CvsTest {

	private String dataPath;
	
	@Value("${data.source}")
	void setDataPath(String parm){
		dataPath = parm;
	}

	//Crazy spring test bean injection infrastructure.
	//apparently they think that a static class like this is a reasonable marker
	//of where to inject. It gives the test writer a spot to modify the bean before it
	//is injected. Presumably this help us mock stuff up (?)
	@Configuration
	static public class ContextConfiguration {
	    // this bean will be injected into the CvsTest class at the autowired thingy?
	    @Bean
	    public CsvRepository xx(){
	    	//want to do the @Value("${data.source}") thing here but can't find incantation
	        return new CsvRepository("applicants.csv");
	    }
	}
	@Autowired
	private CsvRepository victim;
	
	@Test
	public void test() {
		List<Applicant> applicantsFromCsvFile = victim.getApplicants();
		Applicant jane = applicantsFromCsvFile.get(0);
		assertEquals(jane.getFamilyname(), "Doe");
		assertEquals(jane.getGivenname(), "Jane");
		assertEquals(jane.getPhonenumber(), "(416)000-0000");
		assertEquals(jane.getProgram(), "BSC");
		assertTrue(jane.getYear() == 2);
		assertEquals(jane.getWorkstatus(), "Eligible");
		assertEquals(jane.getDateofapplication(),"20170101");
		
		Applicant john = applicantsFromCsvFile.get(1);
		assertEquals(john.getFamilyname(), "Doe");
		assertEquals(john.getGivenname(), "John");
	}

}
