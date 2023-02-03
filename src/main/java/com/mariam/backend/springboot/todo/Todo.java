package com.mariam.backend.springboot.todo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "Todos") //overrides the name of type of data as todos not todo
public class Todo {
    @Id
    private String id;

    private String title;
    private String description;
    private Long timeStamp;

    public Todo() {
        this.timeStamp = System.currentTimeMillis();
    }

    public Todo(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.timeStamp = System.currentTimeMillis();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
