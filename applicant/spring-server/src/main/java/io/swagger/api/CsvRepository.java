package io.swagger.api;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import io.swagger.model.Applicant;


@Component
public class CsvRepository implements ApplicantRepository {
	
	private final List<Applicant> applicants;
	
	public CsvRepository(@Value("${data.source}") String dataPath) {
		List<Applicant> _applicants = null;
		try {
			String absolutePath = getClass().getClassLoader().getResource(dataPath).getFile();
			//System.out.println(absolutePath);
			//System.out.println(new File(absolutePath).toPath());
			System.out.println(	Files.readAllLines(new File(absolutePath).toPath()));
			List<String> xx =	Files.readAllLines(new File(absolutePath).toPath());
			for(String s:xx){
				System.out.println(s);
			}
			System.out.println(xx.stream());
			_applicants =
					Files.readAllLines(new File(absolutePath).toPath())
					.stream()
					.map(this::parseCsvStringToApplicant)
//					.filter(x -> null != x)
					.collect(Collectors.toList());
		} catch (IOException e) {
			_applicants = new ArrayList<Applicant>();
		}
		applicants = _applicants;
	}
	
	public List<Applicant> getApplicants() {
		return this.applicants;
	}
	
	private Applicant parseCsvStringToApplicant(String csvString) {
		List<String> fields = Arrays.asList(csvString.split(","));
		if (fields.size() == 10) {
			Applicant applicant = new Applicant();
			applicant.setStudentnumber(Integer.getInteger(fields.get(0)));
			applicant.setFamilyname(fields.get(1));
			applicant.setGivenname(fields.get(2));
			applicant.setPhonenumber(fields.get(3));
			applicant.setStudentdepartment(fields.get(4));
			applicant.setProgram(fields.get(5));
			applicant.setYear(new Integer(fields.get(6)).intValue());
			applicant.setWorkstatus(fields.get(7));
			applicant.setWorkstatusexplain(fields.get(8));
			applicant.setDateofapplication(fields.get(9));
			return applicant;
		}
		else {
			return null;
		}
	}

}

