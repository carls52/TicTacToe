
package Tests;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Carlos Gil Sabrido
 */
public class TestSistem {
    
    protected WebDriver driver1;
    protected WebDriver driver2;
    
    String n1 = "Pepe";
    String n2 = "Juan";
    
    String resultadoEsperado1 = n1+" wins! "+n2+" looses.";
    String resultadoEsperado2 = n2+" wins! "+n1+" looses.";
    String Draw = "Draw!";
    
    @Before
    public void setUp() {
    //Iniciamos los navegadores 
        System.setProperty("webdriver.chrome.driver","C:/Users/Carlos Gil Sabrido/Documents/chromedriver.exe");
        ChromeDriverManager.getInstance().setup();
        
        driver1 = new ChromeDriver();
        driver2 = new ChromeDriver();
       
        driver1.get("http://localhost:8080");
        driver2.get("http://localhost:8080");
        
    }
    @BeforeClass
    public static void setUpClass(){
        ChromeDriverManager.getInstance().setup();
    }
    @Test
    public void testPlayer1Wins() throws Exception {
        //Añadimos los nombres de los jugadores
        driver1.findElement(By.id("nickname")).sendKeys(n1);
        driver2.findElement(By.id("nickname")).sendKeys(n2);
        //Entramos al juego
        driver1.findElement(By.id("startBtn")).click(); 
        driver2.findElement(By.id("startBtn")).click();
        //Jugamos
        driver1.findElement(By.id("cell-0")).click(); 
        driver2.findElement(By.id("cell-8")).click();        
        driver1.findElement(By.id("cell-1")).click(); 
        driver2.findElement(By.id("cell-7")).click();        
        driver1.findElement(By.id("cell-2")).click(); 
        //Ya ha ganado alguien y extraemos los resultados
        String resultado1 = driver1.switchTo().alert().getText();
        String resultado2 = driver2.switchTo().alert().getText();
        //Cerramos los navegadores
        driver1.quit();
        driver2.quit();
        //Comprobamos que el resultado es correcto
        assertEquals(resultado1,resultadoEsperado1);
        assertEquals(resultado2,resultadoEsperado1);

        
    }
    @Test
    public void testPlayer2Wins() throws Exception { //8 0 7 1 4 2
        //Añadimos los nombres de los jugadores
        driver1.findElement(By.id("nickname")).sendKeys(n1);
        driver2.findElement(By.id("nickname")).sendKeys(n2);
        //Entramos al juego
        driver1.findElement(By.id("startBtn")).click(); 
        driver2.findElement(By.id("startBtn")).click();
        //Jugamos
        driver1.findElement(By.id("cell-8")).click(); 
        driver2.findElement(By.id("cell-0")).click();        
        driver1.findElement(By.id("cell-7")).click(); 
        driver2.findElement(By.id("cell-1")).click();        
        driver1.findElement(By.id("cell-4")).click();
        driver2.findElement(By.id("cell-2")).click();
        //Ya ha ganado alguien y extraemos los resultados
        String resultado1 = driver1.switchTo().alert().getText();
        String resultado2 = driver2.switchTo().alert().getText();
        //Cerramos los navegadores
        driver1.quit();
        driver2.quit();
        //Comprobamos que el resultado es correcto
        assertEquals(resultado1,resultadoEsperado2);
        assertEquals(resultado2,resultadoEsperado2);


    }
    @Test
    public void testCheck() throws Exception { //0 2 1 3 5 4 6 8 7
        //Añadimos los nombres de los jugadores
        driver1.findElement(By.id("nickname")).sendKeys(n1);
        driver2.findElement(By.id("nickname")).sendKeys(n2);
        //Entramos al juego
        driver1.findElement(By.id("startBtn")).click(); 
        driver2.findElement(By.id("startBtn")).click();
        //Jugamos
        driver1.findElement(By.id("cell-0")).click(); 
        driver2.findElement(By.id("cell-2")).click();        
        driver1.findElement(By.id("cell-1")).click(); 
        driver2.findElement(By.id("cell-3")).click();        
        driver1.findElement(By.id("cell-5")).click(); 
        driver2.findElement(By.id("cell-4")).click();
        driver1.findElement(By.id("cell-6")).click(); 
        driver2.findElement(By.id("cell-8")).click();
        driver1.findElement(By.id("cell-7")).click(); 
        //Se han agotado las jugadas y extraemos el mensaje que se muestra
        String resultado1 = driver1.switchTo().alert().getText();
        String resultado2 = driver2.switchTo().alert().getText();
        //Cerramos los navegadores
        driver1.quit();
        driver2.quit();
        //Comprobamos que el resultado es correcto
        assertEquals(resultado1,Draw);
        assertEquals(resultado2,Draw);
        

    }
}
