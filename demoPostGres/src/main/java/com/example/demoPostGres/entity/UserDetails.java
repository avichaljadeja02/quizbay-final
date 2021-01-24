package com.example.demoPostGres.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.List;

@Document(collection = "UserDetails")
public class UserDetails{
    @Id
    private String id;
    private String userName;
    private List<Integer> listQuizIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Integer> getListQuizIds() {
        return listQuizIds;
    }

    public void setListQuizIds(List<Integer> listQuizIds) {
        this.listQuizIds = listQuizIds;
    }
}