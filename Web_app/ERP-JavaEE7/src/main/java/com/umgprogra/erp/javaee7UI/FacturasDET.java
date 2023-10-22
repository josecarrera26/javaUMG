/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.javaee7UI;

import com.umgprogra.erp.DAO.Inventario;
import com.umgprogra.erp.ui.services.FacturaDetServicio;
import com.umgprogra.erp.util.JpaUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;

/**
 *
 * @author ferna
 */
@ManagedBean
@SessionScoped
public class FacturasDET implements Serializable {

    List<FacturasDET> listadoproductos = new ArrayList<>();
    List<FacturasDET> listadoproductosCompra = new ArrayList<>();
    private List<Inventario> mostraridprod;
    private List<SelectItem> listidItems;
    private Integer cantidad;
    private double precioUnitario;
    private double iva;
    private Integer idProducto;
    private double subTotal;
    private double totalFac;
    private String nombreProducto;
    private double costoproducto;

    //constructores
    public FacturasDET(Integer cantidad, double precioUnitario, double iva, Integer idProducto, double subTotal, String nombreProducto, double totalFac, double costoproducto) {
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.iva = iva;
        this.idProducto = idProducto;
        this.subTotal = subTotal;
        this.nombreProducto = nombreProducto;
        this.totalFac = totalFac;
        this.costoproducto = costoproducto;
    }

    public List<FacturasDET> getListadoproductosCompra() {
        return listadoproductosCompra;
    }

    public void setListadoproductosCompra(List<FacturasDET> listadoproductosCompra) {
        this.listadoproductosCompra = listadoproductosCompra;
    }

    public double getCostoproducto() {
        return costoproducto;
    }

    public void setCostoproducto(double costoproducto) {
        this.costoproducto = costoproducto;
    }

    public double getTotalFac() {
        return totalFac;
    }

    public void setTotalFac(double totalFac) {
        this.totalFac = totalFac;
    }

    public List<Inventario> getMostraridprod() {
        return mostraridprod;
    }

    public void setMostraridprod(List<Inventario> mostraridprod) {
        this.mostraridprod = mostraridprod;
    }

    public List<SelectItem> getListidItems() {
        return listidItems;
    }

    public void setListidItems(List<SelectItem> listidItems) {
        this.listidItems = listidItems;
    }

    public FacturasDET() {
    }

    //getter y setter
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    @PostConstruct
    public void init() {
        mostrarIdProd();

    }

    //funciones 
    public void registroFacturaDet() {
        FacturaDetServicio registroFac = new FacturaDetServicio();
        boolean exito = false;
        try {
            if (listadoproductos.isEmpty()) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Listado vacio", "No se pudo registrar el producto");
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {
                for (FacturasDET lista : listadoproductos) {
                    Integer idProd = lista.getIdProducto();
                    Integer cantidadprod = lista.getCantidad();
                    exito = registroFac.registroFacturaDet(cantidadprod, idProd);

                }
                if (exito == true) {
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Todos los productos registrados con éxito");
                    FacesContext.getCurrentInstance().addMessage(null, message);
                }
            }

        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo registrar el producto");
            FacesContext.getCurrentInstance().addMessage(null, message);

        }

        // Limpia la lista después de procesar los productos
        listadoproductos.clear();
    }

    public List<FacturasDET> mostrarListProd() {
        List<FacturasDET> mostrar = new ArrayList<>();
        for (FacturasDET lista : listadoproductos) {
            mostrar.add(lista);
        }

        return mostrar;

    }

