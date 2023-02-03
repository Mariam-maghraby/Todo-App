package com.mariam.backend.springboot.todo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TodoServices {

    private List<Todo> data = new ArrayList<Todo>(Arrays.asList(

            new Todo(0, "todo item-0", "bla bla bla bla bla bla bla bla"),
            new Todo(1, "todo item-1", "bla bla bla bla bla bla bla bla"),
            new Todo(2, "todo item-2", "bla bla bla bla bla bla bla bla"),
            new Todo(3, "todo item-3", "bla bla bla bla bla bla bla bla"),
            new Todo(4, "todo item-4", "bla bla bla bla bla bla bla bla"))
    );

    public Todo getTodoWithID(int id) {
        for (Todo todo: data){
            if(todo.getId() == id){
                return todo;
            }
        }
        return null;
    }

    public List<Todo> findAll() {
        return data;
    }

    public int size() {
        return data.size();
    }

    public Todo get(int itemNumber) {
        return data.get(itemNumber);
    }

    public Boolean save(Todo todo){
        return data.add(todo);
    }

    public void deleteTodo(int id) {
        for (Todo deletedTodo:data){
            if(deletedTodo.getId() == id){
                data.remove(deletedTodo);
            }
        }
    }

    public void editTitle(int id, String newTitle) {
        for (Todo todo:data){
            if(todo.getId() == id){
                todo.setTitle(newTitle);
            }
        }
    }

    public void editDescription(int id, String newDescription) {
        for (Todo todo:data){
            if(todo.getId() == id){
                todo.setDescription(newDescription);
            }
        }
    }
}
