package ua.kpi.StudentsSystem.entity;

import javax.persistence.*;

/**
 * Created by Evgeniy on 07.08.2017.
 */

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Subjects {" + "id = " + id + ", name = '" + name + '\'' + '}';
    }
}
