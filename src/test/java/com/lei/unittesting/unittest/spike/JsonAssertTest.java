package com.lei.unittesting.unittest.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
    String acturalResponse="{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
    @Test
    public void jsonAssert() throws JSONException {
        String expectedResponse="{\"id\": 1, \"name\": \"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, acturalResponse, true);
    }
}
