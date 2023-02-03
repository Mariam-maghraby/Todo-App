package com.mariam.backend.springboot.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TodoServices {

    @Autowired
    private TodoRepository todoRepository;

    public Todo getTodoWithID(String id) {
      return todoRepository.findById(id).get();
    }

    /**
     * Get all todos
     * @return List<Todo>
     */
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }



    public Todo get(int itemNumber) {
        return todoRepository.findAll().get(itemNumber);
    }

    public Todo save(Todo todo){
        return todoRepository.insert(todo);
    }

    public void deleteTodo(String id) {
        todoRepository.deleteById(id);
    }

//    public void editTitle(String id, String newTitle) {
//        for (Todo todo:data){
//            if(todo.getId() == id){
//                todo.setTitle(newTitle);
//             }
//        }
//    }
//
//    public void editDescription(String id, String newDescription) {
//        for (Todo todo:data){
//            if(todo.getId() == id){
//                todo.setDescription(newDescription);
//            }
//        }
//    }
}
