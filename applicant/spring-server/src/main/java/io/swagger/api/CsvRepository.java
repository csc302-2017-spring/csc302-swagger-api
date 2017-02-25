package io.swagger.api;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.swagger.model.Applicant;
import io.swagger.model.NewApplicant;


/**
 * @author mzaleski
 * CvsRepository is meant to serve as a dummy implementation of a collection of Applicants underlying the applicant API.
 * A useful API would be backed by a database, but this one is loaded up from a CSV (comma separated value) file.
 * Also, for test purposes (eg from junit), it can be initialized by a list of strings. 
 */
@Component
public class CsvRepository implements ApplicantRepository {
	
	long id; //oid for each applicant 
	private final List<Applicant> applicants;
	
	//TODO: figure out how to use @Value to push in data.source property
	@Value("${data.source}")
	private String datapath;

	public CsvRepository() {
		//TODO: Research why need default constructor. added because container was attempting to use it.
		this.applicants = null;
	}

	
	/**
	 * Constructor passed name of java resource which names the CSV file we read Applicants from
	 * @param resourcePathOfCsvFile
	 */
	public CsvRepository(String resourcePathOfCsvFile){
		List<Applicant> _applicants = null;
		try {
			String absolutePath = getClass().getClassLoader().getResource(resourcePathOfCsvFile).getFile();
			_applicants = init(Files.readAllLines(new File(absolutePath).toPath()));
		} catch (IOException e) {
			_applicants = init(new ArrayList<String>());
		}
		this.applicants = _applicants;
	}
	
	/**
	 * Constructor passed list of CSV strings that Applicant names can be read from. For Junits. 
	 * @param dummyCsvLines
	 */
	public CsvRepository(List<String> dummyCsvLines){
		this.applicants = init(dummyCsvLines);
	}
	

	public List<Applicant> init(List<String>lines){
		return	lines
				.stream()
				.map(this::parseCsvStringToApplicant) //how to add id too?
				.collect(Collectors.toList());
	}

	public CsvRepository setDatapath(String filename){
		this.datapath = filename;
		return this;
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

	public boolean delete(Long id){
		for(Applicant a: applicants){
			if (a.getId() == id){
				applicants.remove(a);
				return true;
			}
		}
		return false; //failed to find it
	}

	@Override
	public Applicant find(Long id) {
		for(Applicant a: applicants){
			if (a.getId() == id){
				return a;
			}
		}
		return null; //not found
	}
	
}

