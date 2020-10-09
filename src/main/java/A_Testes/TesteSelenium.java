package A_Testes;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteSelenium {

	@Test
	public void teste() {

		// setar as configurações do gecko (firefox)
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Ana\\Desktop\\GECKO_DRIVER\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		// maximiza a tela do firefox
		driver.manage().window().maximize();

		// abre o submarino
		driver.get("https://www.submarino.com.br/");

		//pequisa por livros
		driver.findElement(By.id("h_search-input")).sendKeys("Livros");

		//clica no botao pesquisar
		driver.findElement(By.id("h_search-btn")).click();
		
		//clica no livro
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div[1]/div/div[2]/div[6]/div/div/div/div[1]/div[1]/div/div[2]/a/section/div[1]/div/div/picture/img")).click();
		
		//pega o nome do autor e atribui a auma variavel
		String autorPesquisa1 = driver.findElement(By.cssSelector(".author-name__AuthorLink-sc-19niywj-0 > span:nth-child(1)")).getAttribute("innerHTML");
		System.out.println("O nome do autor é: " + autorPesquisa1);
		
		//pega o ISBN
		String isbn = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[8]/div[2]/section/div[2]/section/table/tbody/tr[3]/td[2]/span")).getAttribute("innerHTML");
		System.out.println("O isbn é: " + isbn);
		
		//abre americanas
		driver.get("https://www.americanas.com.br/");
		
		//pequisa por livros na americanas
		driver.findElement(By.id("h_search-input")).sendKeys(isbn);
		
		//clica no botao pesquisar americanas 
		driver.findElement(By.id("h_search-btn")).click();
		
		//abre o link do livro na americanas
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div[1]/div/div[2]/div[6]/div/div/div/div[1]/div/div/div[2]/a/section/div[1]/div/div/picture/img")).click();
		
		//pega o nome do autor e atribui a auma variavel
		String autorPesquisa2 = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[6]/div[2]/section/div/div[3]/table/tbody/tr[5]/td[2]/span")).getAttribute("innerHTML");
		System.out.println("O nome do autor 2 é: " + autorPesquisa2);
		
		if(autorPesquisa1 != autorPesquisa2) {
			System.out.println("Autores diferentes");
			return;
		}else {
			System.out.println("Autores iguais");
		}

		 //Fecha o driver
		driver.close();

		 //fecha todas as instancias do gecko
		driver.quit();

	}

}
