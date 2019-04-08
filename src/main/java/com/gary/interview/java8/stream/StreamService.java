
package com.gary.interview.java8.stream;


import com.gary.interview.java8.commonUtils.MockPerson;
import com.gary.interview.java8.commonUtils.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.gary.interview.java8.commonUtils.PersonConstants.*;

public class StreamService {
    private List<Person> personList = MockPerson.getData();


    /**
     * Filter
     */

    // only left male
    public List<Person> filterGenderWithStream() {
        List<Person> resultList = personList.stream().filter(person -> person.getGender().equalsIgnoreCase(GENDER_MALE)).collect(Collectors.toList());
        return resultList;
    }

    // only left male
    public List<Person> filterGenderWithoutStream() {
        List<Person> resultList = new ArrayList<>();
        for (Person person : personList) {
            if (person.getGender().equalsIgnoreCase(GENDER_MALE)) {
                resultList.add(person);
            }
        }
        return resultList;
    }

    // only left male & adult
    public List<Person> filterGenderAndAgeWithoutStream() {
        List<Person> resultList = new ArrayList<>();
        for (Person person : personList) {
            if (person.getGender().equalsIgnoreCase(GENDER_MALE)
                    && person.getAge() >= AGE_ADULT) {
                resultList.add(person);
            }
        }

        return resultList;
    }

    // only left female & elder
    public List<Person> filterGenderAndAgeWithStream() {
        List<Person> resultList = personList.stream().filter(person -> person.getGender().equalsIgnoreCase(GENDER_FEMALE)
                && person.getAge() >= AGE_ELDER).collect(Collectors.toList());
        return resultList;
    }

    /**
     * Map
     */

    // get all names
    public List<String> getAllNamesWithoutStream() {
        List<String> nameList = new ArrayList<>();
        for (Person person : personList) {
            nameList.add(person.getName());
        }
        return nameList;
    }

    // get all names
    public List<String> getAllNamesWithStream1() {
        List<String> nameList = personList.stream().map(person -> person.getName()).collect(Collectors.toList());
        return nameList;
    }

    // get all names
    public List<String> getAllNamesWithStream2() {
        List<String> nameList = personList.stream().map(Person::getName).collect(Collectors.toList());
        return nameList;
    }

    // get all elder names
    public List<String> getElderNameWithStream() {
        List<String> nameList = personList.stream().filter(person -> person.getAge() >= AGE_ELDER).map(person -> person.getName()).collect(Collectors.toList());
        return nameList;
    }

    /**
     * FlatMap
     */






    /**
     *  Getter & Setter
     *
     */

    public List<Person> getPersonList() {
        return personList;
    }
}
