package at.refugeescode.mp16MypersonalToDoListUI.repository;


import at.refugeescode.mp16MypersonalToDoListUI.model.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ToDoRepository extends MongoRepository<ToDo, String> {

    Optional<ToDo> findByTask(String task);
}
