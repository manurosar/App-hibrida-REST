/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")
    , @NamedQuery(name = "Pedido.findByNumpedido", query = "SELECT p FROM Pedido p WHERE p.numpedido = :numpedido")
    , @NamedQuery(name = "Pedido.findByFecha", query = "SELECT p FROM Pedido p WHERE p.fecha = :fecha")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numpedido")
    private Integer numpedido;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    @ManyToOne
    private Cliente cliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido1")
    private Collection<Desglose> desgloseCollection;

    public Pedido() {
    }

    public Pedido(Integer numpedido) {
        this.numpedido = numpedido;
    }

    public Integer getNumpedido() {
        return numpedido;
    }

    public void setNumpedido(Integer numpedido) {
        this.numpedido = numpedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @XmlTransient
    public Collection<Desglose> getDesgloseCollection() {
        return desgloseCollection;
    }

    public void setDesgloseCollection(Collection<Desglose> desgloseCollection) {
        this.desgloseCollection = desgloseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numpedido != null ? numpedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.numpedido == null && other.numpedido != null) || (this.numpedido != null && !this.numpedido.equals(other.numpedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iesvdc.acceso.entidades.Pedido[ numpedido=" + numpedido + " ]";
    }
    
}
