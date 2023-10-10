/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.DAO;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "cargo_empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CargoEmpleado.findAll", query = "SELECT c FROM CargoEmpleado c"),
    @NamedQuery(name = "CargoEmpleado.findByIdCargo", query = "SELECT c FROM CargoEmpleado c WHERE c.idCargo = :idCargo"),
    @NamedQuery(name = "CargoEmpleado.findByNombreCargo", query = "SELECT c FROM CargoEmpleado c WHERE c.nombreCargo = :nombreCargo"),
    @NamedQuery(name = "CargoEmpleado.findBySalario", query = "SELECT c FROM CargoEmpleado c WHERE c.salario = :salario")})
public class CargoEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCargo")
    private Integer idCargo;
    @Size(max = 2147483647)
    @Column(name = "nombre_Cargo")
    private String nombreCargo;
    @Column(name = "salario")
    private BigInteger salario;
    @OneToMany(mappedBy = "idCargoempleado")
    private Collection<Empleado> empleadoCollection;

    public CargoEmpleado() {
    }

    public CargoEmpleado(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public BigInteger getSalario() {
        return salario;
    }

    public void setSalario(BigInteger salario) {
        this.salario = salario;
    }

    @XmlTransient
    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCargo != null ? idCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CargoEmpleado)) {
            return false;
        }
        CargoEmpleado other = (CargoEmpleado) object;
        if ((this.idCargo == null && other.idCargo != null) || (this.idCargo != null && !this.idCargo.equals(other.idCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.umgprogra.erp.DAO.CargoEmpleado[ idCargo=" + idCargo + " ]";
    }
    
}
