# csc302-swagger-api

The csc302 TA Assignment System, as described in our project [published google doc](https://docs.google.com/document/d/1mMzftOX5ZxIOPUSbbPDUZ0gfxyL19G214vNByqlELkk/pub) describes an Applicant.

This is meant to imitate a document written by non-technical analysts, and is a useful start, but not detailed enough a definition to describe an endpoint.

A better way of documenting an API is provided by [swagger.io](www.swagger.io) which describes a standard for describing API as well as a set of tools for: 

* editing API documents
* displaying the API
* generating servers from the API
* generating clients from the API

The applicants directory contains a file, applicants-swagger-api.yml, which describes an Applicant "model".

See the README.md there for detailed instructions for how to use this file

The idea here is that a front end and backend team negotiates a yaml file, and then uses swagger to generate so-called stub code for whatever client and server technology you are planning to use.









