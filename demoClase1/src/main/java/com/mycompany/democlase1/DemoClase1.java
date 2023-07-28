/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.democlase1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author josel
 */
public class DemoClase1 {
    
    private Map<Integer, Materia> map;

    public DemoClase1() {
         map =new HashMap<>();
    }

    
    public static void main(String[] args) {
        
        //creacion de variables y objetos
        Integer option = 1;
        
    //Creacion de Alumnos
        //Array de Alumnos
        Alumno[] rosterAlumnos = new Alumno [10];
        
        Alumno alumno1 = new Alumno(1, "Jose Luis Carrera Moreno" , true);
        Alumno alumno2 = new Alumno(2, "Stephany Maricee Martinez Cojulun", true);
        Alumno alumno3 = new Alumno(3, "Stephany Maricee Martinez Cojulun", false);
        
        rosterAlumnos [1] = alumno1;
        rosterAlumnos [2] = alumno2;
        rosterAlumnos [3] = alumno3;    
    
    //Creacion de Profesores
        //Array de Profesores  
        
       Profesor[] rosterProfes = new Profesor [10];
       
       Profesor prMatematica = new Profesor(1, "Carlos Lopez");
       Profesor prCiencias = new Profesor(2, "Daniel Alavarado");
       Profesor prMusica = new Profesor(3, "Chapo");
       
       rosterProfes[1] = prMatematica;
       rosterProfes[2] = prCiencias;
       rosterProfes [3] = prMusica;
       
    //Creacion de Materias
        //Array de Materias         
        Materia[] listadoMaterias = new Materia [10];
        Materia matematicas = new Materia(rosterProfes[1].getIdProfesor(), "Matematicas", 1);
        Materia ciencias = new Materia(rosterProfes[2].getIdProfesor(), "Matematicas", 2);
        Materia musica = new Materia(rosterProfes[3].getIdProfesor(), "Matematicas", 3);
        
        listadoMaterias[1] = matematicas;
        listadoMaterias[2] = ciencias;
        listadoMaterias[3] = musica;
 //creacion de MAP
        
        
        String strTest = "2";
        
        System.out.println(rosterAlumnos[Integer.parseInt(strTest)].getNombre());
        System.out.println(rosterAlumnos[Integer.parseInt(strTest)].getId());
        System.out.println(rosterAlumnos[Integer.parseInt(strTest)].getEstado());
        while (option < 3 ){
            
            
            //INPUT DEL USUSUARIO
            System.out.println("Ingrese el numero de carnet ");
            Scanner nvoAlumno = new Scanner(System.in);
            String numCarnet = nvoAlumno.nextLine();
            
            
            if (!rosterAlumnos[Integer.parseInt(numCarnet)].getEstado()){
                System.out.println("El estudiante no esta activo.");
                System.exit(0);
            }
            //PUT PARA EL MAP
            //nuevoAlumno.put(nuevoAlumno.size() + 1, nvAlmnNombre);
            
            //CREACION DEL OBJETO USANDO MAP
            // Alumno alum = new Alumno(nuevoAlumno.size(), nuevoAlumno.get(nuevoAlumno.size()));
            // System.out.println("El alumno con la sigiente informacion ");
            // System.out.println("Carnet: " + alum.getId() );
            // System.out.println("Nombre: " + alum.getNombre());
            
//            System.out.println("Would you like to add another student?");
//            Scanner optionIn = new Scanner(System.in);
//            option = optionIn.nextInt();
            
            // System.out.println("Hello World!");*/
        }

        /*Revisando cambios*/
            //CALCULOS
            // for (int i = 1; i <= nuevoAlumno.size(); i++) {
            // System.out.println(i + " " + nuevoAlumno.get(i));
            //}
        
    }
}


