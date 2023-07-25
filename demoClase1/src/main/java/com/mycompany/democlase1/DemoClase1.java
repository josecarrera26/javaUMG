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
    
    public Map<Integer, Materia> asignacion;

    // public Programa() {
    //     asignacion =new HashMap<>();
    // }

    public static void main(String[] args) {
        
        Integer option = 1;
        
        // Programa programa = new Programa();
        
        //creacion de MAP
        Map<Integer, String> nuevoAlumno;
        nuevoAlumno = new HashMap<>();
        
        
        
        while (option < 3 ){
            //INPUT DEL USUSUARIO
            System.out.println("Ingrese el nombre del nuevo alumno: ");
            Scanner nvoAlumno = new Scanner(System.in);
            String nvAlmnNombre = nvoAlumno.nextLine();
            
            //PUT PARA EL MAP
            nuevoAlumno.put(nuevoAlumno.size() + 1, nvAlmnNombre);
            
            //CREACION DEL OBJETO USANDO MAP
            Alumno alum = new Alumno(nuevoAlumno.size(), nuevoAlumno.get(nuevoAlumno.size()));
            System.out.println("El alumno con la sigiente informacion ");
            System.out.println("Carnet: " + alum.getId() );
            System.out.println("Nombre: " + alum.getNombre());
            
            System.out.println("Would you like to add another student?");
            Scanner optionIn = new Scanner(System.in);
            option = optionIn.nextInt();
            
            // System.out.println("Hello World!");*/
        }

        /*Revisando cambios*/
            //CALCULOS
            for (int i = 1; i <= nuevoAlumno.size(); i++) {
            System.out.println(i + " " + nuevoAlumno.get(i));
            }
        
    }
}
