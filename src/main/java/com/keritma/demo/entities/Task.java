package com.keritma.demo.entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
//import javax.persistence.Entity;

/*Si no se quiere crear "manualmente" los 2 constructores y los getters and setters
  primero inyectar la dependencia Lombok y luego las anotaciones:
  @Data
  @AllArgsConstructor
  @NoArgsConstructor*/
@Entity
@Table(name="task")
@SuppressWarnings("PersistenceUnitPresent")
public class Task implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "done")
    private boolean done;
    
    @Column(name = "dueDate")
    private LocalDate dueDate;
    
    public Task(){
    }

    public Task(String description, boolean done, LocalDate date) {
        this.description = description;
        this.done = done;
        this.dueDate = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
 
}
