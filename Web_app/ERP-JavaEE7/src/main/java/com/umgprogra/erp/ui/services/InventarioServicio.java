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
            Inventario  inventario = new Inventario();
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
}
