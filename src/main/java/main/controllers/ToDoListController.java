package main.controllers;

import main.dto.TaskDTO;
import main.service.ConvertDTOtoModel;
import main.service.TaskManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.model.Task;

import java.util.Map;

@RestController
public class ToDoListController
{
    private final TaskManagerService taskManagerService;

    @Autowired
    public ToDoListController(TaskManagerService taskManagerService) {
        this.taskManagerService = taskManagerService;
    }

    @PostMapping("/tasks/add/")
    public ResponseEntity addTask(@RequestBody TaskDTO taskDTO)
    {
        Task newTask = ConvertDTOtoModel.convertDTOtoModel(taskDTO);
        taskManagerService.addTask(newTask);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/tasks/{idTask}")
    public ResponseEntity getTask(
            @RequestParam(name = "page", required = false) Integer page,
            @RequestParam(name = "pageSize", required = false) Integer pageSize,
            @RequestParam(name = "sortBy", required = false) Map<String, Boolean> sortBy,
            @RequestParam(name = "filters", required = false) Map<String, Object> filters,
            @PathVariable Long idTask)
    {
        if ((page == null || pageSize == null) && (sortBy == null || sortBy.isEmpty()) && (filters == null || filters.isEmpty()))
        {
            if (idTask == null)
                return ResponseEntity.ok(taskManagerService.getTasks());
            else
                return ResponseEntity.ok(taskManagerService.getTask(idTask));
        }
        else
            return ResponseEntity.ok(taskManagerService.getTasks(page, pageSize, sortBy, filters));
    }

    @DeleteMapping(value = "/tasks/{idTask}", consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteTask(@PathVariable Long idTask)
    {
        taskManagerService.removeTask(idTask);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/tasks/{idTask}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> updateTask(@RequestBody TaskDTO taskDTO)
    {
        Task task = ConvertDTOtoModel.convertDTOtoModel(taskDTO);
        taskManagerService.updateTask(task);
        return ResponseEntity.ok(taskManagerService.updateTask(task));
    }
}
