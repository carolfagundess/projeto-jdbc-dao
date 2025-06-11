package model.dao;

import db.DB;
import model.dao.impl.StudentDaoJDBC;

/**
 *
 * @author carol
 */
public class DaoFactory {
    
    public static StudentDao createStudentDao(){
        return new StudentDaoJDBC(DB.getConnection());
    }
}
