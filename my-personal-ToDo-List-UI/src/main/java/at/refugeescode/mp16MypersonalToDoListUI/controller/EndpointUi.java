package at.refugeescode.mp16MypersonalToDoListUI.controller;
import at.refugeescode.mp16MypersonalToDoListUI.model.ToDo;
import at.refugeescode.mp16MypersonalToDoListUI.repository.ToDoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Controller
@RequestMapping
public class EndpointUi {

   // private ToDo toDo;
    private ToDoRepository toDoRepository;

    public EndpointUi(ToDoRepository toDoRepository) {

        this.toDoRepository = toDoRepository;
    }

    @GetMapping("/todos")
    String page(){
        return "todos";
    }

    @ModelAttribute("allList")
    List<ToDo> getAllToDos(){
        RestTemplate restTemplate = new RestTemplate();
         ToDo[] forObject = restTemplate.getForObject("http://localhost:8082/todos", ToDo[].class);
       return Stream.of(forObject).collect(Collectors.toList());
    }


    @ModelAttribute("newToDo")
    ToDo getNewToDo(){
        return new ToDo();
    }


    @PostMapping("/todos")
    String post(ToDo todo) {
        RestTemplate restTemplate = new RestTemplate();
        ToDo toDo = restTemplate.postForEntity("http://localhost:8082/todos", todo, ToDo.class).getBody();
        return "redirect:todos";
    }


    @PutMapping("/done")
    public String updateDone(@RequestParam String id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put("http://localhost:8082/done", id, String.class);
        return "redirect:/todos";
    }

    @PostMapping("/update")
    public String updateTask(@RequestParam String id1 , @RequestParam String taskname) {
        RestTemplate restTemplate = new RestTemplate();
        ToDo toDo = new ToDo();
        toDo.setId(id1);
        toDo.setTask(taskname);
        toDo.setDone(false);
        restTemplate.postForEntity("http://localhost:8082/update", toDo, ToDo.class).getBody();
        return "redirect:/todos";
    }

    @PostMapping("/delete")
    public String deleteToDo(@RequestParam String id1) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity("http://localhost:8082/delete", id1, String.class).getBody();
        return "redirect:/todos";
    }


}