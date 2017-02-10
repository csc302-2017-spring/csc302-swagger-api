package io.swagger.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

//@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
//@SpringApplicationConfiguration(classes=ApplicantsApiController.class)

@WebMvcTest(ApplicantsApiController.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ApplicantApiTester {
	
	// TODO: we do this because the constructor of CviRepository we want to create is not the default one.
	// so the @Bean thing will get the instance into the container and then wiring will find it.
	//
	@Configuration
	static public class ContextConfiguration {
		@Bean
		    public ApplicantRepository mockme(){
	    	// there exists a system property set in src/main/resources/application.properties 
	    	// naming the csv file containing the mock data.
	    	// We want Spring to inject the value of the property here using its @Value("${data.source}")
	    	// thing here but I can't find requisite incantation.
			//@Value("${data.source}")
			//String datapath;
			String datapath = "applicants.csv"; //giving up for now
	        //CsvRepository mock = new CsvRepository();
			return (new CsvRepository()).setDatapath(datapath);
	    }
	}
	
	@Configuration
	static public class ContextConfiguration2 {
		@Autowired 
		private ApplicantRepository xx;
		@Bean
	    public ApplicantsApiController mockme(){
			return new ApplicantsApiController();
	    }
	}
	
	@Autowired
	private CsvRepository victim2;
	
    @Autowired
    private MockMvc mockMvc;

	@Autowired
	ApplicantsApiController victim;
	
    @Before
    public void setup() {
    	this.mockMvc = MockMvcBuilders.standaloneSetup(new ApplicantsApiController()).build();
    }

	@Test
	public void test() throws Exception {
		 this.mockMvc.perform(get("/").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
         .andExpect(status().isOk())
         .andExpect(content().contentType("application/json"));		 
	}
}
