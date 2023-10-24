/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.javaee7UI;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;
import org.primefaces.model.DialogFrameworkOptions;

/**
 *
 * @author madis
 */
@ManagedBean
@ViewScoped
public class DfView implements Serializable {

    public void viewMarca() {
        try {
            DialogFrameworkOptions options = DialogFrameworkOptions.builder()
                    .resizable(true)
                    .build();
            System.out.println("Se crean las opciones del dialog");
            PrimeFaces.current().dialog().openDynamic("marca", options, null);
            System.out.println("Se crean las el dialog");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Se crean las el dialog");
        }
    }
}
