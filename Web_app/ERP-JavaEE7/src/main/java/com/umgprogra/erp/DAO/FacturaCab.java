/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.DAO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author josel
 */
@Entity
@Table(catalog = "prograproyecto", schema = "erp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturaCab.findAll", query = "SELECT f FROM FacturaCab f"),
    @NamedQuery(name = "FacturaCab.findByIdFactura", query = "SELECT f FROM FacturaCab f WHERE f.facturaCabPK.idFactura = :idFactura"),
    @NamedQuery(name = "FacturaCab.findByFechaRegistro", query = "SELECT f FROM FacturaCab f WHERE f.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "FacturaCab.findByPlazosPago", query = "SELECT f FROM FacturaCab f WHERE f.plazosPago = :plazosPago"),
    @NamedQuery(name = "FacturaCab.findByReferenciaFactura", query = "SELECT f FROM FacturaCab f WHERE f.facturaCabPK.referenciaFactura = :referenciaFactura"),
    @NamedQuery(name = "FacturaCab.findByIdTipoCliente", query = "SELECT f FROM FacturaCab f WHERE f.idTipoCliente = :idTipoCliente"),
    @NamedQuery(name = "FacturaCab.findByEstadoFac", query = "SELECT f FROM FacturaCab f WHERE f.estadoFac = :estadoFac"),
    @NamedQuery(name = "FacturaCab.findByTotal", query = "SELECT f FROM FacturaCab f WHERE f.total = :total"),
    @NamedQuery(name = "FacturaCab.findByIdTipoPago", query = "SELECT f FROM FacturaCab f WHERE f.idTipoPago = :idTipoPago"),
    @NamedQuery(name = "FacturaCab.findByNit", query = "SELECT f FROM FacturaCab f WHERE f.nit = :nit"),
    @NamedQuery(name = "FacturaCab.findByIdTipoFactura", query = "SELECT f FROM FacturaCab f WHERE f.idTipoFactura = :idTipoFactura")})
public class FacturaCab implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FacturaCabPK facturaCabPK;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Column(name = "plazos_pago")
    private Integer plazosPago;
    private Integer idTipoCliente;
    private Integer estadoFac;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 17, scale = 17)
    private Double total;
    private Integer idTipoPago;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String nit;
    private Integer idTipoFactura;
    @JoinColumn(name = "idEmpleado", referencedColumnName = "idEmpleado")
    @ManyToOne
    private Empleado idEmpleado;
    @JoinColumn(name = "idFactura", referencedColumnName = "idFactura", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FacturaDet facturaDet;

    public FacturaCab() {
    }

    public FacturaCab(FacturaCabPK facturaCabPK) {
        this.facturaCabPK = facturaCabPK;
    }

    public FacturaCab(int idFactura, String referenciaFactura) {
        this.facturaCabPK = new FacturaCabPK(idFactura, referenciaFactura);
    }

    public FacturaCabPK getFacturaCabPK() {
        return facturaCabPK;
    }

    public void setFacturaCabPK(FacturaCabPK facturaCabPK) {
        this.facturaCabPK = facturaCabPK;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getPlazosPago() {
        return plazosPago;
    }

    public void setPlazosPago(Integer plazosPago) {
        this.plazosPago = plazosPago;
    }

    public Integer getIdTipoCliente() {
        return idTipoCliente;
    }

    public void setIdTipoCliente(Integer idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
    }

    public Integer getEstadoFac() {
        return estadoFac;
    }

    public void setEstadoFac(Integer estadoFac) {
        this.estadoFac = estadoFac;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(Integer idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Integer getIdTipoFactura() {
        return idTipoFactura;
    }

    public void setIdTipoFactura(Integer idTipoFactura) {
        this.idTipoFactura = idTipoFactura;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public FacturaDet getFacturaDet() {
        return facturaDet;
    }

    public void setFacturaDet(FacturaDet facturaDet) {
        this.facturaDet = facturaDet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facturaCabPK != null ? facturaCabPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaCab)) {
            return false;
        }
        FacturaCab other = (FacturaCab) object;
        if ((this.facturaCabPK == null && other.facturaCabPK != null) || (this.facturaCabPK != null && !this.facturaCabPK.equals(other.facturaCabPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.umgprogra.erp.DAO.FacturaCab[ facturaCabPK=" + facturaCabPK + " ]";
    }
    
}
