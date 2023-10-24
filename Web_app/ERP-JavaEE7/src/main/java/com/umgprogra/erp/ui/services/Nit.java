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


/**
 *
 * @author josel
 */
public class Nit {
    public String getNitApi(String nit){
     HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("url"+nit);
        httpGet.addHeader("correo", "devcom");
        httpGet.addHeader("password", "Way2023");

        try {
            HttpResponse response = httpClient.execute(httpGet);

            // Verifica si la respuesta es exitosa (código 200)
            if (response.getStatusLine().getStatusCode() == 200) {
                // Convierte la respuesta JSON a una clase personalizada
                String jsonResponse = EntityUtils.toString(response.getEntity());

                JSONObject jsonObject = new JSONObject(jsonResponse);

                // Extract "data_usuario" array
                JSONArray dataUsuarioArray = jsonObject.getJSONArray("data_usuario");

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
            return e.getMessage();
        }
    }
}
