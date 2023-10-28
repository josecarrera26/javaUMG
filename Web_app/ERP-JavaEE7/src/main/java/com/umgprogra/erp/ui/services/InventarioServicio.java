/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.Cuentacontable;
import com.umgprogra.erp.DAO.Grupoproducto;
import com.umgprogra.erp.DAO.Inventario;
import com.umgprogra.erp.DAO.Linea;
import com.umgprogra.erp.DAO.Marca;
import com.umgprogra.erp.DAO.Proveedor;
import com.umgprogra.erp.javaee7UI.InventarioUI;
import com.umgprogra.erp.util.JpaUtil;
import com.umgprogra.erp.util.SessionUser;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author madis
 */
public class InventarioServicio {

    /**
     * @return the sessionUser
     */
    public SessionUser getSessionUser() {
        return sessionUser;
    }

    /**
     * @param sessionUser the sessionUser to set
     */
    public void setSessionUser(SessionUser sessionUser) {
        this.sessionUser = sessionUser;
    }

    EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();

    public Boolean saveProducto(String nombre, String tipoComercializacion, String modelo, String unidadM, double coste, int margenGanancia, Marca idmarca, Linea idlinea, Grupoproducto idgrupoproducto, Proveedor idproveedor, Cuentacontable idCuenta) {
        boolean g = false;
        try {
            Inventario inventario = new Inventario();
            System.out.println("name" + nombre);
            System.out.println("idMarca" + idmarca);
            System.out.println("idLinea" + idlinea);
            System.out.println("idGrupo" + idgrupoproducto);
            System.out.println("idProveedor" + idproveedor);
            inventario.setNombre(nombre);
            inventario.setCantidad(0);
            inventario.setTipoComercializacion(tipoComercializacion);
            inventario.setModelo(modelo);
            inventario.setUnidades(unidadM);
            inventario.setPrecioventa(0.0);
            inventario.setCoste(coste);
            inventario.setMargenganancia(margenGanancia);
            inventario.setIdmarca(idmarca);
            inventario.setIdlinea(idlinea);
            inventario.setIdgrupoproducto(idgrupoproducto);
            inventario.setIdproveedor(idproveedor);
            inventario.setEstado(1);
            inventario.setIdcuentacontable(idCuenta);
            inventario.setImpuestoinventario(0.0);
            entity.getTransaction().begin();
            entity.persist(inventario);
            entity.getTransaction().commit();
            g = true;
        } catch (Exception e) {
            System.out.println(e + "Error en save producto");
        }
        return g;
    }
    
      public Boolean EditarProducto(String nombre, String tipoComercializacion, String modelo, String unidadM, double coste, int margenGanancia, Marca idmarca, Linea idlinea, Grupoproducto idgrupoproducto, Proveedor idproveedor, Cuentacontable idCuenta, double precio,int estado, int codProducto, double impuesto_Inventario, int cantidad) {
        boolean g = false;
        try {
            Inventario inventario = entity.find(Inventario.class, codProducto);
            System.out.println("name" + nombre);
            System.out.println("idMarca" + idmarca);
            System.out.println("idLinea" + idlinea);
            System.out.println("idGrupo" + idgrupoproducto);
            System.out.println("idProveedor" + idproveedor);
            inventario.setNombre(nombre);
            inventario.setCantidad(cantidad);
            inventario.setTipoComercializacion(tipoComercializacion);
            inventario.setModelo(modelo);
            inventario.setUnidades(unidadM);
            inventario.setPrecioventa(precio);
            inventario.setCoste(coste);
            inventario.setMargenganancia(margenGanancia);
            inventario.setIdmarca(idmarca);
            inventario.setIdlinea(idlinea);
            inventario.setIdgrupoproducto(idgrupoproducto);
            inventario.setIdproveedor(idproveedor);
            inventario.setEstado(estado);
            inventario.setIdcuentacontable(idCuenta);
            inventario.setImpuestoinventario(impuesto_Inventario);
            entity.getTransaction().begin();
            entity.merge(inventario);
            entity.getTransaction().commit();
            g = true;
        } catch (Exception e) {
            System.out.println(e + "Error en Editar producto");
        }
        return g;
    }

