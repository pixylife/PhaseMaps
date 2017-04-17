
package com.technobratz.phasemaps.database.entity.service;

import com.technobratz.phasemaps.database.entity.review;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Thushini Ranasinghe
 */
@Stateless
@Path("review")
public class reviewFacadeREST extends AbstractFacade<review> {

    @PersistenceContext(unitName = "PhaseMapsWebServicePU")
    private EntityManager em;

    public reviewFacadeREST() {
        super(review.class);
    }

    @POST
    @Path("add")
    @Override
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public void create(review entity) {
        super.create(entity);
    }

    @PUT
    @Path("update")
    @Override
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public void edit(review entity) {
        super.edit(entity);
    }

    @PUT
    @Override
    @Path("delete")
    public void remove(review entity) {
        super.remove(super.find(entity.getId()));
    }

    @GET
    @Path("get")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public review find(review entity) {
        return super.find(entity.getId());
    }

    @GET
    @Override
    @Path("getAll")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<review> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<review> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
