package org.main.resource.mydao;


import org.main.resource.model.MapperStudent;
import org.main.resource.model.Student;
import org.main.resource.myinterface.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.util.List;

/* Lean to JDBC Template */

@Component("studentDOA")
public class StudentDAOImplement implements StudentDAO {
    private JdbcTemplate jdbc;
    /* crate */
    private final String SQL_INSERT_STUDENT = "insert into details(firstname, lastname, email) values(?,?,?); ";

    /* select just one */
    private final String SQL_SELECT_ID_STUDENT = "SELECT firstname,lastname,email FROM details WHERE orders = ? ;";

    /* all select */
    private final String SQL_SELECT_ALL = "SELECT firstname,lastname,email FROM details ORDER BY orders DESC ;";

    /* delete by Id */
    private final String SQL_DELETE_ID_STUDENT = "DELETE FROM details WHERE orders = ? ;";

    /* update */
    private final String SQL_UPDATE_STUDENT = "UPDATE details SET firstname = ? , lastname = ? , email = ? WHERE orders LIKE ?;";

    @Autowired
    /* when I use class the construct will work
    *  and DataSource from Class AppConfigure
    *  it into this construct */
    public StudentDAOImplement(DataSource dataSource) {

        this.jdbc = new JdbcTemplate(dataSource);

    }

    @Override
    public int insertStudent(Student student) {

        return this.jdbc.update(SQL_INSERT_STUDENT , student.getFirstname() , student.getLastname() , student.getEmail());

    }

    @Override
    public int deleteStudent(Integer order)
    {
        return this.jdbc.update(SQL_DELETE_ID_STUDENT,order);

    }

    @Override
    public int updateStudent(Integer order , Student student) {

        return this.jdbc.update(SQL_UPDATE_STUDENT , student.getFirstname() , student.getLastname() , student.getEmail() ,order);

    }

    @Override
    public Student getStudentById(Integer order) {
        MapperStudent mapperStudent = new MapperStudent();
        Object []args = {order};
        return this.jdbc.queryForObject(SQL_SELECT_ID_STUDENT, args , mapperStudent);
               /* return object */

    }

    @Override
    public List<Student> getAllStudent() {
        MapperStudent mapperStudent = new MapperStudent();
        List<Student> data = this.jdbc.query(SQL_SELECT_ALL , mapperStudent);
        return data;
        /* return arrays object
        *  องค์ประกอบทั้งหมดจะอยู่ใน array list data */
    }
    
}
