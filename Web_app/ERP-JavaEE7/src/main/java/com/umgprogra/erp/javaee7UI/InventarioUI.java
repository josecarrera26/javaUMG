/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umgprogra.erp.javaee7UI;

import com.umgprogra.erp.DAO.Grupoproducto;
import com.umgprogra.erp.DAO.Linea;
import com.umgprogra.erp.DAO.Marca;
import com.umgprogra.erp.DAO.Proveedor;
import com.umgprogra.erp.ui.services.GrupoProductoServicio;
import com.umgprogra.erp.ui.services.InventarioServicio;
import com.umgprogra.erp.ui.services.LineaServicio;
import com.umgprogra.erp.ui.services.MarcaServicio;
import com.umgprogra.erp.ui.services.ProveedoreServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author madis
 */
@ManagedBean
@ViewScoped
public class InventarioUI implements Serializable {

    /**
     * @return the idMarca
     */
    public int getIdMarca() {
        return idMarca;
    }

    /**
     * @param idMarca the idMarca to set
     */
    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    /**
     * @return the idProveedor
     */
    public int getIdProveedor() {
        return idProveedor;
    }

    /**
     * @param idProveedor the idProveedor to set
     */
    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    /**
     * @return the idGrupo
     */
    public int getIdGrupo() {
        return idGrupo;
    }

    /**
     * @param idGrupo the idGrupo to set
     */
    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    /**
     * @return the idLinea
     */
    public int getIdLinea() {
        return idLinea;
    }

    /**
     * @param idLinea the idLinea to set
     */
    public void setIdLinea(int idLinea) {
        this.idLinea = idLinea;
    }

    /**
     * @return the proveedores
     */
    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    /**
     * @param proveedores the proveedores to set
     */
    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    /**
     * @return the proveedorItems
     */
    public List<SelectItem> getProveedorItems() {
        return proveedorItems;
    }

    /**
     * @param proveedorItems the proveedorItems to set
     */
    public void setProveedorItems(List<SelectItem> proveedorItems) {
        this.proveedorItems = proveedorItems;
    }

    /**
     * @return the unidades
     */
    public List<String> getUnidades() {
        return unidades;
    }

    /**
     * @param unidades the unidades to set
     */
    public void setUnidades(List<String> unidades) {
        this.unidades = unidades;
    }

    /**
     * @return the codProducto
     */
    public String getCodProducto() {
        return codProducto;
    }

    /**
     * @param codProducto the codProducto to set
     */
    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the tipo_comercializacion
     */
    public String getTipo_comercializacion() {
        return tipo_comercializacion;
    }

