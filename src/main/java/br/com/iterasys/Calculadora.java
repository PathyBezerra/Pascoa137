//1- Pacote: conjunto de classes
package br.com.iterasys;

//2- Bibliotecas


//3- Classe

public class Calculadora {// inicio da classe

    public static double somarDoisNumeros(double num1, double num2) { //inicio da função
        return num1 + num2;
    }//fim da função somar

    public static double subtrairDoisNumeros(double num1, double num2){// inicio da função subtrair
        return num1 - num2;
    } // final da função subtrair

    public static double multiplicarDoisNumeros(double num1, double num2){ // inicio da função multiplicar
        return num1 * num2;

    } // final da função multiplicar

    public static String dividirDoisNumerosInteiros(int numA, int numB){
        try{
        return String.valueOf(numA/ numB);}
        catch(Exception e){
            return "Não é possivel dividir por zero";
            }
    }

    public static double dividirDoisNumeros(double num1, double num2){ // inicio da função dividir
        return num1 / num2;

    } // final da função dividir

} //final da classe
