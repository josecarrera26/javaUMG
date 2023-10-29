/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.umgprogra.pruebasapp;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author josel
 */
public class PruebasAPP {

    public static List<String> paginas() {
        List<String> paginasList = new ArrayList<>();
        paginasList.add("Cargo.xhtml");
        paginasList.add("Cliente.xhtml");
        paginasList.add("CuentasContables.xhtml");
        paginasList.add("Empleado.xhtml");
        paginasList.add("FacturacionCompra.xhtml");
        paginasList.add("Facturas.xhtml");
        paginasList.add("Inventario.xhtml");
        paginasList.add("MenuPrincipal.xhtml");
        paginasList.add("Proveedores.xhtml");
        paginasList.add("Role.xhtml");
        paginasList.add("editarProducto.xhtml");
        paginasList.add("kardex.xhtml");
        return paginasList;
    }

    public static void pruebaUsuarioLogeado(List<String> paginas) throws InterruptedException {
        try {
            WebDriver driver = new ChromeDriver();
            for (String pagina : paginas) {
                driver.get("http://localhost:8080/ERP-JavaEE7/views/" + pagina);
                System.out.println("Pasando por: " + pagina);
                System.out.println("Titulo de la pagina: " + driver.getTitle());
                Thread.sleep(1000);
            }
            driver.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void pruebaPaginaLoggeado(List<String> paginas) {
        try {
            WebDriver driver = new ChromeDriver();
            for (String pagina : paginas) {
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
                Thread.sleep(1000);
                WebElement logoutButton = driver.findElement(By.cssSelector(".ui-button"));
                System.out.println("Pasando por: " + pagina);
                System.out.println("Titulo de la pagina: " + driver.getTitle());
                Thread.sleep(1000);
                logoutButton.click();
                Thread.sleep(1000);
            }
            driver.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void insertarCuentasContables() {
        try {
            WebDriver driver = new ChromeDriver();
            driver.get("http://localhost:8080/ERP-JavaEE7/");
            WebElement textBox = driver.findElement(By.name("loginForm:username"));
            WebElement textPassword = driver.findElement(By.name("loginForm:password"));
            WebElement submitButton = driver.findElement(By.id("loginForm:loginButton"));
            textBox.clear();
            textPassword.clear();
            textBox.sendKeys("joseC");
            textPassword.sendKeys("password1");
            submitButton.click();
            
            driver.get("http://localhost:8080/ERP-JavaEE7/views/CuentasContables.xhtml");
            WebElement nombreCuenta = driver.findElement(By.name("j_idt33:j_idt34:nomCuenta"));
            WebElement tipoCuenta = driver.findElement(By.name("j_idt33:j_idt34:tipCuenta"));
            WebElement botonGuardar = driver.findElement(By.name("j_idt33:j_idt34:RegisterCuenta"));
            nombreCuenta.sendKeys("pruebaSelenium");
            tipoCuenta.sendKeys("pruebaSelenium");
            botonGuardar.click();
            Thread.sleep(3000);
            driver.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void insertarEmpleados() {
        try {
            WebDriver driver = new ChromeDriver();
            driver.get("http://localhost:8080/ERP-JavaEE7/");
            WebElement textBox = driver.findElement(By.name("loginForm:username"));
            WebElement textPassword = driver.findElement(By.name("loginForm:password"));
            WebElement submitButton = driver.findElement(By.id("loginForm:loginButton"));
            textBox.clear();
            textPassword.clear();
            textBox.sendKeys("joseC");
            textPassword.sendKeys("password1");
            submitButton.click();
            
            driver.get("http://localhost:8080/ERP-JavaEE7/views/Empleado.xhtml");
            WebElement nombreEmpleado = driver.findElement(By.name("j_idt35:j_idt36:nomEmpleadoe"));
            WebElement apellidoEmpleado = driver.findElement(By.name("j_idt35:j_idt36:ApelliEmpleado"));
            WebElement telefonoEmpleado = driver.findElement(By.name("j_idt35:j_idt36:TelEmpleado"));
            WebElement emailEmpleado = driver.findElement(By.name("j_idt35:j_idt36:EmailEmp"));
            
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void insertarCargo() {
        try {
            WebDriver driver = new ChromeDriver();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void insertarRoles() {
        try {
            WebDriver driver = new ChromeDriver();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void insertarCliente() {
        try {
            WebDriver driver = new ChromeDriver();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void insertarInsertar() {
        try {
            WebDriver driver = new ChromeDriver();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void insertarProveedores() {
        try {
            WebDriver driver = new ChromeDriver();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> paginasList = new ArrayList<>();
        paginasList = (ArrayList<String>) paginas();
//        pruebaUsuarioLogeado(paginasList);
//        System.out.println("Termina prueba de inicio de sesion requerido");
//        pruebaPaginaLoggeado(paginasList);
//        System.out.println("Termina prueba loggin y sesion iniciada");
        insertarCuentasContables();
    }
}
