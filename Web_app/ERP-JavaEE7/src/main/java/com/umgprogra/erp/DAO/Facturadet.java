/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.DAO;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author josel
 */
@Entity
@Table(name = "facturadet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturadet.findAll", query = "SELECT f FROM Facturadet f"),
    @NamedQuery(name = "Facturadet.findByIdfactura", query = "SELECT f FROM Facturadet f WHERE f.idfactura = :idfactura"),
    @NamedQuery(name = "Facturadet.findByCantidad", query = "SELECT f FROM Facturadet f WHERE f.cantidad = :cantidad"),
    @NamedQuery(name = "Facturadet.findByPreciounitario", query = "SELECT f FROM Facturadet f WHERE f.preciounitario = :preciounitario"),
    @NamedQuery(name = "Facturadet.findByIva", query = "SELECT f FROM Facturadet f WHERE f.iva = :iva")})
public class Facturadet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfactura")
    private Integer idfactura;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "preciounitario")
    private BigInteger preciounitario;
    @Column(name = "iva")
    private BigInteger iva;
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
    @ManyToOne
    private Inventario idproducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturadet")
    private Collection<Facturacab> facturacabCollection;

    public Facturadet() {
    }

    public Facturadet(Integer idfactura) {
        this.idfactura = idfactura;
    }

    public Integer getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(Integer idfactura) {
        this.idfactura = idfactura;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigInteger getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(BigInteger preciounitario) {
        this.preciounitario = preciounitario;
    }

    public BigInteger getIva() {
        return iva;
    }

    public void setIva(BigInteger iva) {
        this.iva = iva;
    }

    public Inventario getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Inventario idproducto) {
        this.idproducto = idproducto;
    }

    @XmlTransient
    public Collection<Facturacab> getFacturacabCollection() {
        return facturacabCollection;
    }

    public void setFacturacabCollection(Collection<Facturacab> facturacabCollection) {
        this.facturacabCollection = facturacabCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfactura != null ? idfactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturadet)) {
            return false;
        }
        Facturadet other = (Facturadet) object;
        if ((this.idfactura == null && other.idfactura != null) || (this.idfactura != null && !this.idfactura.equals(other.idfactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.umgprogra.erp.DAO.Facturadet[ idfactura=" + idfactura + " ]";
    }
    
}