    public void eliminarProducto(int index) {
        if (index >= 0 && index < listadoproductos.size()) {
            double subtotalAEliminar = listadoproductos.get(index).subTotal; // Obtén el subtotal del producto que se va a eliminar
            listadoproductos.remove(index); // Elimina el producto de la lista

            // Actualiza totalFac después de eliminar el producto
            totalFac = totalFac - subtotalAEliminar;

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Producto eliminado con éxito."));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo eliminar el producto."));
        }
    }

    //listado de id producto
    public void mostrarIdProd() {

        FacturaDetServicio idprod = new FacturaDetServicio();
        mostraridprod = idprod.listadoProductos();
        try {

            for (Inventario inventario : mostraridprod) {
                listidItems.add(new SelectItem(inventario.getIdproducto(), inventario.getNombre()));

            }
        } catch (Exception e) {
            System.out.println(e + "Error en consulta marcas clase MarcaUI");
        }

    }

    public void agregarProducto() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();

        try {
            //para validacion de existacia en las tablas
            Inventario inventario = entityManager.find(Inventario.class, this.idProducto);
            int cantidadInventario = inventario.getCantidad();

            if (cantidadInventario > this.cantidad && this.cantidad != 0) {
                //obtenenemos el precio unitario del producto
                double preciounitario = inventario.getPrecioventa();
                String nombreProd = inventario.getNombre();
                //calculo del iva
                double iva = (preciounitario * this.cantidad) * 0.12;
                //calculo del subtotal
                double subTotal = (preciounitario * this.cantidad) + iva;

                //buscamos si el producto ya se encuentra en la lista
                FacturasDET existenciaprod = null;
                for (FacturasDET producto : listadoproductos) {
                    if (producto.getIdProducto() == this.idProducto) {
                        existenciaprod = producto;
                    }
                }

                if (existenciaprod != null && cantidadInventario > existenciaprod.getCantidad() + this.cantidad) {

                    this.totalFac = totalFac + subTotal;
                    // si existe entonces remplazamos el valor existente en la lista
                    existenciaprod.setCantidad(existenciaprod.getCantidad() + this.cantidad);
                    existenciaprod.setIva((existenciaprod.getCantidad() * existenciaprod.getPrecioUnitario()) * 0.12);
                    existenciaprod.setSubTotal((existenciaprod.getCantidad() * existenciaprod.getPrecioUnitario()) + existenciaprod.getIva());
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "suma de producto", "exito."));
                }
                if (existenciaprod != null && cantidadInventario <= existenciaprod.getCantidad() + this.cantidad) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "falta de inventario", "error."));
                }

                //si el producto no esta en la lista lo insertamos como un nuevo registro
                if (existenciaprod == null) {
                    FacturasDET facDET = new FacturasDET();

                    this.totalFac = totalFac + subTotal;

                    //seteamos los datos a la clase de facturaDET para agregarlo a una lista
                    facDET.setCantidad(this.cantidad);
                    facDET.setIdProducto(this.idProducto);
                    facDET.setIva(iva);
                    facDET.setNombreProducto(nombreProd);
                    facDET.setPrecioUnitario(preciounitario);
                    facDET.setSubTotal(subTotal);
                    //agregamos el objeto a la lista
                    listadoproductos.add(facDET);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "agregado a la lista", "Producto insertado con éxito."));
                }

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "valor invalido o falta de inventario", "No se pudo insertar el producto."));

            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", "No se pudo insertar el producto."));

        } finally {
            entityManager.close();
        }
        this.idProducto = 0;
        this.cantidad = 0;

    }

    //metodos para el registro de producto.
    public void listarproducto() {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();

        try {
            //para validacion de existacia en las tablas
            Inventario inventario = entityManager.find(Inventario.class, this.idProducto);

            if (this.cantidad != 0 && this.costoproducto != 0) {
                //obtenenemos el nombre del producto
                String nombreProd = inventario.getNombre();
                //calculos
                double iva = (this.costoproducto * this.cantidad) * 0.12;
                double subTotal = (this.costoproducto * this.cantidad) + iva;

                //buscamos si el producto ya se encuentra en la lista
                FacturasDET existenciaprod = null;
                for (FacturasDET producto : listadoproductosCompra) {
                    if (producto.getIdProducto() == this.idProducto) {
                        existenciaprod = producto;
                    }
                }

                if (existenciaprod != null) {

                    this.totalFac = totalFac + subTotal;
                    // si existe entonces remplazamos el valor existente en la lista
                    existenciaprod.setCantidad(existenciaprod.getCantidad() + this.cantidad);
                    existenciaprod.setIva((existenciaprod.getCantidad() * existenciaprod.getCostoproducto()) * 0.12);
                    existenciaprod.setSubTotal((existenciaprod.getCantidad() * existenciaprod.getCostoproducto()) + existenciaprod.getIva());
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "suma de producto", "exito."));
                }

                //si el producto no esta en la lista lo insertamos como un nuevo registro
                if (existenciaprod == null) {
                    FacturasDET facDET = new FacturasDET();

                    this.totalFac = totalFac + subTotal;

                    //seteamos los datos a la clase de facturaDET para agregarlo a una lista
                    facDET.setCantidad(this.cantidad);
                    facDET.setIdProducto(this.idProducto);
                    facDET.setIva(iva);
                    facDET.setNombreProducto(nombreProd);
                    facDET.setCostoproducto(this.costoproducto);
                    facDET.setSubTotal(subTotal);
                    //agregamos el objeto a la lista
                    listadoproductosCompra.add(facDET);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "agregado a la lista", "Producto insertado con éxito."));
                }

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "valor invalido", "No se pudo insertar el producto."));

            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", "No se pudo insertar el producto."));

        } finally {
            entityManager.close();
        }
        this.idProducto = 0;
        this.cantidad = 0;
        this.costoproducto = 0;
    }

    public List<FacturasDET> mostrarListCompra() {
        List<FacturasDET> mostrar = new ArrayList<>();
        for (FacturasDET lista : listadoproductosCompra) {
            mostrar.add(lista);
        }

        return mostrar;

    }

    public void eliminarProductoCompra(int index) {
        if (index >= 0 && index < listadoproductosCompra.size()) {
            double subtotalAEliminar = listadoproductosCompra.get(index).subTotal; // Obtén el subtotal del producto que se va a eliminar
            listadoproductosCompra.remove(index); // Elimina el producto de la lista

            // Actualiza totalFac después de eliminar el producto
            totalFac = totalFac - subtotalAEliminar;

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Producto eliminado con éxito."));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo eliminar el producto."));
        }
    }

    public void registroproducto() {

        FacturaDetServicio registrofac = new FacturaDetServicio();

        try {

            if (listadoproductosCompra.isEmpty()) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Listado vacio", "No se pudo registrar el producto");
                FacesContext.getCurrentInstance().addMessage(null, message);
                
            } else {
                for (FacturasDET lista : listadoproductosCompra) {
                    Integer idProd = lista.getIdProducto();
                    Integer cantidadprod = lista.getCantidad();
                    double costo = lista.getCostoproducto();
                    double ivacompra = lista.getIva();
                    registrofac.registroFacturaCompra(idProd, cantidadprod, costo,ivacompra);

                }
            }
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registrado con exito", "factura compra registrado");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo registrar el producto");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

}
