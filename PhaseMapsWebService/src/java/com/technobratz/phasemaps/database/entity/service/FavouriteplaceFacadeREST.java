
package com.technobratz.phasemaps.database.entity.service;

import com.technobratz.phasemaps.database.entity.Favouriteplace;
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
 * @author Thushini Ranasinghe
 */
@Stateless
@Path("favouriteplace")
public class FavouriteplaceFacadeREST extends AbstractFacade<Favouriteplace> {

    @PersistenceContext(unitName = "PhaseMapsWebServicePU")
    private EntityManager em;

    public FavouriteplaceFacadeREST() {
        super(Favouriteplace.class);
    }

    @POST
    @Override
    @Path("add")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public void create(Favouriteplace entity) {
        super.create(entity);
    }

    @PUT
    @Path("update")
    @Override
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public void edit(Favouriteplace entity) {
        super.edit(entity);
    }

    @PUT
    @Path("delete")
    @Override
    public void remove(Favouriteplace entity) {
        super.remove(super.find(entity.getId()));
    }

    @GET
    @Path("get")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public Favouriteplace find(Favouriteplace entity) {
        return super.find(entity.getId());
    }

    @GET
    @Override
    @Path("getAll")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Favouriteplace> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Favouriteplace> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
