
package com.keritma.demo.entities;
/*Pienso que cuando instalemos la base de datos esta clase ya no es necesaria
porque con el repositorio accedemos al findAll() el cual nos trae todos los
registros,es decir, todas las tareas, y lo hace en forma de lista, List<Task>*/
import java.util.*;


public class TaskList {
    
    private String name;
    private final List<Task> taskList;

    public TaskList(String name) {
        this.name = name;
        this.taskList = new ArrayList<>();
    }

    public void addTask(Task tarea){
        this.taskList.add(tarea);
    } 

    public List<Task> getTaskList() {
        return taskList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
       
}
