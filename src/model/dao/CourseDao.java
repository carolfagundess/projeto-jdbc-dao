
package model.dao;

import java.util.List;
import model.entities.Course;

/**
 *
 * @author carol
 */
public interface CourseDao {
    
    void insert(Course courseObj);
    void update(Course courseObjt);
    void deleteById(Integer Idcourse);
    Course findById(Integer id);
    List<Course> findAll();
}
