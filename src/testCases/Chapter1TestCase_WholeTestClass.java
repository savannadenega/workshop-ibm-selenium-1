package testCases;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * 
 * Esta classe n�o cont�m as depend�ncias da classe utils, esta apenas tem o ojetivo de mostrar 
 * como a estrutura geral do uso do Selenium funciona.
 *
 */
public class Chapter1TestCase_WholeTestClass {
	
	// Declarando um objeto do tipo WebDriver, utilizado pelo Selenium
	// WebDriver.
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

	@Test
	public void clickRadioButtonEsquerda() throws InterruptedException {
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
