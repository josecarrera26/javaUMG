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
public class Alumno {
    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the estado
     */
    public Boolean getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Alumno(Integer id, String nombre, Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }
    
    
    //Carnet
    private Integer id;
    //nombre del estudiante
    private String nombre;
    //1 activo 0 inactivo
    private Boolean estado;
    
    
    
    public static ArrayList rosterAlumnos(){
        
        ArrayList<Alumno> listadoAlumnos = new ArrayList();
        listadoAlumnos.add(new Alumno(1, "Jose Luis Carrera M." , true));
        listadoAlumnos.add(new Alumno(2, "Stephany Maricee M.", true));
        listadoAlumnos.add(new Alumno(3, "Francisco Duran C.", false));  
        
        return listadoAlumnos;
        
    }
}

