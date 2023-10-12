/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.DAO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author josel
 */
@Entity
@Table(name = "facturadet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturadet.findAll", query = "SELECT f FROM Facturadet f"),
    @NamedQuery(name = "Facturadet.findByIdtransaccion", query = "SELECT f FROM Facturadet f WHERE f.idtransaccion = :idtransaccion"),
    @NamedQuery(name = "Facturadet.findByCantidad", query = "SELECT f FROM Facturadet f WHERE f.cantidad = :cantidad"),
    @NamedQuery(name = "Facturadet.findByPreciounitario", query = "SELECT f FROM Facturadet f WHERE f.preciounitario = :preciounitario"),
    @NamedQuery(name = "Facturadet.findByIva", query = "SELECT f FROM Facturadet f WHERE f.iva = :iva")})
public class Facturadet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtransaccion")
    private Integer idtransaccion;
    @Column(name = "cantidad")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preciounitario")
    private Double preciounitario;
    @Column(name = "iva")
    private Double iva;
    @JoinColumn(name = "idfactura", referencedColumnName = "idfactura")
    @ManyToOne
    private Facturacab idfactura;
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
    @ManyToOne
    private Inventario idproducto;

    public Facturadet() {
    }

    public Facturadet(Integer idtransaccion) {
        this.idtransaccion = idtransaccion;
    }

    public Integer getIdtransaccion() {
        return idtransaccion;
    }

    public void setIdtransaccion(Integer idtransaccion) {
        this.idtransaccion = idtransaccion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(Double preciounitario) {
        this.preciounitario = preciounitario;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Facturacab getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(Facturacab idfactura) {
        this.idfactura = idfactura;
    }

    public Inventario getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Inventario idproducto) {
        this.idproducto = idproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtransaccion != null ? idtransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturadet)) {
            return false;
        }
        Facturadet other = (Facturadet) object;
        if ((this.idtransaccion == null && other.idtransaccion != null) || (this.idtransaccion != null && !this.idtransaccion.equals(other.idtransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.umgprogra.erp.DAO.Facturadet[ idtransaccion=" + idtransaccion + " ]";
    }
    
}
