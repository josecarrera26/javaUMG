/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.DAO;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "facturacab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturacab.findAll", query = "SELECT f FROM Facturacab f"),
    @NamedQuery(name = "Facturacab.findByIdfactura", query = "SELECT f FROM Facturacab f WHERE f.facturacabPK.idfactura = :idfactura"),
    @NamedQuery(name = "Facturacab.findByFechaRegistro", query = "SELECT f FROM Facturacab f WHERE f.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Facturacab.findByPlazosPago", query = "SELECT f FROM Facturacab f WHERE f.plazosPago = :plazosPago"),
    @NamedQuery(name = "Facturacab.findByReferenciaFactura", query = "SELECT f FROM Facturacab f WHERE f.facturacabPK.referenciaFactura = :referenciaFactura"),
    @NamedQuery(name = "Facturacab.findByIdtipocliente", query = "SELECT f FROM Facturacab f WHERE f.idtipocliente = :idtipocliente"),
    @NamedQuery(name = "Facturacab.findByEstadofac", query = "SELECT f FROM Facturacab f WHERE f.estadofac = :estadofac"),
    @NamedQuery(name = "Facturacab.findByTotal", query = "SELECT f FROM Facturacab f WHERE f.total = :total"),
    @NamedQuery(name = "Facturacab.findByIdtipopago", query = "SELECT f FROM Facturacab f WHERE f.idtipopago = :idtipopago"),
    @NamedQuery(name = "Facturacab.findByNit", query = "SELECT f FROM Facturacab f WHERE f.nit = :nit"),
    @NamedQuery(name = "Facturacab.findByIdtipofactura", query = "SELECT f FROM Facturacab f WHERE f.idtipofactura = :idtipofactura")})
public class Facturacab implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FacturacabPK facturacabPK;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Column(name = "plazos_pago")
    private Integer plazosPago;
    @Column(name = "idtipocliente")
    private Integer idtipocliente;
    @Column(name = "estadofac")
    private Integer estadofac;
    @Column(name = "total")
    private BigInteger total;
    @Column(name = "idtipopago")
    private Integer idtipopago;
    @Size(max = 2147483647)
    @Column(name = "nit")
    private String nit;
    @Column(name = "idtipofactura")
    private Integer idtipofactura;
    @JoinColumn(name = "idempleado", referencedColumnName = "idempleado")
    @ManyToOne
    private Empleado idempleado;
    @JoinColumn(name = "idfactura", referencedColumnName = "idfactura", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Facturadet facturadet;

    public Facturacab() {
    }

    public Facturacab(FacturacabPK facturacabPK) {
        this.facturacabPK = facturacabPK;
    }

    public Facturacab(int idfactura, int referenciaFactura) {
        this.facturacabPK = new FacturacabPK(idfactura, referenciaFactura);
    }

    public FacturacabPK getFacturacabPK() {
        return facturacabPK;
    }

    public void setFacturacabPK(FacturacabPK facturacabPK) {
        this.facturacabPK = facturacabPK;
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

    public Integer getIdtipocliente() {
        return idtipocliente;
    }

    public void setIdtipocliente(Integer idtipocliente) {
        this.idtipocliente = idtipocliente;
    }

    public Integer getEstadofac() {
        return estadofac;
    }

    public void setEstadofac(Integer estadofac) {
        this.estadofac = estadofac;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }

    public Integer getIdtipopago() {
        return idtipopago;
    }

    public void setIdtipopago(Integer idtipopago) {
        this.idtipopago = idtipopago;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Integer getIdtipofactura() {
        return idtipofactura;
    }

    public void setIdtipofactura(Integer idtipofactura) {
        this.idtipofactura = idtipofactura;
    }

    public Empleado getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Empleado idempleado) {
        this.idempleado = idempleado;
    }

    public Facturadet getFacturadet() {
        return facturadet;
    }

    public void setFacturadet(Facturadet facturadet) {
        this.facturadet = facturadet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facturacabPK != null ? facturacabPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturacab)) {
            return false;
        }
        Facturacab other = (Facturacab) object;
        if ((this.facturacabPK == null && other.facturacabPK != null) || (this.facturacabPK != null && !this.facturacabPK.equals(other.facturacabPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.umgprogra.erp.DAO.Facturacab[ facturacabPK=" + facturacabPK + " ]";
    }
    
}
