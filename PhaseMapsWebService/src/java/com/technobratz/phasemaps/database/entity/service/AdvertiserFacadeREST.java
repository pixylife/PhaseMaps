/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technobratz.phasemaps.database.entity.service;

import com.technobratz.phasemaps.database.entity.Advertiser;
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
@Path("advertiser")
public class AdvertiserFacadeREST extends AbstractFacade<Advertiser> {

    @PersistenceContext(unitName = "PhaseMapsWebServicePU")
    private EntityManager em;

    public AdvertiserFacadeREST() {
        super(Advertiser.class);
    }

    @POST
    @Override
    @Path("add")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public void create(Advertiser entity) {
        super.create(entity);
    }

    @PUT
    @Path("update")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    @Override
    public void edit(Advertiser entity) {
        super.edit(entity);
    }

    @PUT
    @Path("delete")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    @Override
    public void remove(Advertiser entity) {
        super.remove(super.find(entity.getIdadvertiser()));
    }

    @GET
    @Path("get")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public Advertiser find(Advertiser entity) {
        return super.find(entity.getIdadvertiser());
    }

    @GET
    @Override    
    @Path("getAll")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Advertiser> findAll() {
        return super.findAll();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
