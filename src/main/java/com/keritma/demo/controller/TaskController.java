
package com.keritma.demo.controller;

import com.keritma.demo.entities.Task;
import com.keritma.demo.services.TaskService;
import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*Si se quiere usar @GetMapping para establecer la ruta, osea, si tenemos varias
entidades, para cada una estableceriamos Ej: (/api/Tasks) o (/api/Xxxx)*/
public class TaskController {
    
    /* Si se quiere para instanciar el servicio usar:
       @Autowired
    Aunque nótese que sin el, springboot lo instancia, a lo mejor es la version 
    que estoy usando que instancia automaticamente!!.No lo que pasa es que yo lo estoy
    instanciando en el constructor!!!
    Y con@Auto.. no hay necesidad de crear el construtor y ademas crea la instancia!!
    */
    //@Autowired
    private final TaskService servicio;
    
    
    public TaskController(TaskService service){
        this.servicio = service;
    }
    @GetMapping("/Chulo")
    public String hola(){
        return "Hola Mundo Cruel";
    }
    
    @GetMapping("/Tasks")
    public List<Task> TaskList(){
        return servicio.getTaskList();
    }
    @PostMapping("/Tasks")
    public ResponseEntity createTask(@RequestBody Task task){
        servicio.createTask(task);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/Tasks")
    public ResponseEntity actualizarTask(@RequestBody Task task){
        servicio.updateTask(task);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/Tasks")
    public ResponseEntity eliminarTask(@RequestBody Task task){
        servicio.deleteTask(task.getId());
        return ResponseEntity.status(204).build();
    }
    
}
