package com.example.kcell_gradle.models;

/*
 * @author Токмурзин Мукагали
 * @version 1.0
 * @email mukagali.2002.05@gmail.com
 */

/*
*
* This is a main body of my Affairs and used him like main Entity.
* I also created getters, setters and toString methods.
*
* */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
    public class Affairs {
    private @Id @GeneratedValue Long id;
    private String name;
    private LocalDate affairDate;
    private String attributes;
    private boolean done = false;

    public Affairs() {}

    public Affairs( String name, String attributes, LocalDate affairDate) {
        this.name = name;
        this.attributes = attributes;
        this.affairDate = affairDate;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }


    @Override
    public String toString() {
        return "Affairs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", affairDate=" + affairDate +
                ", attributes='" + attributes + '\'' +
                ", done=" + done +
                '}';
    }
}
