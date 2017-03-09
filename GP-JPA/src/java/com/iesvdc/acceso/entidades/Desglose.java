/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "desglose")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Desglose.findAll", query = "SELECT d FROM Desglose d")
    , @NamedQuery(name = "Desglose.findByPedido", query = "SELECT d FROM Desglose d WHERE d.desglosePK.pedido = :pedido")
    , @NamedQuery(name = "Desglose.findByProducto", query = "SELECT d FROM Desglose d WHERE d.desglosePK.producto = :producto")
    , @NamedQuery(name = "Desglose.findByCantidad", query = "SELECT d FROM Desglose d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "Desglose.findByPrecio", query = "SELECT d FROM Desglose d WHERE d.precio = :precio")})
public class Desglose implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DesglosePK desglosePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private float precio;
    @JoinColumn(name = "pedido", referencedColumnName = "numpedido", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pedido pedido1;
    @JoinColumn(name = "producto", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto1;

    public Desglose() {
    }

    public Desglose(DesglosePK desglosePK) {
        this.desglosePK = desglosePK;
    }

    public Desglose(DesglosePK desglosePK, int cantidad, float precio) {
        this.desglosePK = desglosePK;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Desglose(int pedido, int producto) {
        this.desglosePK = new DesglosePK(pedido, producto);
    }

    public DesglosePK getDesglosePK() {
        return desglosePK;
    }

    public void setDesglosePK(DesglosePK desglosePK) {
        this.desglosePK = desglosePK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Pedido getPedido1() {
        return pedido1;
    }

    public void setPedido1(Pedido pedido1) {
        this.pedido1 = pedido1;
    }

    public Producto getProducto1() {
        return producto1;
    }

    public void setProducto1(Producto producto1) {
        this.producto1 = producto1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (desglosePK != null ? desglosePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Desglose)) {
            return false;
        }
        Desglose other = (Desglose) object;
        if ((this.desglosePK == null && other.desglosePK != null) || (this.desglosePK != null && !this.desglosePK.equals(other.desglosePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iesvdc.acceso.entidades.Desglose[ desglosePK=" + desglosePK + " ]";
    }
    
}
