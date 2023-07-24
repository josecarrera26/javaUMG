package com.mycompany.democlase1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author josel
 */
public class Materia {

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
     * @return the nameClass
     */
    public String getNameClass() {
        return nameClass;
    }

    /**
     * @param nameClass the nameClass to set
     */
    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    /**
     * @return the idMateria
     */
    public Integer getIdMateria() {
        return idMateria;
    }

    /**
     * @param idMateria the idMateria to set
     */
    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }
    private Integer idProfesor;
    private String nameClass;
    private Integer idMateria;

    public Materia(Integer idProfesor, String nameClass, Integer idMateria) {
        this.idProfesor = idProfesor;
        this.nameClass = nameClass;
        this.idMateria = idMateria;
    }
}
