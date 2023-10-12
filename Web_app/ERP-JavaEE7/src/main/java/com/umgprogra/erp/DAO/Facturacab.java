/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.DAO;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author josel
 */
@Entity
@Table(name = "facturacab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturacab.findAll", query = "SELECT f FROM Facturacab f"),
    @NamedQuery(name = "Facturacab.findByIdfactura", query = "SELECT f FROM Facturacab f WHERE f.idfactura = :idfactura"),
    @NamedQuery(name = "Facturacab.findByFechaRegistro", query = "SELECT f FROM Facturacab f WHERE f.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Facturacab.findByPlazosPago", query = "SELECT f FROM Facturacab f WHERE f.plazosPago = :plazosPago"),
    @NamedQuery(name = "Facturacab.findByReferenciaFactura", query = "SELECT f FROM Facturacab f WHERE f.referenciaFactura = :referenciaFactura"),
    @NamedQuery(name = "Facturacab.findByIdtipocliente", query = "SELECT f FROM Facturacab f WHERE f.idtipocliente = :idtipocliente"),
    @NamedQuery(name = "Facturacab.findByEstadofac", query = "SELECT f FROM Facturacab f WHERE f.estadofac = :estadofac"),
    @NamedQuery(name = "Facturacab.findByTotal", query = "SELECT f FROM Facturacab f WHERE f.total = :total"),
    @NamedQuery(name = "Facturacab.findByIdtipopago", query = "SELECT f FROM Facturacab f WHERE f.idtipopago = :idtipopago"),
    @NamedQuery(name = "Facturacab.findByNit", query = "SELECT f FROM Facturacab f WHERE f.nit = :nit"),
    @NamedQuery(name = "Facturacab.findByIdtipofactura", query = "SELECT f FROM Facturacab f WHERE f.idtipofactura = :idtipofactura")})
public class Facturacab implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfactura")
    private Integer idfactura;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Column(name = "plazos_pago")
    private Integer plazosPago;
    @Basic(optional = false)
    @Column(name = "referencia_factura")
    private int referenciaFactura;
    @Column(name = "idtipocliente")
    private Integer idtipocliente;
    @Column(name = "estadofac")
    private Integer estadofac;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private Double total;
    @Column(name = "idtipopago")
    private Integer idtipopago;
    @Size(max = 2147483647)
    @Column(name = "nit")
    private String nit;
    @Column(name = "idtipofactura")
    private Integer idtipofactura;
    @OneToMany(mappedBy = "idfactura")
    private Collection<Facturadet> facturadetCollection;
    @JoinColumn(name = "idempleado", referencedColumnName = "idempleado")
    @ManyToOne
    private Empleado idempleado;

    public Facturacab() {
    }

    public Facturacab(Integer idfactura) {
        this.idfactura = idfactura;
    }

    public Facturacab(Integer idfactura, int referenciaFactura) {
        this.idfactura = idfactura;
        this.referenciaFactura = referenciaFactura;
    }

    public Integer getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(Integer idfactura) {
        this.idfactura = idfactura;
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

    public int getReferenciaFactura() {
        return referenciaFactura;
    }

    public void setReferenciaFactura(int referenciaFactura) {
        this.referenciaFactura = referenciaFactura;
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
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

    @XmlTransient
    public Collection<Facturadet> getFacturadetCollection() {
        return facturadetCollection;
    }

    public void setFacturadetCollection(Collection<Facturadet> facturadetCollection) {
        this.facturadetCollection = facturadetCollection;
    }

    public Empleado getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Empleado idempleado) {
        this.idempleado = idempleado;
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
        if (!(object instanceof Facturacab)) {
            return false;
        }
        Facturacab other = (Facturacab) object;
        if ((this.idfactura == null && other.idfactura != null) || (this.idfactura != null && !this.idfactura.equals(other.idfactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.umgprogra.erp.DAO.Facturacab[ idfactura=" + idfactura + " ]";
    }
    
}
