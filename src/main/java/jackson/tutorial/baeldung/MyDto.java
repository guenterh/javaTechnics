package jackson.tutorial.baeldung;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by swissbib on 07.07.15.
 */
@JsonIgnoreProperties(value = { "intValue" })
public class MyDto {

    private String stringValue;
    private int intValue;
    private boolean booleanValue;

    public MyDto() {
        super();
        this.stringValue = "hier der zu serialierende string value";
    }

    // standard setters and getters are not shown
}