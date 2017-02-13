package io.swagger.api;

import java.util.List;

import io.swagger.model.Applicant;
import io.swagger.model.NewApplicant;

public interface ApplicantRepository {

	public List<Applicant> getApplicants();
	public void add(NewApplicant applicant);
	public void delete(Long id);
}

