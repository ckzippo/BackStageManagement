package service.imple;

import dao.PersonDao;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.PersonService;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:10/19/16
 * TIME:8:55 AM
 */

@Service
public class PersonServiceImple implements PersonService {

    @Autowired
    private PersonDao personDao;

    public void addPerson(Person person) {
        personDao.addPerson(person);
    }

    public void deletePerson(int id) {
        personDao.deletePerson(id);
    }
}
