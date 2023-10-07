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
@Table(catalog = "prograproyecto", schema = "erp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p"),
    @NamedQuery(name = "Proveedor.findByIdProveedor", query = "SELECT p FROM Proveedor p WHERE p.idProveedor = :idProveedor"),
    @NamedQuery(name = "Proveedor.findByNombreProveedor", query = "SELECT p FROM Proveedor p WHERE p.nombreProveedor = :nombreProveedor"),
    @NamedQuery(name = "Proveedor.findByDireccion", query = "SELECT p FROM Proveedor p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Proveedor.findByTelefono", query = "SELECT p FROM Proveedor p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Proveedor.findByRegimenProveedor", query = "SELECT p FROM Proveedor p WHERE p.regimenProveedor = :regimenProveedor"),
    @NamedQuery(name = "Proveedor.findByEmailProveedor", query = "SELECT p FROM Proveedor p WHERE p.emailProveedor = :emailProveedor")})
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idProveedor;
    @Size(max = 2147483647)
    @Column(name = "nombre_Proveedor", length = 2147483647)
    private String nombreProveedor;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String direccion;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String telefono;
    @Size(max = 2147483647)
    @Column(name = "regimen_Proveedor", length = 2147483647)
    private String regimenProveedor;
    @Size(max = 2147483647)
    @Column(name = "email_Proveedor", length = 2147483647)
    private String emailProveedor;
    @OneToMany(mappedBy = "idProveedor")
    private Collection<Banco> bancoCollection;
    @OneToMany(mappedBy = "idProveedor")
    private Collection<CuentaContable> cuentaContableCollection;
    @OneToMany(mappedBy = "idProveedor")
    private Collection<Inventario> inventarioCollection;

    public Proveedor() {
    }

    public Proveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRegimenProveedor() {
        return regimenProveedor;
    }

    public void setRegimenProveedor(String regimenProveedor) {
        this.regimenProveedor = regimenProveedor;
    }

    public String getEmailProveedor() {
        return emailProveedor;
    }

    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }

    @XmlTransient
    public Collection<Banco> getBancoCollection() {
        return bancoCollection;
    }

    public void setBancoCollection(Collection<Banco> bancoCollection) {
        this.bancoCollection = bancoCollection;
    }

    @XmlTransient
    public Collection<CuentaContable> getCuentaContableCollection() {
        return cuentaContableCollection;
    }

    public void setCuentaContableCollection(Collection<CuentaContable> cuentaContableCollection) {
        this.cuentaContableCollection = cuentaContableCollection;
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
        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.umgprogra.erp.DAO.Proveedor[ idProveedor=" + idProveedor + " ]";
    }
    
}
