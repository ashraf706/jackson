package org.example;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.*;
import junit.framework.*;
import org.example.dto.*;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class JsonLoaderTest {

    @Test
    public void loadPageInfo() {
        ObjectMapper mapper = new ObjectMapper();
        PageInfo pageInfo = null;

        try {
            pageInfo = mapper.readValue(this.getClass().getClassLoader().getResource("pageInfo.json"), PageInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
        };

        assertNotNull(pageInfo);
    }

    @Test
    public void loadPost() {
        ObjectMapper mapper = new ObjectMapper();
        Post post = null;

        try {
            post = mapper.readValue(this.getClass().getClassLoader().getResource("post.json"), Post.class);
        } catch (IOException e) {
            e.printStackTrace();
        };

        assertNotNull(post);
    }

    @Test
    public void loadJsonFile() {
        ObjectMapper mapper = new ObjectMapper();
        Page page = null;

        try {
            page = mapper.readValue(this.getClass().getClassLoader().getResource("sample.json"), Page.class);
        } catch (IOException e) {
            e.printStackTrace();
        };

        assertNotNull(page);
    }

    @Test
    public void fileFromResourceFolder() {
        URL sampleFile = this.getClass().getClassLoader().getResource("sample.json");
        assertNotNull(sampleFile);
    }


    @Test
    public void dateTest() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        URL resource = this.getClass().getClassLoader().getResource("itinerary.json");
        Itinerary itinerary = null;
        try {
            itinerary = mapper.readValue(resource, Itinerary.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertNotNull(itinerary);

        LocalDate date = LocalDate.of(2019, 10, 21);
        assertEquals(date, itinerary.getJourneyDate());
    }
}
