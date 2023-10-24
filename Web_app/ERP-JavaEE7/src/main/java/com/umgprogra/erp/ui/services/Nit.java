/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umgprogra.erp.ui.services;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.json.JSONArray;
import java.io.BufferedReader;
import java.io.FileReader;


/**
 *
 * @author josel
 */
public class Nit {
    public String getNitApi(String nit){
     HttpClient httpClient = HttpClients.createDefault();
        
        
        String rutaDelArchivo = "C:/ignore/parametros.txt";

        try {
             // Obtener el directorio actual
        String directorioActual = System.getProperty("user.dir");

        // Mostrar el directorio actual
        System.out.println("Directorio actual: " + directorioActual);
            FileReader fileReader = new FileReader(rutaDelArchivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            System.out.println("bufferReader: " + bufferedReader.toString());
            // Leer la primera línea del archivo
            String primeraLinea = bufferedReader.readLine();

            // Verificar si se ha leído algo
            if (primeraLinea != null) {
                System.out.println("Primera línea del archivo: " + primeraLinea);
            } else {
                System.out.println("El archivo está vacío o no se pudo leer la primera línea.");
            }

            // Cerrar el archivo
            bufferedReader.close();
            HttpGet httpGet = new HttpGet(primeraLinea+nit);
            System.out.println(primeraLinea+nit);
            httpGet.addHeader("correo", "devcom");
            httpGet.addHeader("password", "Way2023");
            
            HttpResponse response = httpClient.execute(httpGet);

            // Verifica si la respuesta es exitosa (código 200)
            if (response.getStatusLine().getStatusCode() == 200) {
                // Convierte la respuesta JSON a una clase personalizada
                String jsonResponse = EntityUtils.toString(response.getEntity());

                JSONObject jsonObject = new JSONObject(jsonResponse);
                
                // Extract "data_usuario" array
                JSONArray dataUsuarioArray = jsonObject.getJSONArray("data_usuario");
                System.out.println("json respuesta: " + dataUsuarioArray.toString());
                // Get the first object from the array
                JSONObject firstDataUsuarioObject = dataUsuarioArray.getJSONObject(0);

                // Extract the value of "nombre_nit_cliente"
                String nombreNitCliente = firstDataUsuarioObject.getString("nombre_nit_cliente");

                // Print the extracted value
                System.out.println("nombre_nit_cliente: " + nombreNitCliente);
                
                return nombreNitCliente;
            } else {
                String retorno = "La solicitud no fue exitosa. Código de respuesta: " + response.getStatusLine().getStatusCode();
                return retorno;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return e.getMessage();
        }
    }
}
