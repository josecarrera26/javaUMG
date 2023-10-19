/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.Empleado;
import com.umgprogra.erp.DAO.Usuario;
import com.umgprogra.erp.DAO.Usuario_;
import com.umgprogra.erp.util.JpaUtil;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author hccon
 */
public class UsuarioServicio {

    EntityManager entity = JpaUtil.getEntityManagerFactory().createEntityManager();

    public int findByUsername(String username, String password) {

        try {

            Usuario usuario = new Usuario();

            Query query2 = entity.createNamedQuery("Usuario.findByUsername", Usuario.class)
                    .setParameter("username", username);

            usuario = (Usuario) query2.getSingleResult();

            System.out.println("usuername = " + usuario.getUsername() + " " + " password" + usuario.getPassword());

            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

            if (Objects.equals(usuario.getUsername(), username) && usuario.getPassword().equals(password)) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Conexion Exitosa",
                        "Gracias!"));

                externalContext.redirect("views/MenuPrincipal.xhtml");
                return 1;

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Nombre o Contraseña Invalida!",
                        "Por Favor intente Nuevamente!"));
                return 0;
            }
        } catch (Exception e) {
            System.out.println("Error registrado = " + e.getMessage());
        }
        return 0;
    }

    public boolean registrarUsuario(String password, String username) {

        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

        boolean registro = false;

        Usuario findusuario = new Usuario();

        Query query2 = entity.createNamedQuery("Usuario.findByUsername", Usuario.class)
                    .setParameter("username", username);
        
        findusuario = (Usuario) query2.getSingleResult();
   
        if (findusuario.getIdempleado() == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Username ya existe!",
                    "Por favor ingrese un nuevo username!"));
        } else {

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
        }
        return registro;
    }

}
