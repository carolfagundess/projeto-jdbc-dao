package model.dao;

import model.dao.impl.StudentDaoJDBC;

/**
 *
 * @author carol
 */
public class DaoFactory {
    
    public static StudentDao createStudentDao(){
        return new StudentDaoJDBC();
    }
}
