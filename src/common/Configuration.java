package common;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Configuration {
	public static String ROOT_DIR = System.getProperty("user.dir")+ File.separator;
	public static String SCREENSHOT_DIR = ROOT_DIR + "screenshots" +File.separator;
	public static String FILES_DIR = ROOT_DIR + "files" +File.separator;
	public static String DRIVERS_DIR = ROOT_DIR + "drivers" +File.separator;
	public static String CHROME_DRIVER = DRIVERS_DIR + "chromedriver";
	public static String GECKO_DRIVER = DRIVERS_DIR + "geckodriver";
	public static String EDGE_DRIVER = DRIVERS_DIR + "msedgedriver";
	
	public static String URL = "http://www.google.cl";
	
	public static String USER = "pruebaautomatizadaqa123@gmail.com";
	public static String PASSL = "prueba123automatizada";
	
	
	public static WebDriver createChromeDriver() {
		System.setProperty("webdriver.chrome.driver", modifyInWindows(CHROME_DRIVER));
		return new ChromeDriver();
	}
	
	public static WebDriver createFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver", modifyInWindows(GECKO_DRIVER));
		return new FirefoxDriver();
	}
	
	public static WebDriver createEdgeDriver() {
		System.setProperty("webdriver.edge.driver", modifyInWindows(EDGE_DRIVER));
		return new EdgeDriver();
	}
	
	public static WebDriver createFireFoxDriverHeadless() {
		System.setProperty("webdriver.gecko.driver", modifyInWindows(GECKO_DRIVER));
		FirefoxOptions options  = new FirefoxOptions();
		options.setHeadless(true);
		return new FirefoxDriver(options);
	}
	
	//Portabilidad para ejecutar de forma automatica en cualquier OS (encapsulado)
	public static String modifyInWindows(String inPath) { 
		if(System.getProperty("os.name").toLowerCase().contains("windows")) {
			return inPath + ".exe";
		}else {
			return inPath;
		}
	}
}
