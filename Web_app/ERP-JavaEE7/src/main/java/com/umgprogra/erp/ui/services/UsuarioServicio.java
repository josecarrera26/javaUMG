/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import com.umgprogra.erp.DAO.Empleado;
import com.umgprogra.erp.DAO.Roles;
import com.umgprogra.erp.DAO.Usuario;
import com.umgprogra.erp.util.JpaUtil;
import com.umgprogra.erp.util.SessionUser;
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

    public boolean validarABC(Usuario user) {
        boolean flag = false;
        if (user.getIdrole().getIdrole() == 6) {
            flag = true;
        }
        return flag;
    }

    public int findByUsername(String username, String password) {
        int existe = 0;
        try {

            Usuario usuario = new Usuario();

            Query query2 = entity.createNamedQuery("Usuario.findByUsername", Usuario.class)
                    .setParameter("username", username);

            usuario = (Usuario) query2.getSingleResult();

            if (Objects.equals(usuario.getUsername(), username) && usuario.getPassword().equals(password)) {
                SessionUser user = new SessionUser(usuario, validarABC(usuario));
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sessionU", user);
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

    public boolean registrarUsuario(String password, String username, Integer idrole, Integer idempleado) {

        boolean registro = false;

        Roles role = entity.find(Roles.class, idrole);

        System.out.println("Paso la consulta de roles");

        Empleado empleado = entity.find(Empleado.class, idempleado);

        Usuario rusuario = new Usuario();

        System.out.println("Paso la consulta de idEmpleado");

        rusuario.setUsername(username);
        rusuario.setPassword(password);
        rusuario.setIdrole(role);
        rusuario.setIdempleado(empleado);

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

    public void actualizarUsuario(String password, String username, Integer idrole, Integer idempleado) {
        try {
            Roles role = entity.find(Roles.class, idrole);
            Empleado empleado = entity.find(Empleado.class, idempleado);

            System.out.println("usuario: " + username);
            Usuario usuario = new Usuario();

            Query query2 = entity.createNamedQuery("Usuario.findByUsername", Usuario.class)
                    .setParameter("username", username);

            usuario = (Usuario) query2.getSingleResult();
            
            Integer idUsuario = usuario.getIdusuario();
            
            System.out.println("Usuario por consulta " + idUsuario);

            Usuario updateUsuario = new Usuario();

            updateUsuario.setIdusuario(idUsuario);
            updateUsuario.setUsername(username);
            updateUsuario.setPassword(password);
            updateUsuario.setIdrole(role);
            updateUsuario.setIdempleado(empleado);
            entity.getTransaction().begin();
            entity.merge(updateUsuario);
            entity.getTransaction().commit();
            System.out.println("usuario actualizado");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
