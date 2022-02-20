package info.maxdev.cgm.patient;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PatientResourceTest {

    @Test
    public void testPatientEndpoint() {
        //TODO more test
        given()
          .when().get("/api/v1/patients")
          .then()
             .statusCode(200);
    }

}