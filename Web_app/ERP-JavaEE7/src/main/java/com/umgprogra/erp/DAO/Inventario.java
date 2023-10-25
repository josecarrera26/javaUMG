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
@Table(name = "inventario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i"),
     @NamedQuery(name = "Inventario.findByIdProducto", query = "SELECT i FROM Inventario i WHERE i.idproducto = :idproducto"),
    @NamedQuery(name = "Inventario.findByAllProducto", query = "SELECT i.idproducto, i.nombre, i.cantidad, i.tipoComercializacion, i.modelo, "
            + " i.unidades, i.precioventa, i.coste, i.margenganancia, m.descripcion, l.descripcion, g.descripcion, "
            + " p.nombreProveedor, i.estado, i.impuestoinventario "
            + " FROM Inventario i "
            + " INNER JOIN Marca m on i.idmarca = m.idmarca "
            + " INNER JOIN Linea l on i.idlinea = l.idlinea "
            + " INNER JOIN Grupoproducto g on i.idgrupoproducto = g.idgrupoproducto "
            + " INNER JOIN Proveedor p on i.idproveedor = p.idproveedor"),
    @NamedQuery(name = "Inventario.findUltimoProd", query = "SELECT MAX(i.idproducto) + 1  FROM Inventario i"),
    @NamedQuery(name = "Inventario.findByNombre", query = "SELECT i FROM Inventario i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Inventario.findByCantidad", query = "SELECT i FROM Inventario i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "Inventario.findByTipoComercializacion", query = "SELECT i FROM Inventario i WHERE i.tipoComercializacion = :tipoComercializacion"),
    @NamedQuery(name = "Inventario.findByModelo", query = "SELECT i FROM Inventario i WHERE i.modelo = :modelo"),
    @NamedQuery(name = "Inventario.findByUnidades", query = "SELECT i FROM Inventario i WHERE i.unidades = :unidades"),
    @NamedQuery(name = "Inventario.findByPrecioventa", query = "SELECT i FROM Inventario i WHERE i.precioventa = :precioventa"),
    @NamedQuery(name = "Inventario.findByCoste", query = "SELECT i FROM Inventario i WHERE i.coste = :coste"),
    @NamedQuery(name = "Inventario.findByMargenganancia", query = "SELECT i FROM Inventario i WHERE i.margenganancia = :margenganancia"),
    @NamedQuery(name = "Inventario.findByEstado", query = "SELECT i FROM Inventario i WHERE i.estado = :estado"),
    @NamedQuery(name = "Inventario.findByImpuestoinventario", query = "SELECT i FROM Inventario i WHERE i.impuestoinventario = :impuestoinventario")})
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproducto")
    private Integer idproducto;
    @Size(max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Size(max = 2147483647)
    @Column(name = "tipo_comercializacion")
    private String tipoComercializacion;
    @Size(max = 2147483647)
    @Column(name = "modelo")
    private String modelo;
    @Size(max = 2147483647)
    @Column(name = "unidades")
    private String unidades;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precioventa")
    private Double precioventa;
    @Column(name = "coste")
    private Double coste;
    @Column(name = "margenganancia")
    private Integer margenganancia;
    @Column(name = "estado")
    private Integer estado;
    @Column(name = "impuestoinventario")
    private Double impuestoinventario;
    @OneToMany(mappedBy = "idproducto")
    private Collection<Facturadet> facturadetCollection;
    @OneToMany(mappedBy = "idproducto")
    private Collection<Pedido> pedidoCollection;
    @OneToMany(mappedBy = "idproducto")
    private Collection<Kardex> kardexCollection;
    @JoinColumn(name = "idcuentacontable", referencedColumnName = "idcuentacontable")
    @ManyToOne
    private Cuentacontable idcuentacontable;
    @JoinColumn(name = "idgrupoproducto", referencedColumnName = "idgrupoproducto")
    @ManyToOne
    private Grupoproducto idgrupoproducto;
    @JoinColumn(name = "idlinea", referencedColumnName = "idlinea")
    @ManyToOne
    private Linea idlinea;
    @JoinColumn(name = "idmarca", referencedColumnName = "idmarca")
    @ManyToOne
    private Marca idmarca;
    @JoinColumn(name = "idproveedor", referencedColumnName = "idproveedor")
    @ManyToOne
    private Proveedor idproveedor;

    public Inventario() {
    }

    public Inventario(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
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

    public Double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(Double precioventa) {
        this.precioventa = precioventa;
    }

    public Double getCoste() {
        return coste;
    }

    public void setCoste(Double coste) {
        this.coste = coste;
    }

    public Integer getMargenganancia() {
        return margenganancia;
    }

    public void setMargenganancia(Integer margenganancia) {
        this.margenganancia = margenganancia;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Double getImpuestoinventario() {
        return impuestoinventario;
    }

    public void setImpuestoinventario(Double impuestoinventario) {
        this.impuestoinventario = impuestoinventario;
    }

    @XmlTransient
    public Collection<Facturadet> getFacturadetCollection() {
        return facturadetCollection;
    }

    public void setFacturadetCollection(Collection<Facturadet> facturadetCollection) {
        this.facturadetCollection = facturadetCollection;
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

    public Cuentacontable getIdcuentacontable() {
        return idcuentacontable;
    }

    public void setIdcuentacontable(Cuentacontable idcuentacontable) {
        this.idcuentacontable = idcuentacontable;
    }

    public Grupoproducto getIdgrupoproducto() {
        return idgrupoproducto;
    }

    public void setIdgrupoproducto(Grupoproducto idgrupoproducto) {
        this.idgrupoproducto = idgrupoproducto;
    }

    public Linea getIdlinea() {
        return idlinea;
    }

    public void setIdlinea(Linea idlinea) {
        this.idlinea = idlinea;
    }

    public Marca getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(Marca idmarca) {
        this.idmarca = idmarca;
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
        hash += (idproducto != null ? idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventario)) {
            return false;
        }
        Inventario other = (Inventario) object;
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.umgprogra.erp.DAO.Inventario[ idproducto=" + idproducto + " ]";
    }
    
}
