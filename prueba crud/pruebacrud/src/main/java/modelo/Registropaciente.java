/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ferna
 */
@Entity
@Table(name = "registropaciente", schema = "erp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registropaciente.findAll", query = "SELECT r FROM Registropaciente r"),
    @NamedQuery(name = "Registropaciente.findByIdpaciente", query = "SELECT r FROM Registropaciente r WHERE r.idpaciente = :idpaciente"),
    @NamedQuery(name = "Registropaciente.findByNombrepaciente", query = "SELECT r FROM Registropaciente r WHERE r.nombrepaciente = :nombrepaciente"),
    @NamedQuery(name = "Registropaciente.findByDireccion", query = "SELECT r FROM Registropaciente r WHERE r.direccion = :direccion"),
    @NamedQuery(name = "Registropaciente.findByTelefono", query = "SELECT r FROM Registropaciente r WHERE r.telefono = :telefono"),
    @NamedQuery(name = "Registropaciente.findByEnfermedad", query = "SELECT r FROM Registropaciente r WHERE r.enfermedad = :enfermedad"),
    @NamedQuery(name = "Registropaciente.findByEstado", query = "SELECT r FROM Registropaciente r WHERE r.estado = :estado"),
    @NamedQuery(name = "Registropaciente.findByFechaalta", query = "SELECT r FROM Registropaciente r WHERE r.fechaalta = :fechaalta")})
public class Registropaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpaciente")
    private Integer idpaciente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombrepaciente")
    private String nombrepaciente;
    @Size(max = 2147483647)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private Integer telefono;
    @Size(max = 2147483647)
    @Column(name = "enfermedad")
    private String enfermedad;
    @Size(max = 2147483647)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fechaalta")
    @Temporal(TemporalType.DATE)
    private Date fechaalta;


    public Registropaciente(Integer idpaciente) {
        this.idpaciente = idpaciente;
    }

    public Registropaciente(Integer idpaciente, String nombrepaciente) {
        this.idpaciente = idpaciente;
        this.nombrepaciente = nombrepaciente;
    }

    public Registropaciente() {
    }


    public Integer getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(Integer idpaciente) {
        this.idpaciente = idpaciente;
    }

    public String getNombrepaciente() {
        return nombrepaciente;
    }

    public void setNombrepaciente(String nombrepaciente) {
        this.nombrepaciente = nombrepaciente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(Date fechaalta) {
        this.fechaalta = fechaalta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpaciente != null ? idpaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registropaciente)) {
            return false;
        }
        Registropaciente other = (Registropaciente) object;
        if ((this.idpaciente == null && other.idpaciente != null) || (this.idpaciente != null && !this.idpaciente.equals(other.idpaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Registropaciente[ idpaciente=" + idpaciente + " ]";
    }
    
}
