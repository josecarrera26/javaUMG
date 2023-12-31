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

@ManagedBean(name="sessionU")
@SessionScoped

public class SessionUser implements Serializable{

    /**
     * @return the flag
     */
    public boolean isFlag() {
        return flag;
    }

    /**
     * @param flag the flag to set
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }


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


    public SessionUser(Usuario user, boolean flag) {
        this.user = user;
        this.flag = flag;
       
    }
    
    public SessionUser(){
        
    }
    
    private Usuario user;
    private boolean  flag;
       
}
