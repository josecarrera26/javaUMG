/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.Cliente;
import com.umgprogra.erp.DAO.Empleado;
import com.umgprogra.erp.DAO.Facturacab;
import com.umgprogra.erp.util.JpaUtil;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author josel
 */

@ManagedBean
@SessionScoped
public class FacturasServicio {

    @PostConstruct
    public void init() {
        listadoClientes();
        getLastFactura();
    }

    EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();

    public int  getLastFactura() {
       // Object[] ultimaFactura;
        int  idFac =0;
        try {
            Query query = entity.createNamedQuery("Facturacab.findUltimaFactura");
            idFac = (int) query.getSingleResult();
           // contarFacturas = facturas.size();
            //idFac = ultimaFactura.getIdfactura();
            
            System.out.println("Esta es la utlima factura: " + idFac);
        } catch (Exception e) {
            System.err.println("Error en getAllFacturas " + e.getMessage());
        }
        return idFac;
    }

    public String insertarFacturacab(Integer pPlazoPagos, Integer pIDEmpleado, Integer pTipoCliente, Double pTotal, Integer pTipoPago, String nit, Integer pTipoFactura) {
        try {
            
            //preparacion de ingreso de fecha
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime ahora = LocalDateTime.now();
            String fechaString = dtf.format(ahora);
            Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaString);

            Empleado empleado = entity.find(Empleado.class, pIDEmpleado);

            Facturacab facturacabecera = new Facturacab();

            facturacabecera.setFechaRegistro(fecha);
            facturacabecera.setPlazosPago(pPlazoPagos);
            facturacabecera.setIdempleado(empleado);
            facturacabecera.setIdtipocliente(pTipoCliente);
            facturacabecera.setEstadofac(1);
            facturacabecera.setTotal(pTotal);
            facturacabecera.setIdtipopago(pTipoPago);
            facturacabecera.setNit(nit);
            

            entity.getTransaction().begin();
            entity.persist(facturacabecera);
            entity.getTransaction().commit();

            return "FacturaCab Guardada Numero de factura";
        } catch (Exception e) {

            return "Error Mensaje: " + e.toString();
        }
    }


    //mostrar id del cliete
    public List<Cliente> listadoClientes() {
        EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();

        List<Cliente> resultado = new ArrayList<>();
        //query para obtener el resutado
        Query query = entity.createNamedQuery("Cliente.findAll", Cliente.class);

        //obtenemos el resultado de la lista
        resultado = query.getResultList();

        return resultado;

    }



}
