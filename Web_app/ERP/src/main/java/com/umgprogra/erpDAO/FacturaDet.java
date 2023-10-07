/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erpDAO;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author josel
 */
@Entity
@Table(name = "facturaDet")
@NamedQueries({
    @NamedQuery(name = "FacturaDet.findAll", query = "SELECT f FROM FacturaDet f"),
    @NamedQuery(name = "FacturaDet.findByIdFactura", query = "SELECT f FROM FacturaDet f WHERE f.idFactura = :idFactura"),
    @NamedQuery(name = "FacturaDet.findByCantidad", query = "SELECT f FROM FacturaDet f WHERE f.cantidad = :cantidad"),
    @NamedQuery(name = "FacturaDet.findByPrecioUnitario", query = "SELECT f FROM FacturaDet f WHERE f.precioUnitario = :precioUnitario"),
    @NamedQuery(name = "FacturaDet.findByIva", query = "SELECT f FROM FacturaDet f WHERE f.iva = :iva"),
    @NamedQuery(name = "FacturaDet.findByIdProducto", query = "SELECT f FROM FacturaDet f WHERE f.idProducto = :idProducto")})
public class FacturaDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFactura")
    private Integer idFactura;
    @Column(name = "cantidad")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_Unitario")
    private Double precioUnitario;
    @Column(name = "iva")
    private Double iva;
    @Column(name = "idProducto")
    private Integer idProducto;
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

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

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
        return "com.umgprogra.erpDAO.FacturaDet[ idFactura=" + idFactura + " ]";
    }
    
}
