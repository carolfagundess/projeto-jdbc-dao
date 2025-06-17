package model.dao.impl;

import db.DB;
import db.DbException;
import java.util.List;
import model.dao.StudentDao;
import model.entities.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.entities.Course;

/**
 *
 * @author carol
 */
public class StudentDaoJDBC implements StudentDao {

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
    public Student findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("""
                                       SELECT student.*, course.nameCourse AS CourseName FROM student
                                       INNER JOIN course ON student.idCourse = course.idCourse
                                       WHERE course.idCourse = ?;""");

            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Course course = instantiateCourse(rs);
                Student obj = instantiateStudent(rs, course);
                return obj;
            }
            return null;
        } catch (SQLException ex) {
            throw new DbException(ex.getMessage());
        } finally {
            //APROVEITANDO O MESMO DAO, MANTENDO A CONEXAO
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Student> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("""
                                        SELECT student.*, course.idCourse, course.nameCourse AS CourseName
                                        FROM student
                                        INNER JOIN course ON student.CourseId = course.idCourse
                                       """);

            rs = st.executeQuery();

            List<Student> list = new ArrayList<>();
            Map<Integer, Course> map = new HashMap<>();

            while (rs.next()) {
                //instancia para verificar se ja existe um curso criado
                Course courseMap = map.get(rs.getInt("CourseId"));
                //testar se o curse ja esta criado
                if (courseMap == null) {
                    courseMap = instantiateCourse(rs);
                    map.put(rs.getInt("CourseId"), courseMap);
                }

                Student obj = instantiateStudent(rs, courseMap);
                list.add(obj);
            }
            return list;
        } catch (SQLException ex) {
            throw new DbException(ex.getMessage());
        } finally {
            //APROVEITANDO O MESMO DAO, MANTENDO A CONEXAO
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Student> findByCourse(Course search) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("""
                                       select student.*, course.idCourse, course.nameCourse as CourseName 
                                       FROM student INNER JOIN course 
                                       ON student.CourseId = course.idCourse 
                                       WHERE student.CourseId = ? ORDER BY nameStudent
                                       """);

            st.setInt(1, search.getId());
            rs = st.executeQuery();

            List<Student> list = new ArrayList<>();
            Map<Integer, Course> map = new HashMap<>();

            while (rs.next()) {
                //instancia para verificar se ja existe um curso criado
                Course courseMap = map.get(rs.getInt("CourseId"));
                //testar se o curse ja esta criado
                if (courseMap == null) {
                    courseMap = instantiateCourse(rs);
                    map.put(rs.getInt("CourseId"), courseMap);
                }

                Student obj = instantiateStudent(rs, courseMap);
                list.add(obj);
            }
            return list;
        } catch (SQLException ex) {
            throw new DbException(ex.getMessage());
        } finally {
            //APROVEITANDO O MESMO DAO, MANTENDO A CONEXAO
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    //metodos auxiliares
    private Course instantiateCourse(ResultSet rs) throws SQLException {
        Course course = new Course();
        course.setId(rs.getInt("idCourse"));
        course.setNameCourse(rs.getString("CourseName"));
        return course;
    }

    private Student instantiateStudent(ResultSet rs, Course course) throws SQLException {
        Student obj = new Student();
        obj.setId(rs.getInt("idStudent"));
        obj.setName(rs.getString("nameStudent"));
        obj.setEmail(rs.getString("emailStudent"));
        obj.setPhone(rs.getString("phoneStudent"));
        obj.setBirthDate(rs.getDate("birthDateStudent"));
        obj.setAddress(rs.getString("address"));
        obj.setCourse(course);
        return obj;
    }

}
