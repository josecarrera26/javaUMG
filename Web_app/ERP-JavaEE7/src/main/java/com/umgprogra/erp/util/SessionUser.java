/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.util;

import com.umgprogra.erp.DAO.Usuario;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author madis
 */

@ManagedBean(name="session")
@SessionScoped
public class SessionUser implements Serializable{


    /**
     * @return the idUser
     */
    public Usuario getUser() {
        return user;
    }

    /**
     * @param user the idUser to set
     */
    public void setUser(Usuario user) {
        this.user = user;
    }


    public SessionUser(Usuario user) {
        this.user = user;
       
    }
    
    public SessionUser(){
        
    }
    
    private Usuario user;
 
    
}
