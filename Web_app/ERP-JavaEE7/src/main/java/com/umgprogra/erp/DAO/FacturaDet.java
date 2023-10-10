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
@Table(name = "facturaDet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturaDet.findAll", query = "SELECT f FROM FacturaDet f"),
    @NamedQuery(name = "FacturaDet.findByIdFactura", query = "SELECT f FROM FacturaDet f WHERE f.idFactura = :idFactura"),
    @NamedQuery(name = "FacturaDet.findByCantidad", query = "SELECT f FROM FacturaDet f WHERE f.cantidad = :cantidad"),
    @NamedQuery(name = "FacturaDet.findByPrecioUnitario", query = "SELECT f FROM FacturaDet f WHERE f.precioUnitario = :precioUnitario"),
    @NamedQuery(name = "FacturaDet.findByIva", query = "SELECT f FROM FacturaDet f WHERE f.iva = :iva")})
public class FacturaDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFactura")
    private Integer idFactura;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "precioUnitario")
    private BigInteger precioUnitario;
    @Column(name = "iva")
    private BigInteger iva;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne
    private Inventario idProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturaDet")
    private Collection<FacturaCab> facturaCabCollection;

    public FacturaDet() {
    }

    public FacturaDet(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigInteger getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigInteger precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigInteger getIva() {
        return iva;
    }

    public void setIva(BigInteger iva) {
        this.iva = iva;
    }

    public Inventario getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Inventario idProducto) {
        this.idProducto = idProducto;
    }

    @XmlTransient
    public Collection<FacturaCab> getFacturaCabCollection() {
        return facturaCabCollection;
    }

    public void setFacturaCabCollection(Collection<FacturaCab> facturaCabCollection) {
        this.facturaCabCollection = facturaCabCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaDet)) {
            return false;
        }
        FacturaDet other = (FacturaDet) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.umgprogra.erp.DAO.FacturaDet[ idFactura=" + idFactura + " ]";
    }
    
}
