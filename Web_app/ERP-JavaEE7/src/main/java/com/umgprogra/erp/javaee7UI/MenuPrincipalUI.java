/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.javaee7UI;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;
import org.primefaces.model.DialogFrameworkOptions;
import java.io.Serializable;

/**
 *
 * @author josel
 */
@ManagedBean
@ViewScoped
public class MenuPrincipalUI implements Serializable{
    
    public MenuPrincipalUI() {
    }

    public void viewProducts() {
        System.out.println("estas en mainmenu");
        DialogFrameworkOptions options = DialogFrameworkOptions.builder()
                .resizable(true)
                .contentHeight("100%")
                .contentWidth("100%")
                .build();
            System.out.println("Se crean las opciones del dialog");
            PrimeFaces.current().dialog().openDynamic("sinacceso", options, null);
            System.out.println("Se crean las el dialog");
    }
}
