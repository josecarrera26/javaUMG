/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.democlase1;

import java.util.ArrayList;

/**
 *
 * @author josel
 */
public class Profesor {

    /**
     * @return the idProfesor
     */
    public Integer getIdProfesor() {
        return idProfesor;
    }

    /**
     * @param idProfesor the idProfesor to set
     */
    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public Profesor(Integer idProfesor, String name) {
        this.idProfesor = idProfesor;
        this.name = name;
    }
    private Integer idProfesor;
    private String name;
    
    
    
    public static ArrayList listadoProfesores(){
        
        ArrayList<Profesor> listaProfesores = new ArrayList();
        listaProfesores.add(new Profesor(1, "Carlos L."));
        listaProfesores.add(new Profesor(2, "Daniel A."));
        listaProfesores.add(new Profesor(3, "Miguel M."));
        
        return listaProfesores;
        
    }
}
