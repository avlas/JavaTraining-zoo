/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zoo.rest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.zoo.model.animals.Animal;
import com.zoo.service.animals.AnimalsService;

/**
 * This class produces a RESTful service to read/write the contents of the animals table.
 */
@Path("/animals")
@RequestScoped
public class AnimalResourceRESTService {

    @Inject
    private Logger log;

    @Inject
    private Validator validator;

    @Inject
    AnimalsService service;

    /**
     * Creates a new animal from the values provided. Performs validation, and will return a JAX-RS response with either 200 ok,
     * or with a map of fields, and related errors.
     */
	//http://localhost:8180/zoo/rest/animals
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAnimal(Animal animal) {

        Response.ResponseBuilder builder = null;

        try {
            validateAnimal(animal);

            service.saveAnimal(animal);

            // Create an "ok" response
            builder = Response.ok();
        } catch (ConstraintViolationException ce) {
            // Handle bean validation issues
            builder = createViolationResponse(ce.getConstraintViolations());
        } catch (Exception e) {
            // Handle generic exceptions
            Map<String, String> responseObj = new HashMap<String, String>();
            responseObj.put("error", e.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }

        return builder.build();
    }

	//http://localhost:8180/zoo/rest/animals
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Animal> listAllAnimals() {
    	return service.findAnimals();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String listAllAnimalsXML() {
    	StringBuffer bf = new StringBuffer();
    	for (Animal a  : service.findAnimals()) {
    		bf.append(a.getName());
    		bf.append("\n---\n");
    	}
        return bf.toString();
    }

	//http://localhost:8180/zoo/rest/animals?diet=CARNIVORE
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Animal> listAnimalsByDiet(@QueryParam("diet") String diet) {
    	return service.findAnimalsByDiet(diet);
    }

    //http://localhost:8180/zoo/rest/animals/2
    @GET
    @Path("/{id:[0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Animal findAnimalById(@PathParam("id") int id) {
        Animal animal = service.findById(id);
        if (animal == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return animal;
    }

      private void validateAnimal(Animal animal) throws ConstraintViolationException, ValidationException {
        // Create a bean validator and check for issues.
        Set<ConstraintViolation<Animal>> violations = validator.validate(animal);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
        }
    }

    /**
     * Creates a JAX-RS "Bad Request" response including a map of all violation fields, and their message. This can then be used
     * by clients to show violations.
     *
     * @param violations A set of violations that needs to be reported
     * @return JAX-RS response containing all violations
     */
    private Response.ResponseBuilder createViolationResponse(Set<ConstraintViolation<?>> violations) {
        log.fine("Validation completed. violations found: " + violations.size());

        Map<String, String> responseObj = new HashMap<String, String>();

        for (ConstraintViolation<?> violation : violations) {
            responseObj.put(violation.getPropertyPath().toString(), violation.getMessage());
        }

        return Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
    }
}
