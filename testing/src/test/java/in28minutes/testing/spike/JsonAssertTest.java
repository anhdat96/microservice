package in28minutes.testing.spike;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

@WebMvcTest
@RunWith(SpringRunner.class)
public class JsonAssertTest {

    String actualResponse  = "{\n" +
            "  \"id\": 1,\n" +
            "  \"name\": \"ball\",\n" +
            "  \"price\": 10.0,\n" +
            "  \"quantity\": 100\n" +
            "}";

    @Test
    public void jsonAssert() throws JSONException {

        String expectedResult = " {\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"ball\",\n" +
                "  \"price\": 10.0,\n" +
                "  \"quantity\": 100\n" +
                "}";

        JSONAssert.assertEquals(expectedResult,actualResponse,true);
        // strict true mean that : content of expectedResult have to similar with actualResponse
    }

    @Test
    public void jsonAssert_WithoutEscapeCharacter() throws JSONException {
        String expectedResult = " { id: 1,name: ball,price: 10.0,quantity: 100 }";
        JSONAssert.assertEquals(expectedResult,actualResponse,true);
    }
}

