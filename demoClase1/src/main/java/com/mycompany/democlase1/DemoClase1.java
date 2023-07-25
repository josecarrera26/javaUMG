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

    public static void main(String[] args) {
        //creacion de MAP
        Map<Integer, String> nuevoAlumno;
        nuevoAlumno = new HashMap<>();
        
        //INPUT DEL USUSUARIO
        System.out.println("Ingrese el nombre del nuevo alumno: ");
        Scanner scanner = new Scanner(System.in);
        String nvAlmnNombre = scanner.nextLine();
        
        //PUT PARA EL MAP
        nuevoAlumno.put(nuevoAlumno.size() + 1, nvAlmnNombre);
        
        //CREACION DEL OBJETO USANDO MAP
        Alumno alum = new Alumno(nuevoAlumno.size(), nuevoAlumno.get(nuevoAlumno.size()));
        System.out.println("El alumno con la sigiente informacion ");
        System.out.println("Carnet: " + alum.getId() );
        System.out.println("Nombre: " + alum.getNombre());
        
        /*Revisando cambios*/
        //CALCULOS
        /* for (int i = 1; i <= nuevoAlumno.size(); i++) {
        System.out.println(nuevoAlumno.get(i));
        }

        System.out.println("Hello World!");*/
    }
}
