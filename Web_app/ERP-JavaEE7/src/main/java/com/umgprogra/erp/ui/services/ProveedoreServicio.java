/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.Proveedor;
import com.umgprogra.erp.util.JpaUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author ferna
 */
public class ProveedoreServicio {

    public boolean registrarProveedor(String nombreProv, String direccionProv, Integer telefonoProv, String regimenProv, String emailProv) {
        boolean exito = false;  // Inicialmente, asumimos que la operación fallará

        // Conversion de número de teléfono a cadena
        String telefonoProveedorStr = telefonoProv.toString();

        // Iniciar la persistencia
        EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();

        // Crear una instancia de Proveedor y configurar sus propiedades
        Proveedor prov = new Proveedor();
        prov.setNombreProveedor(nombreProv);
        prov.setDireccion(direccionProv);
        prov.setTelefono(telefonoProveedorStr);
        prov.setRegimenProveedor(regimenProv);
        prov.setEmailProveedor(emailProv);

        // Iniciar la transacción
        entity.getTransaction().begin();

        try {
            // Persistir la entidad
            entity.persist(prov);

            // Commit de la transacción
            entity.getTransaction().commit();
            exito = true;  // Si llegamos aquí, la operación fue exitosa
        } catch (Exception e) {
            // En caso de excepción, marcamos la operación como fallida
            entity.getTransaction().rollback();
            exito = false;
        } finally {
            entity.close();
        }

        return exito;  // Devuelve true si la operación fue exitosa, de lo contrario, false
    }

}
