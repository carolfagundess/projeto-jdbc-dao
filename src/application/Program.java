
package application;

import model.dao.DaoFactory;
import model.dao.StudentDao;

/**
 *
 * @author carol
 */
public class Program {
    public static void main(String[] args) {
        
        System.out.println("TESTANDO O PROGRAMA NO CONSOLE");
        
        StudentDao studentDao = new DaoFactory().createStudentDao();
        System.out.println(studentDao.findById(1));
        
    }
}
