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
import io.swagger.model.NewApplicant;


@Component
public class CsvRepository implements ApplicantRepository {
	
	int id; //oid for each applicant 
	private final List<Applicant> applicants;
	
	//TODO: figure out how to use @Value to push in data.source property
	@Value("${data.source}")
	private String datapath;
		
	public CsvRepository setDatapath(String dp){
		this.datapath = dp;
		this.id = 0;
		return this;
	}

	public CsvRepository() {
		List<Applicant> _applicants = null;
		
		try {
			if (this.datapath == null){
				System.out.println("sigh, i guess I don't understand this @Value stuff");
				this.datapath = "applicants.csv";
			}
			String absolutePath = getClass().getClassLoader().getResource(this.datapath).getFile();
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
					.map(this::parseCsvStringToApplicant) //how to add id too?
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
		//TODO: use builder pattern to DRY this up
		if (fields.size() == 10) {
			Applicant newApplicant = new Applicant();
			newApplicant.setId(this.id++);
			newApplicant.setStudentnumber(Integer.getInteger(fields.get(0)));
			newApplicant.setFamilyname(fields.get(1));
			newApplicant.setGivenname(fields.get(2));
			newApplicant.setPhonenumber(fields.get(3));
			newApplicant.setStudentdepartment(fields.get(4));
			newApplicant.setProgram(fields.get(5));
			newApplicant.setYear(new Integer(fields.get(6)).intValue());
			newApplicant.setWorkstatus(fields.get(7));
			newApplicant.setWorkstatusexplain(fields.get(8));
			newApplicant.setDateofapplication(fields.get(9));
			return newApplicant;
		}
		else {
			return null;
		}
	}

	private void addNewOne(Applicant newApplicant){
		//into list, with id
		newApplicant.setId(this.id++);
		this.applicants.add(newApplicant);
	}
	
	public void addNewApplicant(NewApplicant newa){
		Applicant a = new Applicant();
		//TODO:ask dustin if is a slick way of doing this sort of copying in Java
		a.setStudentnumber(newa.getStudentnumber());				
		a.setFamilyname(newa.getFamilyname());
		a.setGivenname(newa.getGivenname());
		a.setPhonenumber(newa.getPhonenumber());
		a.setStudentdepartment(newa.getStudentdepartment());
		a.setProgram(newa.getProgram());
		a.setYear(newa.getYear());
		a.setWorkstatus(newa.getWorkstatus());
		a.setWorkstatusexplain(newa.getWorkstatusexplain());
		a.setDateofapplication(newa.getDateofapplication());
		addNewOne(a);
	}
	@Override
	public void add(NewApplicant newApplicant) {
		assert( newApplicant != null);
		addNewApplicant(newApplicant);
	}

}

