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
         driver.get("https://www.selenium.dev/selenium/web/web-form.html");
         System.out.println("Titulo de la pagina: " + driver.getTitle());
         
        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement textPassword = driver.findElement(By.name("my-password"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));
        
        textBox.sendKeys("prueba");
        textPassword.sendKeys("prueba 2");
        submitButton.click();
    }
}
