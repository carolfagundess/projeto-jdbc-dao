package application;

import java.util.List;
import model.dao.DaoFactory;
import model.dao.StudentDao;
import model.entities.Student;

/**
 *
 * @author carol
 */
public class Program {

    public static void main(String[] args) {

        System.out.println("TESTANDO O PROGRAMA NO CONSOLE");

        StudentDao studentDao = new DaoFactory().createStudentDao();
        
        List<Student> list = studentDao.findAll();
        
        for (Student student : list) {
            System.out.println(student);
        }
    }
}

