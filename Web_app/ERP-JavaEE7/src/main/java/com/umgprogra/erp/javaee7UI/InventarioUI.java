/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umgprogra.erp.javaee7UI;

import com.umgprogra.erp.DAO.Cuentacontable;
import com.umgprogra.erp.DAO.Grupoproducto;
import com.umgprogra.erp.DAO.Inventario;
import com.umgprogra.erp.DAO.Linea;
import com.umgprogra.erp.DAO.Marca;
import com.umgprogra.erp.DAO.Proveedor;
import com.umgprogra.erp.ui.services.CuentacontableServicio;
import com.umgprogra.erp.ui.services.GrupoProductoServicio;
import com.umgprogra.erp.ui.services.InventarioServicio;
import com.umgprogra.erp.ui.services.LineaServicio;
import com.umgprogra.erp.ui.services.MarcaServicio;
import com.umgprogra.erp.ui.services.ProveedoreServicio;
import com.umgprogra.erp.util.SessionUser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import org.primefaces.PrimeFaces;
import org.primefaces.model.DialogFrameworkOptions;

/**
 *
 * @author madis
 */
@ManagedBean
@ViewScoped
public class InventarioUI implements Serializable {

    /**
     * @return the lastProducto
     */
    public Integer getLastProducto() {
        return lastProducto;
    }

    /**
     * @param lastProducto the lastProducto to set
     */
    public void setLastProducto(Integer lastProducto) {
        this.lastProducto = lastProducto;
    }

    /**
     * @return the flagCom
     */
    public boolean isFlagCom() {
        return flagCom;
    }

    /**
     * @param flagCom the flagCom to set
     */
    public void setFlagCom(boolean flagCom) {
        this.flagCom = flagCom;
    }

    /**
     * @return the idRole
     */
    public int getIdRole() {
        return idRole;
    }

    /**
     * @param idRole the idRole to set
     */
    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    /**
     * @return the productoSelec
     */
    public InventarioUI getProductoSelec() {
        return productoSelec;
    }