    public List<Proveedor> findIdAndName() {
        List<Proveedor> resultList = new ArrayList<>();
        try {
            Query query = entity.createNamedQuery("Proveedor.findIdAndName");
            List<Object[]> result = query.getResultList();
            if (result != null && !result.isEmpty()) {
                System.out.println("Log#: Resultado de la consulta:");
                for (Object[] results : result) {
                    int idProveedor = (int) results[0];
                    String nombreProveedor = (String) results[1];
                    Proveedor proveedor = new Proveedor(idProveedor, nombreProveedor);
                    resultList.add(proveedor);
                }
            } else {
                System.out.println("No se encontraron Proveedores");
            }
        } catch (Exception e) {
            System.err.println("Error en findAllPro " + e.getMessage());
        }

        return resultList;

    }

    public List<Inventario> findProductoID(int idProd) {
        List<Inventario> resultList = new ArrayList<>();
        try {
            Query query = entity.createNamedQuery("Inventario.findByIdProducto", Inventario.class).setParameter("idproducto", idProd);
            resultList = query.getResultList();
            if (resultList != null && !resultList.isEmpty()) {
            } else {
                System.out.println("No se encontraron Productos");
            }
        } catch (Exception e) {
            System.err.println("Error en findAllPro " + e.getMessage());
        }

        return resultList;

    }

    public List<Inventario> findAllProducto() {
        List<Inventario> resultList = new ArrayList<>();
        try {

            Query query = entity.createNamedQuery("Inventario.findAll", Inventario.class);

            //List<Object[]> result = query.getResultList();
            resultList = query.getResultList();
            if (resultList != null && !resultList.isEmpty()) {
                // System.out.println("Log#: Resultado de la consulta:");
                //for (Inventario results : resultList) {
//                    int idProducto = (int) results[0];
//                    String nombrePro = (String) results[1];
//                    int cantidad = (int) results[2];
//                    String tipocom = (String) results[3];
//                    String modelo = (String) results[4];
//                    String unidades = (String) results[5];
//                    double precioV = (double) results[6];
//                    double coste = (double) results[7];
//                    int margenG = (int) results[8];
//                    //System.out.println("VALOR DE MARCAC "+ results[9]);
//                    String marca = (String) results[9];
//                    String linea = (String) results[10];
//                    String grupo = (String) results[11];
//                    String prov = (String) results[12];
//                    int estado = (int) results[13];
//                    double impuesto = (double) results[14];
//                    InventarioUI inventario = new InventarioUI(idProducto,nombrePro,cantidad,tipocom,modelo,unidades,precioV,coste,margenG,estado,impuesto,grupo,linea,marca,prov);
                //resultList.add(inventario);
                //    }
            } else {
                System.out.println("No se encontraron Productos");
            }
        } catch (Exception e) {
            System.err.println("Error en findAllPro " + e.getMessage());
        }

        return resultList;

    }

    @Inject
    private SessionUser sessionUser = (SessionUser) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sessionU");

    public boolean idRoleUser() {
        boolean flag = false;
        try {
            flag = sessionUser.isFlag();
            // System.out.println("ESTOY EN INVENTARIOUI ID " + sessionUser.getIdUser() + " ROLE " + sessionUser.getIdRol());

        } catch (Exception e) {
            System.out.println("Error en IDROLEINVENTARIOSERV" + e.getMessage());

        }
        return flag;
    }

    public int getLastProducto() {
        // Object[] ultimaFactura;
        int idProd = 0;
        try {
            Query query = entity.createNamedQuery("Inventario.findUltimoProd");
            idProd = (int) query.getSingleResult();
            System.out.println("Este es el ultimo Prod: " + idProd);
        } catch (Exception e) {
            System.err.println("Error en getAllFacturas " + e.getMessage());
        }
        return idProd;
    }
}
