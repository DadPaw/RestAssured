package apiTest;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class TestsOnLocalJSONServer {

    @Test
    public void get1(){

        baseURI = "http://localhost:3000";

        given()
                .get("/users")
                .then()
                .statusCode(200)
                .log().all();

    }

    @Test
    public void post1(){
        JSONObject request = new JSONObject();
        request.put("firstname","Michal");
        request.put("lastName","Oko");
        request.put("subjectId",1);


        baseURI = "http://localhost:3000";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .post("/users")
                .then()
                .statusCode(201)
                .log().all();

    }

    @Test
    public void put1(){
        JSONObject request = new JSONObject();
        request.put("firstname","Adrian");
        request.put("lastName","Chop");
        request.put("subjectId",2);


        baseURI = "http://localhost:3000";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .put("/users/3")
                .then()
                .statusCode(201)
                .log().all();

    }

    @Test
    public void delete1(){


        baseURI = "http://localhost:3000";

        given()
                .when()
                .delete("/users/5")
                .then()
                .statusCode(200)
                .log().all();
    }

}
