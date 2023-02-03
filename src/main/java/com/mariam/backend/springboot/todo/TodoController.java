package com.mariam.backend.springboot.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/todos")
public class TodoController {

    @Autowired
    private TodoServices todoServices;

    @GetMapping(value = {"","/"}) //both are valid
    public List<Todo> listTodos(){
        return todoServices.findAll();
    }

    @GetMapping(value = {"todo-{itemNumber}","todo-{itemNumber}/" })
    public Todo todoItem(@PathVariable int itemNumber){
        Todo dataItem;
        if(itemNumber<todoServices.size()) {
            dataItem = todoServices.get(itemNumber);
        }
        else {
            dataItem = null;
        }
        return dataItem;
    }

    @GetMapping(value = {"todo/id/{ID}", "todo/id/{ID}/"})
    public Todo getTodoById(@PathVariable int ID){
        return todoServices.getTodoWithID(ID);
    }

    @PostMapping(value = {"","/"})
    public Todo createNewTodo(@RequestBody Todo todo){
     if(todoServices.save(todo)){
         return todo;
     }
     return null;
    }

    @DeleteMapping (value = {"todo/id/{ID}", "todo/id/{ID}/"})
    public void deleteTodoItem(@PathVariable int ID){
        todoServices.deleteTodo(ID);
    }

//    //check
//    @PostMapping(value = {"todo/title/id/{ID}", "todo/title/id/{ID}"})
//    public void editTodoTitle(@PathVariable int ID, @RequestParam String newTitle){
//        todoServices.editTitle(ID, newTitle);
//    }
//
//    //check
//    @PostMapping(value = {"todo/id/{ID}/desp{newDescription}", "todo/id/{ID}/desp{newDescription}"})
//    public void editTodoDescription(@PathVariable int ID, @PathVariable String newDescription){
//        todoServices.editDescription(ID, newDescription);
//    }


}
