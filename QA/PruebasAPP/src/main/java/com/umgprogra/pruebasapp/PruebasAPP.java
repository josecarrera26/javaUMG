/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.umgprogra.pruebasapp;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author josel
 */
public class PruebasAPP {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> paginasList = new ArrayList<>();
        paginasList.add("Cargo.xhtml");
        paginasList.add("Cliente.xhtml");
        paginasList.add("CuentasContables.xhtml");
        paginasList.add("Empleado.xhtml");
        paginasList.add("FacturaDET.xhtml");
        paginasList.add("FacturacionCompra.xhtml");
        paginasList.add("Facturas.xhtml");
        paginasList.add("Inventario.xhtml");
        paginasList.add("MenuPrincipal.xhtml");
        paginasList.add("Pedidos.xhtml");
        paginasList.add("Proveedores.xhtml");
        paginasList.add("Role.xhtml");
        paginasList.add("editarProducto.xhtml");

        WebDriver driver = new ChromeDriver();
        for (String pagina : paginasList) {
            driver.get("http://localhost:8080/ERP-JavaEE7/views/" + pagina);
            System.out.println("Pasando por: " + pagina);
            System.out.println("Titulo de la pagina: " + driver.getTitle());
            Thread.sleep(1000);
        }
        System.out.println("Termina prueba de inicio de sesion requerido");
        
        for (String pagina : paginasList) {
            driver.get("http://localhost:8080/ERP-JavaEE7");
            WebElement textBox = driver.findElement(By.name("loginForm:username"));
            WebElement textPassword = driver.findElement(By.name("loginForm:password"));
            WebElement submitButton = driver.findElement(By.id("loginForm:loginButton"));
            textBox.clear();
            textPassword.clear();
            textBox.sendKeys("joseC");
            textPassword.sendKeys("password1");
            submitButton.click();
            driver.get("http://localhost:8080/ERP-JavaEE7/views/" + pagina);
            WebElement logoutButton = driver.findElement(By.cssSelector(".ui-button"));
            System.out.println("Pasando por: " + pagina);
            System.out.println("Titulo de la pagina: " + driver.getTitle());
            Thread.sleep(1000);
            logoutButton.click();
            Thread.sleep(2000);
            
        }
    }
}
