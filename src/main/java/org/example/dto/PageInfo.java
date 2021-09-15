package org.example.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PageInfo {
    @NotNull
    @Size(min = 2, max = 14)
    private String name;

    private String pic;

    @JsonCreator
    public PageInfo(
            @JsonProperty("pageName") String pageName,
            @JsonProperty("pagePic") String pagePic
    ) {
        this.name = pageName;
        this.pic = pagePic;
    }


    public String getName() {
        return name;
    }

    public String getPic() {
        return pic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
