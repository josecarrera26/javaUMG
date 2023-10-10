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
public class FacturaCabPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idFactura")
    private int idFactura;
    @Basic(optional = false)
    @Column(name = "referencia_Factura")
    private int referenciaFactura;

    public FacturaCabPK() {
    }

    public FacturaCabPK(int idFactura, int referenciaFactura) {
        this.idFactura = idFactura;
        this.referenciaFactura = referenciaFactura;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
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
        hash += (int) idFactura;
        hash += (int) referenciaFactura;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaCabPK)) {
            return false;
        }
        FacturaCabPK other = (FacturaCabPK) object;
        if (this.idFactura != other.idFactura) {
            return false;
        }
        if (this.referenciaFactura != other.referenciaFactura) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.umgprogra.erp.DAO.FacturaCabPK[ idFactura=" + idFactura + ", referenciaFactura=" + referenciaFactura + " ]";
    }
    
}
