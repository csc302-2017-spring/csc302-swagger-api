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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.swagger.api.CsvRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration

public class ApplicantApiJunitTest { 

	private MockMvc mockMvc; //fake model-view-controller for this test

	@Autowired
	private ApplicantsApiController apicontroller;

	static final String dummyCsvLinesForJunitTests[] = {
			"000000000,Smith,Jane,(416)000-0000,ECE,BSC,2,Eligible,,20170101",
			"000000001,Jones,John,(416)000-0001,CSC,BSC,1,Eligible,,20170101"
		};

	@Configuration
	static public class ContextConfiguration {
		@Bean
		public ApplicantRepository csvRepoBeanFromFileNamedByDataResource() {
			return (new CsvRepository(Arrays.asList(dummyCsvLinesForJunitTests)));
		}

		@Bean
		public ApplicantsApiController controllerBean() {
			return (new ApplicantsApiController()); 
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
            .andExpect(jsonPath("$.familyname").value("Smith"))
            .andExpect(jsonPath("$.givenname").value("Jane"));
    }
}