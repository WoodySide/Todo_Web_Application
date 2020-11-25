package ru.alex.app.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alex.app.model.Todo;
import ru.alex.app.repository.TodoRepository;
import java.util.List;

@Service
@Slf4j
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAll() {
        log.info("In TodoService findAll");
       return todoRepository.findAll();
    }


    public List<Todo> saveAll(List<Todo> todos) {
        log.info("In TodoService saveAll");
        return todoRepository.saveAll(todos);
    }
}
