package apiTest;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class TesteStore {

    // Atributos
    static String ct = "application/json"; // contet type

    static String uriPet = "https://petstore.swagger.io/v2/pet/";
    static String uriStoreOrder = "https://petstore.swagger.io/v2/store/order/";

    public static String lerArquivoJson(String arquivoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(arquivoJson)));
    }
    @Test
    @Order(1)
    public void testarIncluirPet() throws IOException {
        // carregar os dados do nosso Json
        String jsonBody = lerArquivoJson("src/test/resources/json/pet.json");

        Integer petId = 460;

        //realizar o teste
        given()                                         //Dado que
                .contentType(ct)     //o tipo do conteudo
                .log().all()                            //mostre tudo
                .body(jsonBody)                         //corpo da requisição
                .when()
                .post(uriPet) // Endpoint / Onde
                .then()
                .log().all()                            // mostre tudo na volta
                .statusCode(200)                      // comunic. ida e volta ok
                .body("status", is("available"))          // tag code é 200
                .body("id", is(petId))                // message é o petId
        ;
    } //fim do post
    @Test
    @Order(2)
    public void testarIncluirStoreOrder() throws IOException {
        // carregar os dados do nosso Json
        String jsonBody = lerArquivoJson("src/test/resources/json/storeorder.json");

        Integer storeOrderId = 469;

        //realizar o teste
        given()                                         //Dado que
                .contentType(ct)     //o tipo do conteudo
                .log().all()                            //mostre tudo
                .body(jsonBody)                         //corpo da requisição
                .when()
                .post(uriStoreOrder) // Endpoint / Onde
                .then()
                .log().all()                            // mostre tudo na volta
                .statusCode(200)                      // comunic. ida e volta ok
                .body("status", is("placed"))          // tag code é 200
                .body("complete", is(true))          // tag code é 200
                .body("id", is(storeOrderId))                // message é o petId
        ;
    } //fim do post

    @Test
    @Order(3)
    public void testerExcluirStoreOrder(){ // inicio do Delete User
        String storeOrderId = "469";

        given()
                .contentType(ct)
                .log().all()
                .when()
                .delete(uriStoreOrder + storeOrderId)
                .then()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(storeOrderId))
        ;


    } //fim do Deleter User
}
