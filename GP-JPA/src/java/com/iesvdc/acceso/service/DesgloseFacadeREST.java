/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.service;

import com.iesvdc.acceso.entidades.Desglose;
import com.iesvdc.acceso.entidades.DesglosePK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
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
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author User
 */
@Stateless
@Path("com.iesvdc.acceso.entidades.desglose")
public class DesgloseFacadeREST extends AbstractFacade<Desglose> {

    @PersistenceContext(unitName = "GP-JPAPU")
    private EntityManager em;

    private DesglosePK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;pedido=pedidoValue;producto=productoValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.iesvdc.acceso.entidades.DesglosePK key = new com.iesvdc.acceso.entidades.DesglosePK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> pedido = map.get("pedido");
        if (pedido != null && !pedido.isEmpty()) {
            key.setPedido(new java.lang.Integer(pedido.get(0)));
        }
        java.util.List<String> producto = map.get("producto");
        if (producto != null && !producto.isEmpty()) {
            key.setProducto(new java.lang.Integer(producto.get(0)));
        }
        return key;
    }

    public DesgloseFacadeREST() {
        super(Desglose.class);
         this.em = Persistence.createEntityManagerFactory("GP-JPAPU").createEntityManager();
    

    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Desglose entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Desglose entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.iesvdc.acceso.entidades.DesglosePK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Desglose find(@PathParam("id") PathSegment id) {
        com.iesvdc.acceso.entidades.DesglosePK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Desglose> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Desglose> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
