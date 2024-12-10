package tst.example.ws;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import tst.example.ws.model.Category;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CategoryTest {

    @Test
    public void getCategoryReturns() {
        given().log().all().cookie("user_id", "test")
                .get("/category")
                .then().log().all().statusCode(200).body("id",  hasItems("1","2","3")).and().cookie("user_id", "test");
    }

    @Test
    public void getCategoryThatDoesNotExist() {
                given().cookie("user_id", "test").when().get("/category/zzz")
                .then().statusCode(404)
                        .assertThat().body(equalTo("Category zzz not found"));
    }

    @Test
    public void postNewCategory() {
        Category category = Category.builder().id("123new").category("Category123New").points(List.of("Point1")).build();
        given().contentType(ContentType.JSON)
                .body(category)
                .cookie("user_id", "UserName")
                .when().post("/category")
                .then().statusCode(201).assertThat().body("id", equalTo("123new")).and()
                .body("category", equalTo("Category123New"))
                .assertThat().cookie("user_id", equalTo("UserName"));
    }
}
