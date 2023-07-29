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
    
    public static void main(String[] args) {
        
    //creacion de variables y objetos       
        Map<Alumno, Materia> asignacion = new HashMap();
        Scanner scanner = new Scanner(System.in);
        Integer carnet;
        Integer cursoId;
        Integer opcion = 0;
        String estado;
        Integer salir = 0;
    //Creacion de Alumnos
        //Array de Alumnos
        ArrayList <Alumno> roster = Alumno.rosterAlumnos();
    
    //Creacion de Profesores
        //Array de Profesores  
        
       ArrayList <Profesor> maestros = Profesor.listadoProfesores();
       
       
    //Creacion de Materias
        //Array de Materias         
        
    ArrayList <Materia> cursos = Materia.listadoMaterias(maestros);
        
        //Menu Principal
        
        while (salir != 1){
            System.out.println("Sistema de asignacion");
            System.out.println("Seleccione la opcion deseada");
            System.out.println("1. Nueva asignacion");
            System.out.println("2. Listado de alumnos");
            System.out.println("3. Listado de curos");
            System.out.println("4. Listado de curos asignados");
            opcion = scanner.nextInt();
        
        
            switch (opcion){
                case 1:
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println("Ingregese su numero de carnet");
                    carnet = scanner.nextInt();
                    System.out.println("Ingregese el codigo del curso");
                    cursoId = scanner.nextInt();
                    asignacion.put(roster.get(carnet-1),cursos.get(cursoId-1));
                    System.out.println("Clase asignada: "+asignacion.get(roster.get(carnet-1)).getNombreCurso()+"\nAl alumno: "+roster.get(carnet-1).getNombre());
                    System.out.println("------------------------------------------------------------------------");
                    break;
                case 2:
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println("Alumnos");
                    System.out.println("Carnet\t\t\tNombre\t\t\t\tEstado");
                    for (Alumno alumno : roster){
                        if (alumno.getEstado()){
                            estado = "Activo";
                        }
                        else{
                            estado = "Inactivo";
                        }
                        System.out.println(alumno.getId()+"\t\t\t"+alumno.getNombre()+"\t\t"+ estado);
                    }
                    System.out.println("------------------------------------------------------------------------");
                    break;
                case 3:
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println("Materias");
                    System.out.println("ID Profesor\tNombre Profesor\t\tID Curso\tNombre Materia");
                    
                    for (Materia curso :cursos){
                        System.out.println(curso.getCatedratico().getIdProfesor()+"\t\t"+curso.getCatedratico().getName()+"\t\t"+curso.getIdMateria()+"\t\t"+curso.getNombreCurso());
                    }
                    System.out.println("------------------------------------------------------------------------");
                    break;
                case 4:
                    if (asignacion.size() == 0){
                        System.out.println("No se ha asignado cursos aun.");
                    }
                    else {
                        System.out.println("Alumno\t\t\t\tID Materia\t\t\tMateria\t\t\tCatedratico");
                        for (Alumno asignado : asignacion.keySet()){
                            System.out.println(asignado.getNombre()+"\t\t\t"+asignacion.get(asignado).getIdMateria()+"\t\t\t"+asignacion.get(asignado).getNombreCurso()+"\t\t\t"+asignacion.get(asignado).getCatedratico().getName());
                            System.out.println();
                            System.out.println();
                        }
                    }
                        
                }
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Desea Salir?");
                System.out.println("0. No");
                System.out.println("1. Si");
                salir = scanner.nextInt();
        }
    }
}


