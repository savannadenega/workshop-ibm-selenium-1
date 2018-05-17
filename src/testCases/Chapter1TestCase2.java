package testCases;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;

// Classe JUnit que cont�m os m�todos de teste.
public class Chapter1TestCase2 {

	// Declarando um objeto do tipo WebDriver, utilizado pelo Selenium
	// WebDriver.
	// private static WebDriver driver;

	private static WebDriver driver;

	// M�todo que inicia tudo que for necess�rio para o teste
	// Cria uma inst�ncia do navegador e abre a p�gina inicial de teste.
	@BeforeClass
	public static void setUpTest() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/browserDrivers/chromedriver.exe");
		// driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.get("http://book.theautomatedtester.co.uk/chapter1");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
	}

	// Clicar no radio button
	@Test
	public void ClicaRadioButtonEsquerda() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(By.id("radiobutton")).click();
	}

	@Test
	public void ComboBoxEsquerda() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(By.id("selecttype")).click();
		driver.findElement(By.id("selecttype")).sendKeys("exemplo");
		driver.findElement(By.id("selecttype")).sendKeys(Keys.RETURN);
		System.out.println("rodou o teste do combo ");
	}

	@Test
	public void buttonLoadRedBox() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(By.id("loadajax")).click();
		Thread.sleep(5000);
		String text = driver.findElement(By.id("ajaxdiv")).getText();
		System.out.println("texto do Red box: " +text.toString());
		Assert.assertFalse(text.isEmpty());
	}

	@AfterClass
	public static void tearDownTest() {
		driver.quit();
	}
}
