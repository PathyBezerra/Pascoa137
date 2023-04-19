package webTest.EveClass.Aluno;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestLoginAluno  extends TestBase {

    public void logarAluno() throws InterruptedException {
        // Iniciando Teste acessando o site Testando Eveclass
        driver.get("https://testando.eveclass.com/pt");

        botaoComecarAgoraClick();

        // Aciona o botão "Entrar"
        driver.findElement(By.cssSelector("#support-action > span > span > span")).click();
        Thread.sleep(2000); // espera por 3 segundos

        // Seleciona o Input "Email" e inseri os valores
        WebElement inputEmail = driver.findElement(By.cssSelector("input[data-vv-as='Email'][type='Email']"));
        inputEmail.sendKeys("patriciabezerra1990+alunopatricia@gmail.com");

        // Seleciona o Input "password" e inseri os valores
        WebElement inputSenha = driver.findElement(By.cssSelector("input[type='password']"));
        inputSenha.sendKeys("Senha123");

        // Clica no botão entrar
        driver.findElement(By.cssSelector("button.button-default")).click();

        Thread.sleep(3000); // espera por 3 segundos
    }
}
