
package com.example.rest;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import com.example.metier.Compte;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/TP3/banque")
public class BanqueRESTService {

    @GET
    @Path("/conversion/{mt}")
    @Produces(MediaType.APPLICATION_JSON)
    public double conversion(@PathParam("mt") double mt) {
        return mt*2.5;
    }

    @GET
    @Path("/comptes/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Compte consulterCompte(@PathParam("code") int code) {
        return new Compte(code, 1000, LocalDate.of(2015, Month.APRIL, 1));
    }

    @GET
    @Path("/comptes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Compte> listComptes() {
        return List.of(
            new Compte(1, 1000, LocalDate.of(2015, Month.APRIL, 1)),
            new Compte(2, 2500, LocalDate.of(2018, Month.AUGUST, 10)),
            new Compte(3, 10000, LocalDate.of(2016, Month.JULY, 2)),
            new Compte(4, 19900, LocalDate.of(2010, Month.APRIL, 26))
            );
    }
}