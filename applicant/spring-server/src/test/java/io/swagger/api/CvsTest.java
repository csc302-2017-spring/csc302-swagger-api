package io.swagger.api;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
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

	// Way elaborate Spring test bean injection infrastructure.
	// This static class is used as a marker
	// of where to inject. It gives the test writer a spot to modify the bean before it
	// is injected.
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
