package com.example.ulbitv.Service;


import com.example.ulbitv.entity.TodoEntity;
import com.example.ulbitv.entity.UserEntity;
import com.example.ulbitv.model.Todo;
import com.example.ulbitv.repository.UserRepo;
import com.example.ulbitv.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId) {
        UserEntity user=userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }

    public Todo completeTodo(Long id) {
        TodoEntity todo =todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepo.save(todo));
    }
}
