
package model.dao;

import java.util.List;
import model.entities.Course;
import model.entities.Student;

/**
 *
 * @author carol
 */
public interface StudentDao {
    void insert(Student studentObj);
    void update(Student studentObj);
    void deleteById(Integer IdStudent);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByCourse(Course course);
}
