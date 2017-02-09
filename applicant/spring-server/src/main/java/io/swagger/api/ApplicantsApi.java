package io.swagger.api;

import io.swagger.model.Applicant;
import io.swagger.model.ErrorModel;
import io.swagger.model.NewApplicant;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-09T21:50:53.497Z")

@Api(value = "applicants", description = "the applicants API")
public interface ApplicantsApi {

    @ApiOperation(value = "", notes = "Creates a new applicant.  Duplicates are NOT allowed", response = Applicant.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "applicant response", response = Applicant.class),
        @ApiResponse(code = 200, message = "unexpected error", response = Applicant.class) })
    @RequestMapping(value = "/applicants",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Applicant> addApplicant(@ApiParam(value = "applicant to add" ,required=true ) @RequestBody NewApplicant applicant);


    @ApiOperation(value = "", notes = "deletes a single Applicant based on the ID supplied", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "applicant deleted", response = Void.class),
        @ApiResponse(code = 200, message = "unexpected error", response = Void.class) })
    @RequestMapping(value = "/applicants/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteApplicant(@ApiParam(value = "ID of Applicant to delete",required=true ) @PathVariable("id") Long id);


    @ApiOperation(value = "", notes = "Returns all applicants that match name", response = Applicant.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "applicant response", response = Applicant.class),
        @ApiResponse(code = 200, message = "unexpected error", response = Applicant.class) })
    @RequestMapping(value = "/applicants",
        produces = { "application/json", "application/xml", "text/xml", "text/html" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Applicant>> findApplicant(@ApiParam(value = "surname to filter by") @RequestParam(value = "surname", required = false) List<String> surname,
        @ApiParam(value = "maximum number of results to return") @RequestParam(value = "limit", required = false) Integer limit);


    @ApiOperation(value = "", notes = "Returns a user based on a single ID, if the user does not have access to the pet", response = Applicant.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Applicant response", response = Applicant.class),
        @ApiResponse(code = 200, message = "unexpected error", response = Applicant.class) })
    @RequestMapping(value = "/applicants/{id}",
        produces = { "application/json", "application/xml", "text/xml", "text/html" }, 
        method = RequestMethod.GET)
    ResponseEntity<Applicant> findApplicantById(@ApiParam(value = "ID of applicant to fetch",required=true ) @PathVariable("id") Long id);

}
