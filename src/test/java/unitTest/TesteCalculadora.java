package unitTest;//Bibliotecas

import br.com.iterasys.Calculadora;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Classe
public class TesteCalculadora {
    //Atributos

    //Funções e Metódos



    @Test
    public void testeSomarDoisNumeros(){ // inicio do teste do somar
        //Configura
        // Valores de entrada
        double num1 = 7;
        double num2 = 5;
        // Valores de saida
        double resultadoEsperado = 12;

        //Executa
        double resultadoAtual = Calculadora.somarDoisNumeros(num1, num2);

        //Valida
        assertEquals(resultadoAtual, resultadoEsperado);
    } // final do teste do somar

      // Este é um teste de unidade data drive- direcionando para todos

    @ParameterizedTest
    @CsvSource(value = {
            "7, 5, 12.0",
            "56, 44, 100.0",
            "10, 0, 10.0",
            "15, -5, 10.0",
            "-8, -6, -14.0"
    }, delimiter = ',')
    public void testeSomarDoisNumerosLendoLista(String txtNum1, String txtNum2, String resultadoEsperado ){ // inicio do teste do somar
        //Configura
        // OS dados de entrada e o resultado esperado vem da lista
        //Executa
        double resultadoAtual = Calculadora.somarDoisNumeros(Integer.valueOf(txtNum1), Integer.valueOf(txtNum2));

        //Valida
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
    } // final do teste do somar

    @ParameterizedTest
    @CsvFileSource(resources = "src/test/resources/csv/massaSomar.csv")
    public void testeSomarDoisNumerosLendoArquivo(String txtNum1, String txtNum2, String resultadoEsperado ){ // inicio do teste do somar
        //Configura
        // OS dados de entrada e o resultado esperado vem da lista
        //Executa
        double resultadoAtual = Calculadora.somarDoisNumeros(Integer.valueOf(txtNum1), Integer.valueOf(txtNum2));

        //Valida
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
    } // final do teste do somar

    public void testedividirDoisNumeros(){ // inicio do teste do dividir
        //Configura
        // Valores de entrada
        double num1 = 7;
        double num2 = 5;
        // Valores de saida
        double resultadoEsperado = 12;

        //Executa
        double resultadoAtual = Calculadora.dividirDoisNumeros(num1, num2);

        //Valida
        assertEquals(resultadoAtual, resultadoEsperado);
    } // final do teste dividir

    public void testemultiplicarDoisNumeros(){ // inicio do teste do multiplicar
        //Configura
        // Valores de entrada
        double num1 = 7;
        double num2 = 5;
        // Valores de saida
        double resultadoEsperado = 12;

        //Executa
        double resultadoAtual = Calculadora.multiplicarDoisNumeros(num1, num2);

        //Valida
        assertEquals(resultadoAtual, resultadoEsperado);
    } // final do teste multiplicar

    public void testesubtrairDoisNumeros(){ // inicio do teste do subtrair
        //Configura
        // Valores de entrada
        double num1 = 7;
        double num2 = 5;
        // Valores de saida
        double resultadoEsperado = 12;

        //Executa
        double resultadoAtual = Calculadora.subtrairDoisNumeros(num1, num2);

        //Valida
        assertEquals(resultadoAtual, resultadoEsperado);
    } // final do teste subtrair

    @Test
     public void testeDividirDoisNumerosInteiros() { // inicio do teste dividir inteiro
     // Configura
        int numA = 8;
        int numB = 0;
        String resultadoEsperado = "Não é possivel dividir por zero";

     // Executa
        String resultadoAtual = Calculadora.dividirDoisNumerosInteiros(numA, numB);

     // Valida
        assertEquals(resultadoEsperado, resultadoAtual);
        System.out.println(numA + " / " + numB + " = " + resultadoAtual);
        System.out.println(" O resultado esperado: " + resultadoEsperado);
    } // fim do teste dividir inteiro


} // final da classe
