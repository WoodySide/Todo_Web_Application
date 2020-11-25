package ru.alex.app.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.alex.app.model.Todo;
import ru.alex.app.repository.TodoRepository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @Test
    public void whenFindAll_thenReturnTodoList() {
        Todo todo = Todo.builder()
                .id(1L)
                .title("To build a house")
                .build();

        List<Todo> expectedTodos = Arrays.asList(todo);

        doReturn(expectedTodos).when(todoRepository).findAll();

        List<Todo> actualTodos = todoService.findAll();

        assertThat(actualTodos).isEqualTo(expectedTodos);
    }

    @Test
    public void whenFindAll_thenReturnSavedTodos() {
        Todo todo = Todo.builder()
                .id(1L)
                .title("To buy a car")
                .build();

        List<Todo> expectedTodos = Arrays.asList(todo);

        List<Todo> expectedToBeSaved = todoRepository.saveAll(expectedTodos);

        List<Todo> actualToBeSaved = todoService.saveAll(expectedTodos);

        assertThat(actualToBeSaved).isEqualTo(expectedToBeSaved);
    }
}

