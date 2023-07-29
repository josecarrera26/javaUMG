/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.democlase1;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author josel
 */
public class DemoClase1 {
    private Map <Alumno, Materia> asignacion;    
    
    public DemoClase1(){
    asignacion = new HashMap<>();
    }
    
    public static void main(String[] args) {
        
        //creacion de variables y objetos
        Integer option = 1;
        
    //Creacion de Alumnos
        //Array de Alumnos
        ArrayList <Alumno> roster = Alumno.rosterAlumnos();
        
        System.out.println("Alumnos");
        System.out.println("Carnet\t\t\tNombre\t\t\t\tEstado");
        String estado;
        for (Alumno alumno : roster){
            if (alumno.getEstado()){
                estado = "Activo";
            }
            else{
                estado = "Inactivo";
            }
            
            System.out.println(alumno.getId()+"\t\t\t"+alumno.getNombre()+"\t\t"+ estado);
        }
    
    //Creacion de Profesores
        //Array de Profesores  
        
       ArrayList <Profesor> maestros = Profesor.listadoProfesores();
       
        System.out.println("Catedraticos");
        System.out.println("ID Profesor\tNombre del Catedratico");
       for (Profesor profe : maestros){
           System.out.println(profe.getIdProfesor()+"\t\t"+profe.getName());
       }
       
        System.out.println(maestros.get(1).getIdProfesor());
       
    //Creacion de Materias
        //Array de Materias         
        
    ArrayList <Materia> cursos = Materia.listadoMaterias(maestros);
    
        System.out.println("Materias");
        System.out.println("ID Profesor\tNombre Profesor\t\tID Curso\tNombre Materia");
        
        for (Materia curso :cursos){
            System.out.println(curso.getCatedratico().getIdProfesor()+"\t\t"+curso.getCatedratico().getName()+"\t\t"+curso.getIdMateria()+"\t\t"+curso.getNombreCurso());
        }
        

        /*Revisando cambios*/
            //CALCULOS
            // for (int i = 1; i <= nuevoAlumno.size(); i++) {
            // System.out.println(i + " " + nuevoAlumno.get(i));
            //}
        
    }
}


