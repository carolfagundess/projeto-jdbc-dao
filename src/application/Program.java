package application;

import java.util.List;
import java.util.Date;
import model.dao.DaoFactory;
import model.dao.StudentDao;
import model.entities.Course;
import model.entities.Student;

/**
 *
 * @author carol
 */
public class Program {

    public static void main(String[] args) {

        System.out.println("TESTANDO O PROGRAMA NO CONSOLE");

        StudentDao studentDao = new DaoFactory().createStudentDao();
//        
//        List<Student> list = studentDao.findAll();
//        
//        for (Student student : list) {
//            System.out.println(student);
//        }
//        
        Course course = new Course(6, "teste");
        
        //TESTANDO INSERCAO
        Student student = new Student(Integer.SIZE, "Teste", "teste", "teste",  new Date() , "teste", course);
        studentDao.insert(student);
        System.out.println(student.getId());
    }
}

