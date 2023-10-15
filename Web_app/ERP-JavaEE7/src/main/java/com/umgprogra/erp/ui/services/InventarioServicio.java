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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author madis
 */
public class InventarioServicio {

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

    public List<InventarioUI> findAllProducto() {
        List<InventarioUI> resultList = new ArrayList<>();
        try {
            Query query = entity.createNamedQuery("Inventario.findByAllProducto");
            List<Object[]> result = query.getResultList();
            //resultList = query.getResultList();
            if (result != null && !result.isEmpty()) {
                System.out.println("Log#: Resultado de la consulta:");
                for (Object[] results : result) {
                    int idProducto = (int) results[0];
                    String nombrePro = (String) results[1];
                    int cantidad = (int) results[2];
                    String tipocom = (String) results[3];
                    String modelo = (String) results[4];
                    String unidades = (String) results[5];
                    double precioV = (double) results[6];
                    double coste = (double) results[7];
                    int margenG = (int) results[8];
                    System.out.println("VALOR DE MARCAC "+ results[9]);
                    String marca = (String) results[9];
                    String linea = (String) results[10];
                    String grupo = (String) results[11];
                    String prov = (String) results[12];
                    int estado = (int) results[13];
                    double impuesto = (double) results[14];
                    InventarioUI inventario = new InventarioUI(idProducto,nombrePro,cantidad,tipocom,modelo,unidades,precioV,coste,margenG,estado,impuesto,grupo,linea,marca,prov);
                    resultList.add(inventario);
                }
            } else {
                System.out.println("No se encontraron Productos");
            }
        } catch (Exception e) {
            System.err.println("Error en findAllPro " + e.getMessage());
        }

        return resultList;

    }
}