    /**
     * @param productoSelec the productoSelec to set
     */
    public void setProductoSelec(InventarioUI productoSelec) {
        this.productoSelec = productoSelec;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * @return the marcaT
     */
    public String getMarcaT() {
        return marcaT;
    }

    /**
     * @param marcaT the marcaT to set
     */
    public void setMarcaT(String marcaT) {
        this.marcaT = marcaT;
    }

    /**
     * @return the lineaT
     */
    public String getLineaT() {
        return lineaT;
    }

    /**
     * @param lineaT the lineaT to set
     */
    public void setLineaT(String lineaT) {
        this.lineaT = lineaT;
    }

    /**
     * @return the grupoT
     */
    public String getGrupoT() {
        return grupoT;
    }

    /**
     * @param grupoT the grupoT to set
     */
    public void setGrupoT(String grupoT) {
        this.grupoT = grupoT;
    }

    /**
     * @return the proveedorT
     */
    public String getProveedorT() {
        return proveedorT;
    }

    /**
     * @param proveedorT the proveedorT to set
     */
    public void setProveedorT(String proveedorT) {
        this.proveedorT = proveedorT;
    }

    /**
     * @return the productos
     */
    public List<Inventario> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(List<Inventario> productos) {
        this.productos = productos;
    }

    /**
     * @return the tipoComercializacion
     */
    public List<String> getTipoComercializacion() {
        return tipoComercializacion;
    }

    /**
     * @param tipoComercializacion the tipoComercializacion to set
     */
    public void setTipoComercializacion(List<String> tipoComercializacion) {
        this.tipoComercializacion = tipoComercializacion;
    }

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
    public int getCodProducto() {
        return codProducto;
    }

    /**
     * @param codProducto the codProducto to set
     */
    public void setCodProducto(int codProducto) {
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

    private int codProducto;
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
    private Cuentacontable idCuenta;
    //LISTAS PARA LLENAR LOS CB
    private List<String> unidades;
    private List<String> tipoComercializacion;
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
    //PARA LLENAR LA TABLA EN CONSULTA
    private List<Inventario> productos;
    private String marcaT;
    private String lineaT;
    private String grupoT;
    private String proveedorT;
    private int estado;
    //PARA CAMBIOS EN PRODUCTO
    private InventarioUI productoSelec;
    private int idRole;
    private boolean flagCom;
    private Integer lastProducto;

    @PostConstruct
    public void init() {
        unidades = new ArrayList();
        unidades.add("Caja");
        unidades.add("Unidad");
        tipoComercializacion = new ArrayList();
        tipoComercializacion.add("Venta");
        tipoComercializacion.add("Gasto");
        findIdAndNameUi();
        findAllGrupoUi();
        findAllMarcaUi();
        findAllLineaUi();
        findAllProductosUi();
        idRoleUser();
        getUltimoProd();
        //  viewMarca();
    }

    public InventarioUI() {

    }

    public void viewMarcaModal() {
        try {
            DialogFrameworkOptions options = DialogFrameworkOptions.builder()
                    .resizable(true)
                    .build();
            System.out.println("Se crean las opciones del dialog");
            PrimeFaces.current().dialog().openDynamic("marca", options, null);
            System.out.println("Se crean las el dialog");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Se crean las el dialog");
        }
    }

    public void viewLineaModal() {
        try {
            DialogFrameworkOptions options = DialogFrameworkOptions.builder()
                    .resizable(true)
                    .build();
            System.out.println("Se crean las opciones del dialog");
            PrimeFaces.current().dialog().openDynamic("Linea.xhtml", options, null);
            System.out.println("Se crean las el dialog");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Se crean las el dialog");
        }
    }

    public InventarioUI(Integer codProducto, String nombre, Integer cantidad, String tipo_comercializacion, String modelo, String unidades, Double precioventa, Double coste, Integer margenganancia, Integer estado, Double impuestoinventario, String idgrupoproducto, String idlinea, String idmarca, String idproveedor) {
        this.codProducto = codProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo_comercializacion = tipo_comercializacion;
        this.modelo = modelo;
        this.unidadMed = unidades;
        this.precio = precioventa;
        this.coste = coste;
        this.margen_Ganancia = margenganancia;
        this.estado = estado;
        this.impuesto_Inventario = impuestoinventario;
        this.grupoT = idgrupoproducto;
        this.lineaT = idlinea;
        this.marcaT = idmarca;
        this.proveedorT = idproveedor;
    }

    public void saveProducto() {

        try {
            InventarioServicio inventarioServ = new InventarioServicio();

//            System.err.println("Marca: " +  getMarcaSeleccionada());
//            System.err.println("Linea: " +  getLineaSeleccionada());
//            System.err.println("Proveedor: " +  getProveedorSeleccionado());
//            System.err.println("Grupo: " +  getGrupoSeleccionado());
//              System.err.println("Medida: " +  unidadMed);
            if (inventarioServ.saveProducto(nombre, tipo_comercializacion, modelo, unidadMed, coste, margen_Ganancia, getMarcaSeleccionada(), getLineaSeleccionada(), getGrupoSeleccionado(), getProveedorSeleccionado(), getCuenta())) {
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

    public void actualizarProducto(int idProducto) {
        System.out.println("Index: " + idProducto);
//        try {
//            InventarioServicio inventarioServ = new InventarioServicio();
//
////            System.err.println("Marca: " +  getMarcaSeleccionada());
////            System.err.println("Linea: " +  getLineaSeleccionada());
////            System.err.println("Proveedor: " +  getProveedorSeleccionado());
////            System.err.println("Grupo: " +  getGrupoSeleccionado());
////              System.err.println("Medida: " +  unidadMed);
//            if (inventarioServ.saveProducto(nombre, tipo_comercializacion, modelo, unidadMed, coste, margen_Ganancia, getMarcaSeleccionada(), getLineaSeleccionada(), getGrupoSeleccionado(), getProveedorSeleccionado(), getCuenta())) {
//                System.err.println("Estoy en ProdUITRUE");
//                // FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro guardado");
//                //Agrega el mensaje al componente <p:growl>
//                //  FacesContext.getCurrentInstance().addMessage("messages", mensaje);
//            } else {
//                System.err.println("Estoy en InventarioUIFALSE");
//                //  FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Registro no guardado");
//                // Agrega el mensaje al componente <p:growl>
//                //   FacesContext.getCurrentInstance().addMessage("messages", mensaje);
//            }
//
//        } catch (Exception e) {
//            System.out.println(e + "Error en save MarcaUI");
//        }
    }

    public void idRoleUser() {
        InventarioServicio inventarioServ = new InventarioServicio();
        flagCom = inventarioServ.idRoleUser();
    }

    public void getUltimoProd() {
        try {
            InventarioServicio inven = new InventarioServicio();
            //Facturacab utimaFactura = new Facturacab();

            lastProducto = inven.getLastProducto();
        } catch (Exception e) {
            System.out.println("Error al consultar ultimo numero de factura");
            System.out.println("Mensaje: " + e.getMessage());
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

    public Cuentacontable getCuenta() {
        CuentacontableServicio cuentaServicio = new CuentacontableServicio();
        idCuenta = cuentaServicio.getCuentacontableId(4);
        if (idCuenta != null) {
            if (!idCuenta.getNombrecuenta().equals("Iva por pagar")) {
                System.out.println("ERROR AL AGREGAR CUENTA");
                idCuenta = null;
            }
        }
        return idCuenta;
    }

    public void findAllProductosUi() {
        try {
            InventarioServicio inventarioServ = new InventarioServicio();
            productos = (inventarioServ.findAllProducto(1));

        } catch (Exception e) {
            System.out.println(e + "Error en consulta marcas clase ClienteUI");
        }
    }

}
