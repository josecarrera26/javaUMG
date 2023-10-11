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
@Table(name = "grupoproducto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupoproducto.findAll", query = "SELECT g FROM Grupoproducto g"),
    @NamedQuery(name = "Grupoproducto.findByIdgrupoproducto", query = "SELECT g FROM Grupoproducto g WHERE g.idgrupoproducto = :idgrupoproducto"),
    @NamedQuery(name = "Grupoproducto.findByDescripcion", query = "SELECT g FROM Grupoproducto g WHERE g.descripcion = :descripcion"),
    @NamedQuery(name = "Grupoproducto.findByEstado", query = "SELECT g FROM Grupoproducto g WHERE g.estado = :estado")})
public class Grupoproducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgrupoproducto")
    private Integer idgrupoproducto;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private Integer estado;
    @OneToMany(mappedBy = "idgrupoproducto")
    private Collection<Inventario> inventarioCollection;

    public Grupoproducto() {
    }

    public Grupoproducto(Integer idgrupoproducto) {
        this.idgrupoproducto = idgrupoproducto;
    }

    public Integer getIdgrupoproducto() {
        return idgrupoproducto;
    }

    public void setIdgrupoproducto(Integer idgrupoproducto) {
        this.idgrupoproducto = idgrupoproducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
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
        hash += (idgrupoproducto != null ? idgrupoproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupoproducto)) {
            return false;
        }
        Grupoproducto other = (Grupoproducto) object;
        if ((this.idgrupoproducto == null && other.idgrupoproducto != null) || (this.idgrupoproducto != null && !this.idgrupoproducto.equals(other.idgrupoproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.umgprogra.erp.DAO.Grupoproducto[ idgrupoproducto=" + idgrupoproducto + " ]";
    }
    
}
