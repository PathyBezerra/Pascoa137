// nome do pacote
package apiTest;

// Bibliotecas
import gherkin.deps.com.google.gson.Gson;
import io.restassured.response.Response;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


//Classe
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TesteUser { // inicio da classe
    // Atributos
    static String ct = "application/json"; // contet type

    static String uriUser = "https://petstore.swagger.io/v2/user/";

    // Funções e Métodos
    // Funções de Apoio
    public static String lerArquivoJson(String arquivoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(arquivoJson)));
    }

    //Funçoes de Testes
    @Test
    @Order(1)
    public void testarIncluirUser() throws IOException {
        // carregar os dados do nosso Json
        String jsonBody = lerArquivoJson("src/test/resources/json/user1.json");

        String userId = "1372065";

       //realizar o teste
        given()                                         //Dado que
                .contentType(ct)     //o tipo do conteudo
                .log().all()                            //mostre tudo
                .body(jsonBody)                         //corpo da requisição
        .when()
                .post(uriUser) // Endpoint / Onde
        .then()
                .log().all()                            // mostre tudo na volta
                .statusCode(200)                      // comunic. ida e volta ok
                .body("code", is(200))          // tag code é 200
                .body("type", is("unknown"))     // tag type é "unknown"
                .body("message", is(userId))                // message é o userId
        ;
    } //fim do post
    @Test
    @Order(2)
    public void testarConsultarUser(){
        String username = "poms";

        // Resultado esperado
        int userId = 1372065;
        String email = "pathyh.sb@gmail.com";
        String senha = "1234";
        String telefone = "996543560";


        given()
                .contentType(ct)
                .log().all()
        .when()
                .get(uriUser + username)
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(userId))
                .body("email", is(email))
                .body("password", is(senha))
                .body("phone", is(telefone))
        ;

    } //fim do get User

    @Test
    @Order(3)
    public void testarAlterarUser() throws IOException {
        String jsonBody = lerArquivoJson("src/test/resources/json/user2.json");

        String userId = "1372065";
        String username = "poms";


        given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .put(uriUser + username)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(userId))
                ;

    } // fim do Put User
    @Test
    @Order(4)
    public void testerExcluirUser(){ // inicio do Delete User
        String username = "poms";

        given()
                .contentType(ct)
                .log().all()
        .when()
                .delete(uriUser + username)
        .then()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(username))
                ;


    } //fim do Deleter User
    @Test
    @Order(5)
    public void testarLogin(){
        String username = "Poms";
        String password = "1234";

        Response response = (Response) given()
                .contentType(ct)
                .log().all()
        .when()
                .get(uriUser + "login?username=" + username+"&password=" + password)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("message", containsString("logged in user session:"))
                .body("message", hasLength(36))
        .extract()
                ;

        // Extração do Token da resposta
        String token = response.jsonPath().getString("message").substring(23);
        System.out.println("Conteúdo do Token:" + token);


    } // fim do login

   @ParameterizedTest @Order(6)
   @CsvFileSource(resources = "/csv/massaUser.csv", numLinesToSkip = 1, delimiter = ',')
   public void testarIncluirUserCSV(
           String id,
           String username,
           String firstName,
           String lastName,
           String email,
           String password,
           String phone,
           String userStatus)
   {  //Inicio incluir CSV


       User user = new User();

       user.id = id;
       user.username = username;
       user.firstName = firstName;
       user.lastName = lastName;
       user.email = email;
       user.password = password;
       user.phone = phone;
       user.userStatus = userStatus;

       Gson gson = new Gson();
       String jsonBody = gson.toJson(user);

       //realizar o teste
       given()                                         //Dado que
               .contentType(ct)     //o tipo do conteudo
               .log().all()                            //mostre tudo
               .body(jsonBody)                         //corpo da requisição
               .when()
               .post(uriUser) // Endpoint / Onde
               .then()
               .log().all()                            // mostre tudo na volta
               .statusCode(200)                      // comunic. ida e volta ok
               .body("code", is(200))          // tag code é 200
               .body("type", is("unknown"))     // tag type é "unknown"
               .body("message", is(id))                // message é o userId
       ;

       } //fim  incluir CSV



} //final da classe



