package io.swagger.api;

import java.util.List;

import io.swagger.model.Applicant;

public interface ApplicantRepository {

	public List<Applicant> getApplicants();
	public void add(Applicant applicant);
}

