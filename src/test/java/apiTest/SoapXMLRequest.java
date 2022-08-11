package apiTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SoapXMLRequest {

    @Test
    public void validateSoapXML() throws IOException {

        File file = new File("src/SoapFiles/add.xml");

        FileInputStream fileInputStream = new FileInputStream(file);

        String requestBody = IOUtils.toString(fileInputStream, "UTF-8");


        RestAssured.baseURI="http://www.dneonline.com";

        RestAssured.given()
                .contentType("text/xml")
                .accept(ContentType.XML)
                .body(requestBody)
                .when()
                .post("/calculator.asmx")
                .then()
                .statusCode(200)
                .log().all();



    }
}
