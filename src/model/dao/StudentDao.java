
package model.dao;

import java.util.List;
import model.entities.Student;

/**
 *
 * @author carol
 */
public interface StudentDao {
    void insert(Student studentObj);
    void update(Student studentObj);
    void deleteById(Integer IdStudent);
    StudentDao findById(Integer id);
    List<StudentDao> findAll();
}