    /**
     * @param tipo_comercializacion the tipo_comercializacion to set
     */
    public void setTipo_comercializacion(String tipo_comercializacion) {
        this.tipo_comercializacion = tipo_comercializacion;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the unidadMed
     */
    public String getUnidadMed() {
        return unidadMed;
    }

    /**
     * @param unidadMed the unidadMed to set
     */
    public void setUnidadMed(String unidadMed) {
        this.unidadMed = unidadMed;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the impuesto_Inventario
     */
    public double getImpuesto_Inventario() {
        return impuesto_Inventario;
    }

    /**
     * @param impuesto_Inventario the impuesto_Inventario to set
     */
    public void setImpuesto_Inventario(double impuesto_Inventario) {
        this.impuesto_Inventario = impuesto_Inventario;
    }

    /**
     * @return the coste
     */
    public double getCoste() {
        return coste;
    }

    /**
     * @param coste the coste to set
     */
    public void setCoste(double coste) {
        this.coste = coste;
    }

    /**
     * @return the margen_Ganancia
     */
    public int getMargen_Ganancia() {
        return margen_Ganancia;
    }

    /**
     * @param margen_Ganancia the margen_Ganancia to set
     */
    public void setMargen_Ganancia(int margen_Ganancia) {
        this.margen_Ganancia = margen_Ganancia;
    }

    /**
     * @return the marca
     */
    public Marca getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    /**
     * @return the linea
     */
    public Linea getLinea() {
        return linea;
    }

    /**
     * @param linea the linea to set
     */
    public void setLinea(Linea linea) {
        this.linea = linea;
    }

    /**
     * @return the grupo
     */
    public Grupoproducto getGrupo() {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(Grupoproducto grupo) {
        this.grupo = grupo;
    }

    /**
     * @return the proveedor
     */
    public Proveedor getProveedor() {
        return proveedor;
    }

    /**
     * @param proveedor the proveedor to set
     */
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * @return the grupos
     */
    public List<Grupoproducto> getGrupos() {
        return grupos;
    }

    /**
     * @param grupos the grupos to set
     */
    public void setGrupos(List<Grupoproducto> grupos) {
        this.grupos = grupos;
    }

    /**
     * @return the grupoItems
     */
    public List<SelectItem> getGrupoItems() {
        return grupoItems;
    }

    /**
     * @param grupoItems the grupoItems to set
     */
    public void setGrupoItems(List<SelectItem> grupoItems) {
        this.grupoItems = grupoItems;
    }

    /**
     * @return the marcaItems
     */
    public List<SelectItem> getMarcaItems() {
        return marcaItems;
    }

    /**
     * @param marcaItems the marcaItems to set
     */
    public void setMarcaItems(List<SelectItem> marcaItems) {
        this.marcaItems = marcaItems;
    }

    /**
     * @return the marcas
     */
    public List<Marca> getMarcas() {
        return marcas;
    }

    /**
     * @param marcas the marcas to set
     */
    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }

    /**
     * @return the marcas
     */
    public List<Linea> getLineas() {
        return lineas;
    }

    /**
     * @param lineas the marcas to set
     */
    public void setLineas(List<Linea> lineas) {
        this.lineas = lineas;
    }

    /**
     * @return the lineaItems
     */
    public List<SelectItem> getLineaItems() {
        return lineaItems;
    }

    /**
     * @param lineaItems the marcaItems to set
     */
    public void setLineaItems(List<SelectItem> lineaItems) {
        this.lineaItems = lineaItems;
    }

    private String codProducto;
    private String nombre;
    private int cantidad;
    private String tipo_comercializacion;
    private String modelo;
    private String unidadMed;
    private double precio;
    private double impuesto_Inventario;
    private double coste;
    private int margen_Ganancia;
    //DE TIPO OBJETO PARA MANDAR A DB
    private Marca marca;
    private Linea linea;
    private Grupoproducto grupo;
    private Proveedor proveedor;
    //LISTAS PARA LLENAR LOS CB
    private List<String> unidades;
    private List<Proveedor> proveedores;
    private List<SelectItem> proveedorItems;
    private List<Grupoproducto> grupos;
    private List<SelectItem> grupoItems;
    private List<Marca> marcas;
    private List<SelectItem> marcaItems;
    private List<Linea> lineas;
    private List<SelectItem> lineaItems;
    //PARA OBTENER EL ID SELECCIONADO EN EL CB
    private int idMarca;
    private int idProveedor;
    private int idGrupo;
    private int idLinea;

    @PostConstruct
    public void init() {
        unidades = new ArrayList();
        unidades.add("Caja");
        unidades.add("Unidad");
//        findIdAndNameUi();
        findAllGrupoUi();
        findAllMarcaUi();
        findAllLineaUi();
    }

    public void saveProducto() {

        try {
            InventarioServicio inventarioServ = new InventarioServicio();
          
//            System.err.println("Marca: " +  getMarcaSeleccionada());
//            System.err.println("Linea: " +  getLineaSeleccionada());
//            System.err.println("Proveedor: " +  getProveedorSeleccionado());
//            System.err.println("Grupo: " +  getGrupoSeleccionado());
//              System.err.println("Medida: " +  unidadMed);


            if (inventarioServ.saveProducto(nombre, tipo_comercializacion, modelo, unidadMed, coste, margen_Ganancia, getMarcaSeleccionada(), getLineaSeleccionada(), getGrupoSeleccionado(), getProveedorSeleccionado())) {
                System.err.println("Estoy en ProdUITRUE");
                // FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro guardado");
                //Agrega el mensaje al componente <p:growl>
                //  FacesContext.getCurrentInstance().addMessage("messages", mensaje);
            } else {
                System.err.println("Estoy en InventarioUIFALSE");
                //  FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Registro no guardado");
                // Agrega el mensaje al componente <p:growl>
                //   FacesContext.getCurrentInstance().addMessage("messages", mensaje);
            }

        } catch (Exception e) {
            System.out.println(e + "Error en save MarcaUI");
        }
    }

    //Metodos para obtener el objeto seleccionado en cb
    public Marca getMarcaSeleccionada() {
        try {
            MarcaServicio marcaServ = new MarcaServicio();
            marca = marcaServ.getMarcaId(idMarca).get(0);
        } catch (Exception e) {
            System.err.println("Error al consultar");
        }
        return marca;
    }

    public Linea getLineaSeleccionada() {
        try {
            LineaServicio lineaServ = new LineaServicio();
            linea = lineaServ.getLineaId(idLinea).get(0);
        } catch (Exception e) {
            System.err.println("Error al consultar");
        }
        return linea;
    }

    public Grupoproducto getGrupoSeleccionado() {
        try {
            GrupoProductoServicio grupoServ = new GrupoProductoServicio();
            grupo = grupoServ.getGrupoId(idGrupo).get(0);
        } catch (Exception e) {
            System.err.println("Error al consultar");
        }
        return grupo;
    }

    public Proveedor getProveedorSeleccionado() {
        try {
            ProveedoreServicio provServ = new ProveedoreServicio();
            proveedor = provServ.getProveedorId(idProveedor).get(0);
        } catch (Exception e) {
            System.err.println("Error al consultar");
        }
        return proveedor;
    }

//METODOS PARA LLENAR LOS CB
    public void findIdAndNameUi() {
        try {
            InventarioServicio provServ = new InventarioServicio();
            proveedores = provServ.findIdAndName();
            proveedorItems = new ArrayList<>();
            for (Proveedor prov : proveedores) {
                proveedorItems.add(new SelectItem(prov.getIdproveedor(), prov.getNombreProveedor()));
            }
        } catch (Exception e) {
            System.out.println(e + "Error en consulta proveedor en clase InventarioUI");
        }
    }

    public void findAllGrupoUi() {
        try {
            GrupoProductoServicio grupoServ = new GrupoProductoServicio();
            grupos = grupoServ.findAllGrupo();
            grupoItems = new ArrayList<>();
            for (Grupoproducto grupoObj : grupos) {
                grupoItems.add(new SelectItem(grupoObj.getIdgrupoproducto(), grupoObj.getDescripcion()));
            }
        } catch (Exception e) {
            System.out.println(e + "Error en consulta grupo clase GrupoUI");
        }
    }

    public void findAllMarcaUi() {
        try {
            MarcaServicio marcaServ = new MarcaServicio();
            marcas = marcaServ.findAllMarca();
            marcaItems = new ArrayList<>();
            for (Marca marcaObj : marcas) {
                marcaItems.add(new SelectItem(marcaObj.getIdmarca(), marcaObj.getDescripcion()));
            }
        } catch (Exception e) {
            System.out.println(e + "Error en consulta marcas clase MarcaUI");
        }
    }

    public void findAllLineaUi() {
        try {
            LineaServicio lineaServ = new LineaServicio();
            lineas = lineaServ.findAllLinea();
            lineaItems = new ArrayList<>();
            for (Linea lineaObj : lineas) {
                lineaItems.add(new SelectItem(lineaObj.getIdlinea(), lineaObj.getDescripcion()));
            }
        } catch (Exception e) {
            System.out.println(e + "Error en consulta linea clase LineaUI");
        }
    }

}
