package common;

import org.openqa.selenium.WebElement;

public class SeleniumUtils {
	public static void printElementsInfo(String name, WebElement element) {
		String separator = "-------------------------------------";
		System.out.println(separator);
		System.out.println("Informacion del elemento: "+ name);
		System.out.println(separator); 
		System.out.println("Objeto WebElement: " + element);
		//System.out.println("HTML Externo: "+ element.getAttribute("outerHTML"));
		//System.out.println("HTML Interno: "+ element.getAttribute("innerHTML"));
		System.out.println("Texto: "+ element.getText()); //texto estático por defecto
		System.out.println("Value: "+ element.getAttribute("value")); //puede ser dinámico. Example: input
		System.out.println("tag: "+ element.getTagName());
		System.out.println("Displayed?: "+ element.isDisplayed());
		System.out.println("Selected?: "+ element.isSelected());
		System.out.println("Enabled?: "+ element.isEnabled());
		System.out.println(separator);	
	}
}
