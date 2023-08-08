package com.jdjm.mybatis.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Story {
    private Integer id;
    private Integer userId;
    private String name;
    private String title;
    private String story;
    private Integer isDeleted;
    private String createAt;
    private String updateAt;
    private Integer tag;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

//    public String getXyz() {
//        return name;
//    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getStory() {
        return story;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public String getCreateAt() {
        return createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public Integer getTag() {
        return tag;
    }
}
