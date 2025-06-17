
package model.entities;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author carol
 */
public class Course implements Serializable {
    
    private Integer id;
    private String nameCourse;
    private String description;
    private Integer workload;
    private String area;     

    public Course() {
    }

    public Course(Integer id, String nome) {
        this.id = id;
        this.nameCourse = nome;
    }

    public Course(Integer id, String nameCourse, String description, Integer workload, String area) {
        this.id = id;
        this.nameCourse = nameCourse;
        this.description = description;
        this.workload = workload;
        this.area = area;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nome) {
        this.nameCourse = nome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWorkload() {
        return workload;
    }

    public void setWorkload(Integer workload) {
        this.workload = workload;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
    


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Course other = (Course) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Curso{" + "id=" + id + ", nome=" + nameCourse + '}';
    }    
}
