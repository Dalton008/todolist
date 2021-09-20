package main.service;

import main.dto.TaskDTO;
import main.model.Task;

public class ConvertDTOtoModel
{
    public static Task convertDTOtoModel(TaskDTO taskDTO)
    {
        return Task.builder().
                idTask(taskDTO.getIdTask())
                .name(taskDTO.getName())
                .day(taskDTO.getDay())
                .build();
    }
}
