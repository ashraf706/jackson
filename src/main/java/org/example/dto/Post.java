package org.example.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Post {
    private final String postId;
    private final String actorId;
    private final String picOfPersonWhoPosted;
    private final String nameOfPersonWhoPosted;
    private final String message;
    private final int likesCount;
    private final List<String> comments;
    private final String timeOfPost;

    @JsonCreator
    public Post(
            @JsonProperty("post_id") String postId,
            @JsonProperty("actor_id") String actorId,
            @JsonProperty("picOfPersonWhoPosted") String picOfPersonWhoPosted,
            @JsonProperty("nameOfPersonWhoPosted") String nameOfPersonWhoPosted,
            @JsonProperty("message") String message,
            @JsonProperty("likesCount") int likesCount,
            @JsonProperty("comments") List<String> comments,
            @JsonProperty("timeOfPost") String timeOfPost) {
        this.postId = postId;
        this.actorId = actorId;
        this.picOfPersonWhoPosted = picOfPersonWhoPosted;
        this.nameOfPersonWhoPosted = nameOfPersonWhoPosted;
        this.message = message;
        this.likesCount = likesCount;
        this.comments = comments;
        this.timeOfPost = timeOfPost;
    }
}
