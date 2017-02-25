package io.swagger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import io.swagger.api.ApplicantRepository;
import io.swagger.api.CsvRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan

@EnableSwagger2
@ComponentScan(basePackages = "io.swagger")
public class Swagger2SpringBoot implements CommandLineRunner {

	// This configuration just for our dummy example api app. It arranges that the container wires up 
	// applicant repo from our starter CSV file.
	// TODO: research/ask around to find out if is appropriate according to conventions
	@Configuration 
	static public class ContextConfiguration {
		@Bean
		@Primary
		public ApplicantRepository csvRepoBeanFromFileNamedByDataResource() {
			// there exists a system property set in src/main/resources/application.properties
			// naming the csv file containing the mock data.
			// TODO: figure out how to prod Spring int injecting the value of the property here using  @Value("${data.source}")
			// @Value("${data.source}") //giving up on @Value business for now
			final String datapath = "applicants.csv";
			return (new CsvRepository(datapath));
		}
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		if (arg0.length > 0 && arg0[0].equals("exitcode")) {
			throw new ExitException();
		}
	}

	public static void main(String[] args) throws Exception {
		new SpringApplication(Swagger2SpringBoot.class).run(args);
	}

	class ExitException extends RuntimeException implements ExitCodeGenerator {
		private static final long serialVersionUID = 1L;

		@Override
		public int getExitCode() {
			return 10;
		}

	}
}
