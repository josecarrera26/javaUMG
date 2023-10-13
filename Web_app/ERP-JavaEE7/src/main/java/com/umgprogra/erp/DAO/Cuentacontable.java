/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.DAO;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author josel
 */
@Entity
@Table(name = "cuentacontable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuentacontable.findAll", query = "SELECT c FROM Cuentacontable c"),
    @NamedQuery(name = "Cuentacontable.findByIdcuentacontable", query = "SELECT c FROM Cuentacontable c WHERE c.idcuentacontable = :idcuentacontable"),
    @NamedQuery(name = "Cuentacontable.findByNombrecuenta", query = "SELECT c FROM Cuentacontable c WHERE c.nombrecuenta = :nombrecuenta"),
    @NamedQuery(name = "Cuentacontable.findByTipocuenta", query = "SELECT c FROM Cuentacontable c WHERE c.tipocuenta = :tipocuenta")})
public class Cuentacontable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcuentacontable")
    private Integer idcuentacontable;
    @Size(max = 2147483647)
    @Column(name = "nombrecuenta")
    private String nombrecuenta;
    @Size(max = 2147483647)
    @Column(name = "tipocuenta")
    private String tipocuenta;
    @OneToMany(mappedBy = "idcuentacontable")
    private Collection<Cliente> clienteCollection;
    @OneToMany(mappedBy = "idcuentacontable")
    private Collection<Proveedor> proveedorCollection;
    @OneToMany(mappedBy = "idcuentacontable")
    private Collection<Inventario> inventarioCollection;

    public Cuentacontable() {
    }

    public Cuentacontable(Integer idcuentacontable) {
        this.idcuentacontable = idcuentacontable;
    }

    public Integer getIdcuentacontable() {
        return idcuentacontable;
    }

    public void setIdcuentacontable(Integer idcuentacontable) {
        this.idcuentacontable = idcuentacontable;
    }

    public String getNombrecuenta() {
        return nombrecuenta;
    }

    public void setNombrecuenta(String nombrecuenta) {
        this.nombrecuenta = nombrecuenta;
    }

    public String getTipocuenta() {
        return tipocuenta;
    }

    public void setTipocuenta(String tipocuenta) {
        this.tipocuenta = tipocuenta;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @XmlTransient
    public Collection<Proveedor> getProveedorCollection() {
        return proveedorCollection;
    }

    public void setProveedorCollection(Collection<Proveedor> proveedorCollection) {
        this.proveedorCollection = proveedorCollection;
    }

    @XmlTransient
    public Collection<Inventario> getInventarioCollection() {
        return inventarioCollection;
    }

    public void setInventarioCollection(Collection<Inventario> inventarioCollection) {
        this.inventarioCollection = inventarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcuentacontable != null ? idcuentacontable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuentacontable)) {
            return false;
        }
        Cuentacontable other = (Cuentacontable) object;
        if ((this.idcuentacontable == null && other.idcuentacontable != null) || (this.idcuentacontable != null && !this.idcuentacontable.equals(other.idcuentacontable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.umgprogra.erp.DAO.Cuentacontable[ idcuentacontable=" + idcuentacontable + " ]";
    }
    
}
