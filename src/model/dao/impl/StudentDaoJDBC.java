
package model.dao.impl;

import db.DB;
import db.DbException;
import java.util.List;
import model.dao.StudentDao;
import model.entities.Student;
import java.sql.*;
import model.entities.Course;

/**
 *
 * @author carol
 */
public class StudentDaoJDBC implements StudentDao{
    
    private Connection conn;

    public StudentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Student studentObj) {
    }

    @Override
    public void update(Student studentObj) {
    }

    @Override
    public void deleteById(Integer IdStudent) {
    }

    @Override
    public StudentDao findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        
        try {
            st = conn.prepareStatement("SELECT student.*, course.Name as CourseName FROM student INNER JOIN course ON student.CouseId = course.Id WHERE course.Id = ? ");
            
            st.setInt(1, id);
            rs = st.executeQuery();
            
            if (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt("idCourse"));
                course.setNome(rs.getString("nameCourse"));
                Student obj = new Student();
                obj.setId(rs.getInt("idStudnent"));
                obj.setEmail(rs.getString("emailStudent"));
                obj.setPhone(rs.getInt("phoneStudent"));
                obj.setBirthDate(rs.getDate("birthDateStudent"));
                obj.setAddress(rs.getString("address"));
                obj.setCourse(course);
                
            } 
            return null;
        } catch (SQLException ex) {
            throw  new DbException(ex.getMessage());
        } finally{
            //APROVEITANDO O MESMO DAO, MANTENDO A CONEXAO
             DB.closeStatement(st);
             DB.closeResultSet(rs);
        }
    }

    @Override
    public List<StudentDao> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
