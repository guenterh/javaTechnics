package jackson.tutorial.baeldung;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertNotNull;

/**
 * Created by swissbib on 07.07.15.
 */

public class MyDtoTests {

    @Test
    public void givenFieldIsIgnoredByName_whenDtoIsSerialized_thenCorrect()
            throws JsonParseException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        MyDto dtoObject = new MyDto();


        String dtoAsString = mapper.writeValueAsString(dtoObject);


        assertThat(dtoAsString, not(containsString("intValue")));
    }


    //http://www.baeldung.com/jackson-json-to-jsonnode
    @Test
    public void whenParsingJsonStringIntoJsonNode_thenCorrect()
            throws JsonParseException, IOException {
        String jsonString = "{\"k1\":\"v1\",\"k2\":\"v2\"}";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(jsonString);

        assertNotNull(actualObj);
    }

    @Test
    public void givenUsingLowLevelApi_whenParsingJsonStringIntoJsonNode_thenCorrect()
            throws JsonParseException, IOException {
        String jsonString = "{\"k1\":\"v1\",\"k2\":\"v2\"}";

        ObjectMapper mapper = new ObjectMapper();
        JsonFactory factory = mapper.getFactory();
        JsonParser parser = factory.createParser(jsonString);
        JsonNode actualObj = mapper.readTree(parser);

        assertNotNull(actualObj);
    }

    @Test
    public void givenTheJsonNode_whenRetrievingDataFromId_thenCorrect()
            throws JsonParseException, IOException {

        //String jsonString = "{\"k1\": { \"sub\" : \"v1\"},\"k2\":\"v2\"}";
        String jsonString = "{\"k1\":  \"v1\",\"k2\":\"v2\"}";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(jsonString);

        // When
        JsonNode jsonNode1 = actualObj.get("k1");
        assertThat(jsonNode1.textValue(), equalTo("v1"));
        String test = actualObj.asText();
        String test1 = actualObj.toString();
        System.out.println("sieht man was");
        org.junit.Assert.assertEquals("not equal", 4,5);
    }


}
