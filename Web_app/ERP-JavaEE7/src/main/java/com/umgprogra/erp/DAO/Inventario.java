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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i"),
    @NamedQuery(name = "Inventario.findByIdProducto", query = "SELECT i FROM Inventario i WHERE i.idProducto = :idProducto"),
    @NamedQuery(name = "Inventario.findByNombre", query = "SELECT i FROM Inventario i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Inventario.findByCantidad", query = "SELECT i FROM Inventario i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "Inventario.findByTipoComercializacion", query = "SELECT i FROM Inventario i WHERE i.tipoComercializacion = :tipoComercializacion"),
    @NamedQuery(name = "Inventario.findByModelo", query = "SELECT i FROM Inventario i WHERE i.modelo = :modelo"),
    @NamedQuery(name = "Inventario.findByUnidades", query = "SELECT i FROM Inventario i WHERE i.unidades = :unidades"),
    @NamedQuery(name = "Inventario.findByPrecio", query = "SELECT i FROM Inventario i WHERE i.precio = :precio"),
    @NamedQuery(name = "Inventario.findByGrupoProducto", query = "SELECT i FROM Inventario i WHERE i.grupoProducto = :grupoProducto")})
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idProducto;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String nombre;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String cantidad;
    @Size(max = 2147483647)
    @Column(name = "tipo_comercializacion", length = 2147483647)
    private String tipoComercializacion;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String modelo;
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String unidades;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 17, scale = 17)
    private Double precio;
    @Size(max = 2147483647)
    @Column(name = "grupo_producto", length = 2147483647)
    private String grupoProducto;
    @OneToMany(mappedBy = "idproducto")
    private Collection<CuentaContable> cuentaContableCollection;
    @OneToMany(mappedBy = "idProducto")
    private Collection<Pedido> pedidoCollection;
    @OneToMany(mappedBy = "idProducto")
    private Collection<Kardex> kardexCollection;
    @JoinColumn(name = "idLinea", referencedColumnName = "idLinea")
    @ManyToOne
    private Linea idLinea;
    @JoinColumn(name = "idMarca", referencedColumnName = "idMarca")
    @ManyToOne
    private Marca idMarca;
    @JoinColumn(name = "idProveedor", referencedColumnName = "idProveedor")
    @ManyToOne
    private Proveedor idProveedor;

    public Inventario() {
    }

    public Inventario(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipoComercializacion() {
        return tipoComercializacion;
    }

    public void setTipoComercializacion(String tipoComercializacion) {
        this.tipoComercializacion = tipoComercializacion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getGrupoProducto() {
        return grupoProducto;
    }

    public void setGrupoProducto(String grupoProducto) {
        this.grupoProducto = grupoProducto;
    }

    @XmlTransient
    public Collection<CuentaContable> getCuentaContableCollection() {
        return cuentaContableCollection;
    }

    public void setCuentaContableCollection(Collection<CuentaContable> cuentaContableCollection) {
        this.cuentaContableCollection = cuentaContableCollection;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    @XmlTransient
    public Collection<Kardex> getKardexCollection() {
        return kardexCollection;
    }

    public void setKardexCollection(Collection<Kardex> kardexCollection) {
        this.kardexCollection = kardexCollection;
    }

    public Linea getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(Linea idLinea) {
        this.idLinea = idLinea;
    }

    public Marca getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marca idMarca) {
        this.idMarca = idMarca;
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
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventario)) {
            return false;
        }
        Inventario other = (Inventario) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.umgprogra.erp.DAO.Inventario[ idProducto=" + idProducto + " ]";
    }
    
}
