package common;

import java.io.File;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.Configuration;

public class BaseClass {
	private WebDriver driver = null;
	private WebDriverWait wait = null;
	
	protected WebDriver getDriver() { //protegido, solo las clases que heredan pueden utilizarlo
		return this.driver;
	}
	
	protected WebDriverWait getWait() { //protegido, solo las clases que heredan pueden utilizarlo
		return this.wait;
	}
	
	/*
	 * Clase test Auxiliares  @BeforeAll, @BeforeEach, @AfterAll, @AfterEach
	 */
	
	@BeforeEach
	public void start(){
		//Crear Driver y Espera explícita
		driver = Configuration.createChromeDriver(); //instanciar el driver y el wait(explicito)
		wait = new WebDriverWait(driver, 60); //max 60 segundos
		
		// Agregar comportamiento común @BeforeEach ó @BeforeAll (Sólo si es necesario).
		
		/*
		driver.get(Configuration1.URL_PI);
		driver.manage().window().maximize();
		 */
	}
	
	@AfterEach
	public void finish() throws Exception{
		
		// Agregar comportamiento común @AfterEach ó @AfterAll (Sólo si es necesario).
		
		// Cerrar Blowser
		driver.quit(); 
	}
	
		
	/*
	 * FUNCIONES !
	 */
	
	/*
	 * takeScreenShotTest es una clase que permite guardar evidencias de imágenes en un repositorio local.
	 */
	public static void takeScreenShotTest(WebDriver driver, String imageName) {
		TakesScreenshot captura = (TakesScreenshot) driver; //castear de un WebDriver a TakesScreenshot
		File archivoCaptura = captura.getScreenshotAs(OutputType.FILE);
		String path = String.format("%s%s-%s-%s.png", Configuration.SCREENSHOT_DIR, "Captura",imageName,System.currentTimeMillis());
		archivoCaptura.renameTo(new File(path));
	}
}
