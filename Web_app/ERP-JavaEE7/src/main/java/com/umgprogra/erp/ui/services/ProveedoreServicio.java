/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.Cuentacontable;
import com.umgprogra.erp.DAO.Proveedor;
import com.umgprogra.erp.util.JpaUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ferna
 */
public class ProveedoreServicio {
    // Iniciar la persistencia

    EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();

    public boolean registrarProveedor(String nombreProv, String direccionProv, Integer telefonoProv, String regimenProv, String emailProv, Cuentacontable idCuenta, String estado) {
        boolean exito = false;  // Inicialmente, asumimos que la operación fallará

        try {
            // Conversion de número de teléfono a cadena
            String telefonoProveedorStr = telefonoProv.toString();

            // Crear una instancia de Proveedor y configurar sus propiedades
            Proveedor prov = new Proveedor();
            prov.setDireccion(direccionProv);
            prov.setEmailProveedor(emailProv);
            prov.setIdcuentacontable(idCuenta);
            prov.setNombreProveedor(nombreProv);
            prov.setRegimenProveedor(regimenProv);
            prov.setTelefono(telefonoProveedorStr);
            prov.setEstado(estado);

            // Iniciar la transacción
            entity.getTransaction().begin();
            // Persistir la entidad
            entity.persist(prov);

            // Commit de la transacción
            entity.getTransaction().commit();
            exito = true;  // Si llegamos aquí, la operación fue exitosa
            System.out.println("Save Proveedor");
        } catch (Exception e) {
            // En caso de excepción, marcamos la operación como fallida
            entity.getTransaction().rollback();
            System.out.println(e + "Error en save Proveedor");
            exito = false;
        } finally {
            entity.close();
        }

        return exito;  // Devuelve true si la operación fue exitosa, de lo contrario, false
    }

    public List<Proveedor> getProveedorId(int idProveedor) {
        List<Proveedor> resultList = new ArrayList<>();
        try {
            Query query2 = entity.createNamedQuery("Proveedor.findByIdproveedor", Proveedor.class).setParameter("idproveedor", idProveedor);
            resultList = query2.getResultList();
            if (resultList == null && resultList.isEmpty()) {
                System.out.println("No se encontraron Proveedores con el ID");
            }
        } catch (Exception e) {
            System.out.println("Error en la consulta getProveedorId" + e);
        }

        return resultList;
    }

    public List<Proveedor> finderidProveedorById(Integer idProveedor) {
        List<Proveedor> resultList = new ArrayList<>();
        try {
            System.out.println("metodo DB findbyidProveedor");
            System.out.println("idProveedor" + idProveedor);
            Query query = entity.createNamedQuery("Cliente.findByIdProveedor", Proveedor.class)
                    .setParameter("idproveedor", idProveedor);
            //resultado
            resultList = query.getResultList();
            if (resultList != null && !resultList.isEmpty()) {
                System.out.println("Resultado de la consulta:");
            } else {
                System.out.println("No se encontraron Cliente");
            }
        } catch (Exception e) {
            System.err.println("Error en findbyIdCliente " + e.getMessage());
        }

        return resultList;

    }

    public void actualizarProveedor(String nombre, String direccion, Integer telefono, String regimen, String email, Cuentacontable cuenataContable, String estado) {
        Proveedor proveedor = new Proveedor();
        String telefonoProveedorStr = telefono.toString();
        Query query = entity.createNamedQuery("Proveedor.findByNombreProveedor", Proveedor.class)
                .setParameter("nombreProveedor", nombre);

        proveedor = (Proveedor) query.getSingleResult();

        Integer idProveedor = proveedor.getIdproveedor();

        Proveedor updateProveedor = new Proveedor();

        updateProveedor.setIdproveedor(idProveedor);
        updateProveedor.setNombreProveedor(nombre);
        updateProveedor.setDireccion(direccion);
        updateProveedor.setTelefono(telefonoProveedorStr);
        updateProveedor.setRegimenProveedor(regimen);
        updateProveedor.setEmailProveedor(email);
        updateProveedor.setIdcuentacontable(cuenataContable);
        updateProveedor.setEstado(estado);
        entity.getTransaction().begin();
        entity.merge(updateProveedor);
        entity.getTransaction().commit();
        System.out.println("Proveedor actualizado");
    }

    public List<Proveedor> findProveedores() {
        List<Proveedor> proveedoresList = new ArrayList<>();

        try {
            Query query = entity.createNamedQuery("Proveedor.findAll", Proveedor.class);
            proveedoresList = query.getResultList();
            return proveedoresList;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
