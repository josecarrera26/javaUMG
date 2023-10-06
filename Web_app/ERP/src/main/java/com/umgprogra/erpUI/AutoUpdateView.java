/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erpUI;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author josel
 */
@Named
@RequestScoped
public class AutoUpdateView {

    private String time;

    @PostConstruct
    public void init() {
            SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-YYYY");
        Date now = new Date();
        time = sdfDate.format(now);
        System.out.println(time);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    public void test(){
    System.out.println("prueba");
    }
}
