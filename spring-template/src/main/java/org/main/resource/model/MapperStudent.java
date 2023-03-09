package org.main.resource.model;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperStudent implements RowMapper<Student> {
    @Override
    public Student mapRow (ResultSet result, int row) {

        /* ResultSet is to return data ที่ได้จากการ select statement */

            try {

                Student student = new Student();
                student.setFirstname(result.getString("firstname"));
                student.setLastname(result.getString("lastname"));
                student.setEmail(result.getString("email"));

                return student;

            } catch (SQLException errors) {

                System.out.println("Retrieve database is Failed..."+errors);

            }
        return null;
        /* it returns method toString() Auto */
    }
}
