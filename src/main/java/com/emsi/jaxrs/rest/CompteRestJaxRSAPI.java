package com.emsi.jaxrs.rest;

import com.emsi.jaxrs.entities.Compte;
import com.emsi.jaxrs.repositories.CompteRepository;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Path("/banque")
public class CompteRestJaxRSAPI {

    @Autowired
    private CompteRepository compteRepository;

    // READ: Retrieve all accounts (XML only)
    @Path("/comptes")
    @GET
    @Produces(MediaType.APPLICATION_XML) 
    public List<Compte> getComptes() {
        return compteRepository.findAll();
    }

    // READ: Retrieve an account by its ID (XML only)
    @Path("/comptes/{id}")
    @GET
    @Produces(MediaType.APPLICATION_XML) 
    public Compte getCompte(@PathParam("id") Long id) {
        return compteRepository.findById(id).orElse(null);
    }

    // CREATE: Add a new account (XML only)
    @Path("/comptes")
    @POST
    @Consumes(MediaType.APPLICATION_XML) 
    @Produces(MediaType.APPLICATION_XML)
    public Compte addCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    // UPDATE: Update an existing account (XML only)
    @Path("/comptes/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Compte updateCompte(@PathParam("id") Long id, Compte compte) {
        Compte existingCompte = compteRepository.findById(id).orElse(null);
        if (existingCompte != null) {
            existingCompte.setSolde(compte.getSolde());
            existingCompte.setDateCreation(compte.getDateCreation());
            existingCompte.setType(compte.getType());
            return compteRepository.save(existingCompte);
        }
        return null;
    }

    // DELETE: Delete an account (XML only)
    @Path("/comptes/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_XML)
    public void deleteCompte(@PathParam("id") Long id) {
        compteRepository.deleteById(id);
    }
}