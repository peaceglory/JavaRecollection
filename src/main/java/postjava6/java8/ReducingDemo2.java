package postjava6.java8;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReducingDemo2 {

    public static void main(String[] args) {
        final List<Person> people =
                ImmutableList.of(new Person(Person.Sex.MALE, 24), new Person(Person.Sex.FEMALE, 33),
                        new Person(Person.Sex.MALE, 18), new Person(Person.Sex.FEMALE, 21),
                        new Person(Person.Sex.MALE, 21), new Person(Person.Sex.FEMALE, 24));

        final Map<Person.Sex, Integer> totalAgeByGender =
                people.stream().collect(Collectors.groupingBy(Person::getSex,
                                                              Collectors.reducing(0, Person::getAge, Integer::sum)));

        totalAgeByGender.forEach((gender, ageSum) -> System.out.println("Gender: " + gender + ", total age: " + ageSum));

    }

    private static class Person {
        private final Sex sex;
        private final int age;

        public Person(Sex sex, int age) {
            this.sex = sex;
            this.age = age;
        }

        public Sex getSex() {
            return sex;
        }

        public int getAge() {
            return age;
        }

        enum Sex {
            MALE, FEMALE;
        }


    }
}


