/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.umgprogra.pruebasapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author josel
 */
public class PruebasAPP {

    public static void main(String[] args) {
         WebDriver driver = new ChromeDriver();
         driver.get("http://localhost:8080/ERP-JavaEE7/");
         System.out.println("Titulo de la pagina: " + driver.getTitle());
         
        WebElement textBox = driver.findElement(By.name("loginForm:username"));
        WebElement textPassword = driver.findElement(By.name("loginForm:password"));
        WebElement submitButton = driver.findElement(By.id("loginForm:loginButton"));
        
        textBox.sendKeys("joseC");
        textPassword.sendKeys("password1");
        submitButton.click();
    }
}
