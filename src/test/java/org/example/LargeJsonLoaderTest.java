package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.map.ObjectMapper;
import org.example.dto.PageInfo;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static junit.framework.TestCase.assertNotNull;

public class LargeJsonLoaderTest {

    @Test
    public void createLargeJson() {
        JsonFactory factory = new JsonFactory();
        String homeDirectory = System.getProperty("user.home");
        File file = new File(homeDirectory + "/personal/tmp/largeFile.json");

        JsonGenerator generator = null;
        ObjectMapper mapper = new ObjectMapper();
        PageInfo pageInfo = new PageInfo("aa", "bb");
        //JsonNode node = mapper.valueToTree(pageInfo);
        try {
            Files.deleteIfExists(file.toPath());
            generator = factory.createJsonGenerator(file, JsonEncoding.UTF8);
            generator.setCodec(mapper);
            generator.writeObjectFieldStart("something");
            for (int i = 1; i <= 5; i++) {

                generator.writeObject(pageInfo);
            }
            generator.writeEndObject();
            generator.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertNotNull(generator);

    }
}
