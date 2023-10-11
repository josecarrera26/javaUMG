/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.Empleado;
import com.umgprogra.erp.DAO.Facturacab;
import com.umgprogra.erp.DAO.FacturacabPK;
import com.umgprogra.erp.DAO.Facturadet;
import com.umgprogra.erp.util.JpaUtil;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author josel
 */
public class Facturas {

    EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();

//    public Integer lastFactura() {
//        Facturadet ultimaFactura = new Facturadet();
//        Query query2 = entity.createNamedQuery("findLastFactura", Facturadet.class);
//        ultimaFactura = (Facturadet) query2.getSingleResult();
//        return ultimaFactura.getIdfactura() + 1;
//    }

    public String insertarFacturacab(Date pFechaRegistro, Integer pPlazoPagos, Integer pReferenciaFactura, Integer pIDEmpleado, Integer pTipoCliente, Integer pEstadoFactura, BigInteger pTotal, Integer pTipoPago, String nit, Integer pTipoFactura) {
        try {

            FacturacabPK facturaRef = new FacturacabPK();
            facturaRef.setIdfactura(pReferenciaFactura);
            facturaRef.setReferenciaFactura(pReferenciaFactura);

            Empleado idEmpleado = new Empleado();
            idEmpleado.setIdempleado(pIDEmpleado);

            Facturacab facturacabecera = new Facturacab();
            facturacabecera.setFechaRegistro(pFechaRegistro);
            facturacabecera.setPlazosPago(pPlazoPagos);
            facturacabecera.setFacturacabPK(facturaRef);
            facturacabecera.setIdempleado(idEmpleado);
            facturacabecera.setIdtipocliente(pTipoCliente);
            facturacabecera.setEstadofac(pEstadoFactura);
            facturacabecera.setTotal(pTotal);
            facturacabecera.setIdtipofactura(pTipoFactura);
            facturacabecera.setNit(nit);
            facturacabecera.setIdtipofactura(pTipoFactura);

            entity.getTransaction().begin();
            entity.persist(facturacabecera);
            entity.getTransaction().commit();

            return "FacturaCab Guardada Numero de factura";
        } catch (Exception e) {

            return "Error Mensaje: " + e.toString();
        }
    }
}
