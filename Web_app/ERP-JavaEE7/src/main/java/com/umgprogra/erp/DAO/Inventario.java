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
@Table(name = "inventario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i"),
    @NamedQuery(name = "Inventario.findByIdProducto", query = "SELECT i FROM Inventario i WHERE i.idProducto = :idProducto"),
    @NamedQuery(name = "Inventario.findByNombre", query = "SELECT i FROM Inventario i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Inventario.findByCantidad", query = "SELECT i FROM Inventario i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "Inventario.findByTipoComercializacion", query = "SELECT i FROM Inventario i WHERE i.tipoComercializacion = :tipoComercializacion"),
    @NamedQuery(name = "Inventario.findByModelo", query = "SELECT i FROM Inventario i WHERE i.modelo = :modelo"),
    @NamedQuery(name = "Inventario.findByUnidades", query = "SELECT i FROM Inventario i WHERE i.unidades = :unidades"),
    @NamedQuery(name = "Inventario.findByPrecioVenta", query = "SELECT i FROM Inventario i WHERE i.precioVenta = :precioVenta"),
    @NamedQuery(name = "Inventario.findByCoste", query = "SELECT i FROM Inventario i WHERE i.coste = :coste"),
    @NamedQuery(name = "Inventario.findByMargenGanancia", query = "SELECT i FROM Inventario i WHERE i.margenGanancia = :margenGanancia")})
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProducto")
    private Integer idProducto;
    @Size(max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 2147483647)
    @Column(name = "cantidad")
    private String cantidad;
    @Size(max = 2147483647)
    @Column(name = "tipo_comercializacion")
    private String tipoComercializacion;
    @Size(max = 2147483647)
    @Column(name = "modelo")
    private String modelo;
    @Size(max = 2147483647)
    @Column(name = "unidades")
    private String unidades;
    @Column(name = "precioVenta")
    private BigInteger precioVenta;
    @Column(name = "coste")
    private BigInteger coste;
    @Column(name = "margenGanancia")
    private Integer margenGanancia;
    @OneToMany(mappedBy = "idProducto")
    private Collection<FacturaDet> facturaDetCollection;
    @OneToMany(mappedBy = "idProducto")
    private Collection<Pedido> pedidoCollection;
    @OneToMany(mappedBy = "idProducto")
    private Collection<Kardex> kardexCollection;
    @JoinColumn(name = "idgrupoproducto", referencedColumnName = "idgrupoproducto")
    @ManyToOne
    private GrupoProducto idgrupoproducto;
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

    public BigInteger getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigInteger precioVenta) {
        this.precioVenta = precioVenta;
    }

    public BigInteger getCoste() {
        return coste;
    }

    public void setCoste(BigInteger coste) {
        this.coste = coste;
    }

    public Integer getMargenGanancia() {
        return margenGanancia;
    }

    public void setMargenGanancia(Integer margenGanancia) {
        this.margenGanancia = margenGanancia;
    }

    @XmlTransient
    public Collection<FacturaDet> getFacturaDetCollection() {
        return facturaDetCollection;
    }

    public void setFacturaDetCollection(Collection<FacturaDet> facturaDetCollection) {
        this.facturaDetCollection = facturaDetCollection;
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

    public GrupoProducto getIdgrupoproducto() {
        return idgrupoproducto;
    }

    public void setIdgrupoproducto(GrupoProducto idgrupoproducto) {
        this.idgrupoproducto = idgrupoproducto;
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
