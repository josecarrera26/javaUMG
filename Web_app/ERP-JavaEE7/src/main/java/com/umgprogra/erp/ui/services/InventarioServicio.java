/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

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
