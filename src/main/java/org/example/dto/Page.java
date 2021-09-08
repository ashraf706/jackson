package org.example.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Page {
    private final  PageInfo pageInfo;
    private final List<Post> post;

    @JsonCreator
    public Page(@JsonProperty("pageInfo") PageInfo pageInfo, @JsonProperty("posts") List<Post> post) {
        this.pageInfo = pageInfo;
        this.post = post;
    }
}
