package ru.alex.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alex.app.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
