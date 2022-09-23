
package com.keritma.demo.services;


import com.keritma.demo.entities.Task;
import com.keritma.demo.repositories.TaskRepository;
import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TaskService {
    
    /*Si se quiere usar para que se "instancie" Taskrepository usar:
      @Autowired
      Ahhhhhh ya!,
    springboot nos ha creado un objeto repository que seria una tabla intermedia
    que contiene toda la informacion. Por lo tanto springboot nos pasa este obje-
    to como parámetro al constructor. Si usamos el @Autow.. spring boot me crea el
    constructor que justamente tenemos abajo!!!
    */
    //@Autowired
    private final TaskRepository repository;
    
    public TaskService(TaskRepository repository){
        this.repository = repository;       
    }
    
    public List<Task> getTaskList(){
        return this.repository.findAll();
    }
    
    public Task createTask(Task newTask){ //podriamos ver si ya existe!!
        return this.repository.save(newTask);
    }
    
    public Task updateTask(Task otraTask){
        Task existeTask = repository.findById(otraTask.getId()).orElse(null);
        existeTask.setDescription(otraTask.getDescription());
        existeTask.setDone(otraTask.isDone());
        existeTask.setDueDate(otraTask.getDueDate());
        return this.repository.save(existeTask);
    }
    
    public String deleteTask(long id){
        this.repository.deleteById(id);
        return "Producto removido" + id;
    }

  
    
    
}
