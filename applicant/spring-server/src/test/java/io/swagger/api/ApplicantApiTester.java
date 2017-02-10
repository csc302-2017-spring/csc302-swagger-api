package io.swagger.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import io.swagger.Swagger2SpringBoot;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@SpringBootTest(classes = Swagger2SpringBoot.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@WebMvcTest(ApplicantsApiController.class)
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = Swagger2SpringBoot.class, loader = SpringApplicationContextLoader.class)
public class ApplicantApiTester extends AbstractTestNGSpringContextTests {

//    @Autowired
//    private MockMvc mockMvc;
//
//	@Autowired
//	ApplicantsApiController victim;
//
//    @Before
//    public void setup() {
//    	this.mockMvc = MockMvcBuilders.standaloneSetup(new ApplicantsApiController()).build();
//    }
//
//	@Test
//	public void test() throws Exception {
//		 this.mockMvc.perform(get("/").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
//         .andExpect(status().isOk())
//         .andExpect(content().contentType("application/json"));
//	}
}
