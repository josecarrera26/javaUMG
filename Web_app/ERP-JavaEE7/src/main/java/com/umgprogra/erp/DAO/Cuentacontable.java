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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author josel
 */
@Entity
@Table(name = "cuentacontable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuentacontable.findAll", query = "SELECT c FROM Cuentacontable c"),
    @NamedQuery(name = "Cuentacontable.findByIdcuenta", query = "SELECT c FROM Cuentacontable c WHERE c.idcuenta = :idcuenta"),
    @NamedQuery(name = "Cuentacontable.findByNombrecuenta", query = "SELECT c FROM Cuentacontable c WHERE c.nombrecuenta = :nombrecuenta"),
    @NamedQuery(name = "Cuentacontable.findByImpuestoInventario", query = "SELECT c FROM Cuentacontable c WHERE c.impuestoInventario = :impuestoInventario")})
public class Cuentacontable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcuenta")
    private Integer idcuenta;
    @Size(max = 2147483647)
    @Column(name = "nombrecuenta")
    private String nombrecuenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "impuesto_inventario")
    private Double impuestoInventario;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne
    private Cliente idcliente;
    @JoinColumn(name = "idproveedor", referencedColumnName = "idproveedor")
    @ManyToOne
    private Proveedor idproveedor;

    public Cuentacontable() {
    }

    public Cuentacontable(Integer idcuenta) {
        this.idcuenta = idcuenta;
    }

    public Integer getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(Integer idcuenta) {
        this.idcuenta = idcuenta;
    }

    public String getNombrecuenta() {
        return nombrecuenta;
    }

    public void setNombrecuenta(String nombrecuenta) {
        this.nombrecuenta = nombrecuenta;
    }

    public Double getImpuestoInventario() {
        return impuestoInventario;
    }

    public void setImpuestoInventario(Double impuestoInventario) {
        this.impuestoInventario = impuestoInventario;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    public Proveedor getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(Proveedor idproveedor) {
        this.idproveedor = idproveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcuenta != null ? idcuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuentacontable)) {
            return false;
        }
        Cuentacontable other = (Cuentacontable) object;
        if ((this.idcuenta == null && other.idcuenta != null) || (this.idcuenta != null && !this.idcuenta.equals(other.idcuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.umgprogra.erp.DAO.Cuentacontable[ idcuenta=" + idcuenta + " ]";
    }
    
}
