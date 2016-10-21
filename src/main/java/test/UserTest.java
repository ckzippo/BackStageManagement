package test;

import model.BackStageAdmin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.BackStageAdminService;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:10/19/16
 * TIME:8:26 AM
 */
public class UserTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/ApplicationContext.xml");
        /*PersonDao userDao = (PersonDao) ctx.getBean("userDao");
        Person person = new Person();
        person.setName("lisi");
        person.setAge(11);
        userDao.addPerson(person);*/

       /* PersonService personService = (PersonService) ctx.getBean("personServiceImple");
        Person person = new Person();
        person.setName("陈江1");
        person.setAge(12);
        personService.addPerson(person);*/
//        personService.deletePerson(8);

       /* UserService userService = (UserService) ctx.getBean("userServiceImple");
        System.out.println(userService.qryUserById("29297"));*/

        BackStageAdminService backStageAdminService = (BackStageAdminService) ctx.getBean("backStageAdminServiceImple");
        System.out.println(backStageAdminService.validateAdmin("lixing" , "123"));
        BackStageAdmin backStageAdmin = new BackStageAdmin();
        backStageAdmin.setAcc("lixing");
        backStageAdmin.setPassword("12345");
        backStageAdmin.setRole(1);
        backStageAdmin.setDeptid(320);
/*
        backStageAdminService.addBackStageAdmin(backStageAdmin);
*/
    }
}
