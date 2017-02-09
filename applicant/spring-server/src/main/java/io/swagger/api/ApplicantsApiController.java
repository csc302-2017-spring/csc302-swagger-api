package io.swagger.api;

import io.swagger.model.Applicant;
import io.swagger.model.ErrorModel;
import io.swagger.model.NewApplicant;

import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;



@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-06T01:48:27.968Z")

@Controller
public class ApplicantsApiController implements ApplicantsApi {

	@Autowired
	private ApplicantRepository applicantRepository;

    public ResponseEntity<Applicant> addApplicant(@ApiParam(value = "applicant to add" ,required=true ) @RequestBody NewApplicant applicant) {
        return new ResponseEntity<Applicant>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteApplicant(@ApiParam(value = "ID of Applicant to delete",required=true ) @PathVariable("id") Long id) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<Applicant>> findApplicant(
    		@ApiParam(value = "surname to filter by") @RequestParam(value = "surname", required = false) List<String> surname,
    		@ApiParam(value = "maximum number of results to return") @RequestParam(value = "limit", required = false) Integer limit
    		) {
        // do some magic!
    	if ( surname != null ){ 
	    	String filter_by = surname.get(0);
	    	List <Applicant> filtered_by_surname = new ArrayList<Applicant>(); 
	    	for(Applicant a: applicantRepository.getApplicants()){
	    		if (a.getFamilyname().equals(filter_by)){
	    			filtered_by_surname.add(a);
	    		}
	    	}
	    	return new ResponseEntity<List<Applicant>>(filtered_by_surname, HttpStatus.OK);
    	}else{
    		return new ResponseEntity<List<Applicant>>(applicantRepository.getApplicants(), HttpStatus.OK);
    	}
    }

    public ResponseEntity<Applicant> findApplicantById(@ApiParam(value = "ID of applicant to fetch",required=true ) @PathVariable("id") Long id) {
        // do some magic!
        return new ResponseEntity<Applicant>(HttpStatus.OK);
    }

}
