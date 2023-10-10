/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.DAO;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author josel
 */
@Entity
@Table(name = "cuentaContable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuentaContable.findAll", query = "SELECT c FROM CuentaContable c"),
    @NamedQuery(name = "CuentaContable.findByIdCuenta", query = "SELECT c FROM CuentaContable c WHERE c.idCuenta = :idCuenta"),
    @NamedQuery(name = "CuentaContable.findByNombreCuenta", query = "SELECT c FROM CuentaContable c WHERE c.nombreCuenta = :nombreCuenta"),
    @NamedQuery(name = "CuentaContable.findByImpuestoInventario", query = "SELECT c FROM CuentaContable c WHERE c.impuestoInventario = :impuestoInventario")})
public class CuentaContable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCuenta")
    private Integer idCuenta;
    @Size(max = 2147483647)
    @Column(name = "nombreCuenta")
    private String nombreCuenta;
    @Column(name = "impuesto_inventario")
    private BigInteger impuestoInventario;
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne
    private Cliente idCliente;
    @JoinColumn(name = "idProveedor", referencedColumnName = "idProveedor")
    @ManyToOne
    private Proveedor idProveedor;

    public CuentaContable() {
    }

    public CuentaContable(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public BigInteger getImpuestoInventario() {
        return impuestoInventario;
    }

    public void setImpuestoInventario(BigInteger impuestoInventario) {
        this.impuestoInventario = impuestoInventario;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuenta != null ? idCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaContable)) {
            return false;
        }
        CuentaContable other = (CuentaContable) object;
        if ((this.idCuenta == null && other.idCuenta != null) || (this.idCuenta != null && !this.idCuenta.equals(other.idCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.umgprogra.erp.DAO.CuentaContable[ idCuenta=" + idCuenta + " ]";
    }
    
}
