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
@Table(name = "cargoempleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargoempleado.findAll", query = "SELECT c FROM Cargoempleado c"),
    @NamedQuery(name = "Cargoempleado.findByIdcargo", query = "SELECT c FROM Cargoempleado c WHERE c.idcargo = :idcargo"),
    @NamedQuery(name = "Cargoempleado.findByNombreCargo", query = "SELECT c FROM Cargoempleado c WHERE c.nombreCargo = :nombreCargo"),
    @NamedQuery(name = "Cargoempleado.findBySalario", query = "SELECT c FROM Cargoempleado c WHERE c.salario = :salario")})
public class Cargoempleado implements Serializable {

    @OneToMany(mappedBy = "idcargoEmpleado")
    private Collection<Empleado> empleadoCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcargo")
    private Integer idcargo;
    @Size(max = 2147483647)
    @Column(name = "nombre_cargo")
    private String nombreCargo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salario")
    private Double salario;

    public Cargoempleado() {
    }

    public Cargoempleado(Integer idcargo) {
        this.idcargo = idcargo;
    }

    public Integer getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(Integer idcargo) {
        this.idcargo = idcargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcargo != null ? idcargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargoempleado)) {
            return false;
        }
        Cargoempleado other = (Cargoempleado) object;
        if ((this.idcargo == null && other.idcargo != null) || (this.idcargo != null && !this.idcargo.equals(other.idcargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.umgprogra.erp.DAO.Cargoempleado[ idcargo=" + idcargo + " ]";
    }

    @XmlTransient
    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
    }
    
}
