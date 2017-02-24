package io.swagger.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
public class ApplicantApiTest2 {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}*/
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import io.swagger.api.CsvRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration

public class ApplicantApiTest { 

	private MockMvc mockMvc; //fake model-view-controller for this test

	@Autowired
	private ApplicantsApiController apicontroller;


	@Configuration
	static public class ContextConfiguration {
		@Bean
		public ApplicantRepository repoBean() {
			// there exists a system property set in src/main/resources/application.properties
			// naming the csv file containing the mock data.
			// We want Spring to inject the value of the property here using  @Value("${data.source}")
			// @Value("${data.source}") //giving up on @Value business for now
			final String datapath = "applicants.csv";
			return (new CsvRepository()).setDatapath(datapath);
		}

		@Bean
		public ApplicantsApiController controllerBean() {
			return (new ApplicantsApiController()); // TODO: find better way of wiring this
		}
	}
    
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup( this.apicontroller).build();
    }

    @Test
    public void getAccount() throws Exception {
        this.mockMvc.perform(get("/applicants/0").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))
            .andExpect(jsonPath("$.id").value(0))
            .andExpect(jsonPath("$.familyname").value("Doe"))
            .andExpect(jsonPath("$.givenname").value("Jane"));
    }
}