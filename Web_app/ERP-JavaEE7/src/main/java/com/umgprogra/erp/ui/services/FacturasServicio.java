/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.Empleado;
import com.umgprogra.erp.DAO.Facturacab;
import com.umgprogra.erp.util.JpaUtil;
import com.umgprogra.erp.util.SessionUser;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author josel
 */
public class FacturasServicio {

    @Inject
    private SessionUser sessionUser = (SessionUser) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("session");

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

    public int getLastFactura() {
        // Object[] ultimaFactura;
        int idFac = 0;
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
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime ahora = LocalDateTime.now();
            Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(dtf.format(ahora));

            int idEmpleado = sessionUser.getIdEmpleado();

            Empleado idDeEmpleado = new Empleado();
            Query query = entity.createNamedQuery("Empleado.findByIdempleado", Empleado.class)
                    .setParameter(idEmpleado, "idempleado");

            idDeEmpleado = (Empleado) query.getSingleResult();

            Facturacab facturacabecera = new Facturacab();
            facturacabecera.setFechaRegistro(fecha);
            facturacabecera.setPlazosPago(pPlazoPagos);
            facturacabecera.setIdempleado(idDeEmpleado);
            facturacabecera.setIdtipocliente(pTipoCliente);
            facturacabecera.setEstadofac(1);
            facturacabecera.setTotal(pTotal);
            facturacabecera.setIdtipopago(pTipoPago);
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
