package ru.alex.app.restAPI;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.app.model.Todo;
import ru.alex.app.service.TodoService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
@Slf4j
public class TodoAPI {
    private final TodoService todoService;

    @Autowired
    public TodoAPI(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code= 200, message = "Success"), @ApiResponse(code = 500, message = "Internal server error"), @ApiResponse(code = 404, message = "Todo not found")})
    public ResponseEntity<List<Todo>> findAll() {
        List<Todo> todoList = todoService.findAll();

        if(todoList.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);


        return new ResponseEntity<>(todoList, HttpStatus.OK);
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 500, message = "Internal server error"), @ApiResponse(code = 404, message = "Todo not found")})
    public ResponseEntity<List<Todo>> saveAll(@Valid @RequestBody List<Todo> todos) {
        log.info(todos.toString());

        List<Todo> todoList = this.todoService.findAll();

        if(todoList.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        this.todoService.saveAll(todos);

        return new ResponseEntity<>(todos, HttpStatus.OK);
    }
}
