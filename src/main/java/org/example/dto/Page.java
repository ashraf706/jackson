package org.example.dto;

public class Page {
    private final  PageInfo pageInfo;
    private final Post post;

    public Page(PageInfo pageInfo, Post post) {
        this.pageInfo = pageInfo;
        this.post = post;
    }
}
