package org.example.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public class PageInfo {
    private final String pageName;
    private final String pagePic;

    @JsonCreator
    public PageInfo(String pageName, String pagePic) {
        this.pageName = pageName;
        this.pagePic = pagePic;
    }
}
