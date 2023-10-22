/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.Usuario;
import com.umgprogra.erp.util.JpaUtil;
import com.umgprogra.erp.util.SessionUser;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.json.JsonArray;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author hccon
 */
public class UsuarioServicio {

    EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();

    public int findByUsername(String username, String password) {
        int existe = 0;
        try {

            Usuario usuario = new Usuario();

            Query query2 = entity.createNamedQuery("Usuario.findByUsername", Usuario.class)
                    .setParameter("username", username);

            usuario = (Usuario) query2.getSingleResult();

            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

            if (Objects.equals(usuario.getUsername(), username) && usuario.getPassword().equals(password)) {
                existe = 1;
                return existe;

            } else {
                existe = 0;
                return existe;
            }
        } catch (Exception e) {
            System.out.println("Error registrado = " + e.getMessage());

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Username No Existe",
                    "Por Favor registrese Antes!"));
            existe = 0;
            return existe;
        }
    }

    public boolean registrarUsuario(String password, String username) {

        boolean registro = false;
        
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

        Usuario rusuario = new Usuario();

        rusuario.setUsername(username);
        rusuario.setPassword(password);

        entity.getTransaction().begin();

        try {
            entity.persist(rusuario);
            entity.getTransaction().commit();
            entity.close();
            registro = true;

        } catch (Exception e) {
            entity.getTransaction().rollback();
            registro = false;
        }
        return registro;
    }
}
