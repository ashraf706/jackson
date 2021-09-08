package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.Page;
import org.example.dto.PageInfo;
import org.example.dto.Post;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

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
}
