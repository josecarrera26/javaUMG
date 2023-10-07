/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erpDAO;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author josel
 */
@Entity
@Table(name = "kardex")
@NamedQueries({
    @NamedQuery(name = "Kardex.findAll", query = "SELECT k FROM Kardex k"),
    @NamedQuery(name = "Kardex.findById", query = "SELECT k FROM Kardex k WHERE k.id = :id"),
    @NamedQuery(name = "Kardex.findByVentaCompra", query = "SELECT k FROM Kardex k WHERE k.ventaCompra = :ventaCompra"),
    @NamedQuery(name = "Kardex.findByFecha", query = "SELECT k FROM Kardex k WHERE k.fecha = :fecha"),
    @NamedQuery(name = "Kardex.findByUnidadesOriginales", query = "SELECT k FROM Kardex k WHERE k.unidadesOriginales = :unidadesOriginales"),
    @NamedQuery(name = "Kardex.findByUnidadesVendidas", query = "SELECT k FROM Kardex k WHERE k.unidadesVendidas = :unidadesVendidas"),
    @NamedQuery(name = "Kardex.findByIntOut", query = "SELECT k FROM Kardex k WHERE k.intOut = :intOut")})
public class Kardex implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "venta_compra")
    private Integer ventaCompra;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "unidades_originales")
    private Integer unidadesOriginales;
    @Column(name = "unidades_vendidas")
    private Integer unidadesVendidas;
    @Size(max = 2147483647)
    @Column(name = "int_out")
    private String intOut;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne
    private Inventario idProducto;

    public Kardex() {
    }

    public Kardex(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVentaCompra() {
        return ventaCompra;
    }

    public void setVentaCompra(Integer ventaCompra) {
        this.ventaCompra = ventaCompra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getUnidadesOriginales() {
        return unidadesOriginales;
    }

    public void setUnidadesOriginales(Integer unidadesOriginales) {
        this.unidadesOriginales = unidadesOriginales;
    }

    public Integer getUnidadesVendidas() {
        return unidadesVendidas;
    }

    public void setUnidadesVendidas(Integer unidadesVendidas) {
        this.unidadesVendidas = unidadesVendidas;
    }

    public String getIntOut() {
        return intOut;
    }

    public void setIntOut(String intOut) {
        this.intOut = intOut;
    }

    public Inventario getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Inventario idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kardex)) {
            return false;
        }
        Kardex other = (Kardex) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.umgprogra.erpDAO.Kardex[ id=" + id + " ]";
    }
    
}
