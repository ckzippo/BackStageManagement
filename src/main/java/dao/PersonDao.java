package dao;

import model.Person;
import org.springframework.stereotype.Repository;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:10/19/16
 * TIME:8:00 AM
 */

public interface PersonDao {

    public void addPerson(Person person);

    public void deletePerson(int id);
}
