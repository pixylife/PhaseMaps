/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technobratz.phasemaps.database.entity.service;

import com.technobratz.phasemaps.database.entity.Beacon;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author DELL
 */
@Stateless
@Path("beacon")
public class BeaconFacadeREST extends AbstractFacade<Beacon> {

    @PersistenceContext(unitName = "PhaseMapsWebServicePU")
    private EntityManager em;

    public BeaconFacadeREST() {
        super(Beacon.class);
    }

    @POST
    @Override    
    @Path("add")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public void create(Beacon entity) {
        System.out.println(entity.toString());
        super.create(entity);
    }

    @PUT
    @Path("update")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    @Override
    public void edit(Beacon entity) {
        super.edit(entity);
    }

    @PUT
    @Path("delete")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    @Override    
    public void remove(Beacon entity) {
        super.remove(super.find(entity.getIdBeacon()));
    }

    @GET
    @Path("get")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public Beacon find(Beacon entity) {
        return super.find(entity.getIdBeacon());
    }

    @GET
    @Override
    @Path("getAll")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Beacon> findAll() {
        return super.findAll();
    }
    @PUT
    @Path("test")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String test(Beacon entity) {
        System.out.println(entity.getLatitude() +" "+entity.getLongitude());
        return "Tahike wada wada: "+entity.getLatitude() +" "+entity.getLongitude();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
