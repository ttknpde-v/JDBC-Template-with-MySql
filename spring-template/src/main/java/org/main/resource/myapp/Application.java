package org.main.resource.myapp;

import org.main.resource.configure.AppConfigure;
import org.main.resource.model.Student;
import org.main.resource.myinterface.StudentDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

        /*for (String beanName : context.getBeanDefinitionNames())  { Check Bean at Working
            System.out.println(beanName);
            /* Order bean works
            *  @ComponentScan("...") class -> AppConfigure
            *  @Component class -> StudentDOAImplement
            * *
        }*/

        /* List<Student> data = studentDAO.getAllStudent();
           in data has all value in table from select */

        /* for (Student data : studentDAO.getAllStudent()) {
            System.out.println(data);
            method toString() working
            auto
            }   */

public class Application {
    public static void main(String[] args) {

        /* load spring with AnnotationConfigApplicationContext
        *  because I is not use file XML configuration  */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfigure.class); /* Class AppConfigure It's working now */

        /* retrieve bean get to object */
        StudentDAO studentDAO = context.getBean("studentDOA" , StudentDAO.class);


        /* call/use method bean */
        Student findIdSix = studentDAO.getStudentById(6);
        System.out.println(findIdSix);

        /* update Id six */
        findIdSix.setFirstname("Beer");
        findIdSix.setLastname("Beer");
        findIdSix.setEmail("Beer@hotmail.com");

        /* process and result */
        studentDAO.updateStudent(6,findIdSix);
        System.out.println(studentDAO.getStudentById(6));

        context.close();

    }
}
