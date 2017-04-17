/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technobratz.phasemaps.database.entity.service;

import com.technobratz.phasemaps.database.entity.Travellog;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author DELL
 */
@Stateless
@Path("travellog")
public class TravellogFacadeREST extends AbstractFacade<Travellog> {

    @PersistenceContext(unitName = "PhaseMapsWebServicePU")
    private EntityManager em;

    public TravellogFacadeREST() {
        super(Travellog.class);
    }

    @POST
    @Override
    @Path("add")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public void create(Travellog entity) {
        super.create(entity);
    }

    @PUT
    @Path("update")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    @Override
    public void edit(Travellog entity) {
        super.edit(entity);
    }

    @PUT
    @Path("delete")
    @Override
    public void remove(Travellog entity) {
        super.remove(super.find(entity.getId()));
    }

    @GET
    @Path("get")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public Travellog find(Travellog entity) {
        return super.find(entity.getId());
    }

    @GET
    @Override
    @Path("getAll")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Travellog> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Travellog> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
