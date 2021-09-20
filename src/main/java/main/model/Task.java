package main.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@Table(name = "tasks")
@NoArgsConstructor
@AllArgsConstructor
public class Task
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id")
    private Long idTask;

    @Column(name = "task_name")
    private String name;

    @Column(name = "task_date")
    private String day;

}
