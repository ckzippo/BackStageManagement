package service;

import model.Person;

/**
 * Created with IDEA
 * USER:ckzippo
 * Date:10/19/16
 * TIME:8:54 AM
 */
public interface PersonService {

    public void addPerson(Person person);

    public void deletePerson(int id);
}
