package webTest.EveClass.Aluno;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestAjuda extends TestLoginAluno {

    @Order(1)
    @Test
    public void testAjuda() throws InterruptedException {
        logarAluno();
        driver.get("https://testando.eveclass.com/pt");
        botaoComecarAgoraClick();
        Thread.sleep(2000); // espera por 3 segundos

        driver.findElement(By.cssSelector("a.nav-item[text='Ajuda']")).click();
        Thread.sleep(2000); // espera por 3 segundos
        assertThat(driver.findElement(By.className("header-text")).getText(), containsString("Perguntas Frequentes"));
    }
}