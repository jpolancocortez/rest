/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.test;


import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/**
 *
 * @author jpolanco
 */
public class TestHero {
    
    @Test
    public void testHeroes() {        
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "web/rs";
        
        when().
            get("/heroes").
        then().
            body("id",hasItems("Windstorm","Flash"));
    }

}