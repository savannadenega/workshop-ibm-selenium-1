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

public class Chapter1TestCase2 {

	// Declarando um objeto do tipo WebDriver, utilizado pelo Selenium
	// WebDriver.
	private static WebDriver driver;

	// Método que inicia tudo que for necessário para o teste
	// Cria uma instância do navegador e abre a página inicial de teste.
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
	public void clicaRadioButtonEsquerda() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(By.id("radiobutton")).click();
	}

	@Test
	public void comboBoxEsquerda() throws InterruptedException {
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
