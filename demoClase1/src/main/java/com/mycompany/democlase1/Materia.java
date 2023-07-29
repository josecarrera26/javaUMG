package com.mycompany.democlase1;

import java.util.ArrayList;

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

    /**
     * @return the nombreCurso
     */
    public String getNombreCurso() {
        return nombreCurso;
    }

    /**
     * @param nombreCurso the nombreCurso to set
     */
    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    /**
     * @return the catedratico
     */
    public Profesor getCatedratico() {
        return catedratico;
    }

    /**
     * @param catedratico the catedratico to set
     */
    public void setCatedratico(Profesor catedratico) {
        this.catedratico = catedratico;
    }

    private Integer idMateria;
    private String nombreCurso;
    private Profesor catedratico;

    public Materia(Integer idMateria, String nombreCurso, Profesor catedratico) {
        this.idMateria = idMateria;
        this.nombreCurso = nombreCurso;
        this.catedratico = catedratico;
    }


    
    public static ArrayList listadoMaterias(ArrayList<Profesor> listadoProfes){
        
        Integer i = 0;
        ArrayList<Materia> listaMaterias = new ArrayList();
        
        for (Profesor profe : listadoProfes){
            switch (i) {
                case 0:    
                    listaMaterias.add(new Materia(i++, "Matematicas", profe));
                    break;
                case 1:
                    listaMaterias.add(new Materia(i++, "Ciencias", profe));
                    break;
                case 2:
                    listaMaterias.add(new Materia(i++, "Musica", profe));
                    break;
                default:
                    break;
            }
        }
        return listaMaterias;
        
    }
}
