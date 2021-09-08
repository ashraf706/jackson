package org.example.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PageInfo {
    private final String name;
    private final String pic;

    @JsonCreator
    public PageInfo(
            @JsonProperty("pageName") String pageName,
            @JsonProperty("pagePic") String pagePic
    ) {
        this.name = pageName;
        this.pic = pagePic;
    }
}
