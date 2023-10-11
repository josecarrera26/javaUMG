/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.DAO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author josel
 */
@Embeddable
public class FacturacabPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idfactura")
    private int idfactura;
    @Basic(optional = false)
    @Column(name = "referencia_factura")
    private int referenciaFactura;

    public FacturacabPK() {
    }

    public FacturacabPK(int idfactura, int referenciaFactura) {
        this.idfactura = idfactura;
        this.referenciaFactura = referenciaFactura;
    }

    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    public int getReferenciaFactura() {
        return referenciaFactura;
    }

    public void setReferenciaFactura(int referenciaFactura) {
        this.referenciaFactura = referenciaFactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idfactura;
        hash += (int) referenciaFactura;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturacabPK)) {
            return false;
        }
        FacturacabPK other = (FacturacabPK) object;
        if (this.idfactura != other.idfactura) {
            return false;
        }
        if (this.referenciaFactura != other.referenciaFactura) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.umgprogra.erp.DAO.FacturacabPK[ idfactura=" + idfactura + ", referenciaFactura=" + referenciaFactura + " ]";
    }
    
}
