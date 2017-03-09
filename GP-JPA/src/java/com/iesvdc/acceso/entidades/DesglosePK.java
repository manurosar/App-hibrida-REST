/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author User
 */
@Embeddable
public class DesglosePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "pedido")
    private int pedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "producto")
    private int producto;

    public DesglosePK() {
    }

    public DesglosePK(int pedido, int producto) {
        this.pedido = pedido;
        this.producto = producto;
    }

    public int getPedido() {
        return pedido;
    }

    public void setPedido(int pedido) {
        this.pedido = pedido;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pedido;
        hash += (int) producto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DesglosePK)) {
            return false;
        }
        DesglosePK other = (DesglosePK) object;
        if (this.pedido != other.pedido) {
            return false;
        }
        if (this.producto != other.producto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iesvdc.acceso.entidades.DesglosePK[ pedido=" + pedido + ", producto=" + producto + " ]";
    }
    
}
