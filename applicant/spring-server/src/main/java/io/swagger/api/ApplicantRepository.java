package io.swagger.api;

import java.util.List;

import io.swagger.model.Applicant;
import io.swagger.model.NewApplicant;

public interface ApplicantRepository {

	public List<Applicant> getApplicants();
	public void add(NewApplicant applicant);
	public boolean delete(Long id); //returns true if id valid, perms okay, and deleted.
}

