/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.javaee7UI;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import org.primefaces.PrimeFaces;
import org.primefaces.model.DialogFrameworkOptions;

/**
 *
 * @author josel
 */
@ManagedBean
@ViewScoped
public class MenuPrincipalUI {
    
    public MenuPrincipalUI() {
    }

    public void viewProducts() {
            System.out.println("estas en mainmenu");
            DialogFrameworkOptions options = DialogFrameworkOptions.builder()
                    .resizable(false)
                    .build();
            System.out.println("Se crean las opciones del dialog");
            PrimeFaces.current().dialog().openDynamic("sinacceso.xhtml", options, null);
            System.out.println("Se crean las el dialog");
    }
}
