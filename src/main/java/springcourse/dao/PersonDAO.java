package springcourse.dao;

import org.springframework.stereotype.Component;
import springcourse.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
//    private final List<Person> people;
//
//    {
//        people = new ArrayList<>();
//        people.add(new  Person(++PEOPLE_COUNT,"Tom",18,"test1@gmail.com"));
//        people.add(new  Person(++PEOPLE_COUNT,"Jack",22,"test2@gmail.com"));
//        people.add(new  Person(++PEOPLE_COUNT,"Artur",17,"test3@gmail.com"));
//        people.add(new  Person(++PEOPLE_COUNT,"James",12,"test4@gmail.com"));
//    }
    private static final String URL = "jdbc:postgresql://localhost:5433/first_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";
    private static Connection connection;
    static {
        try {
            Class.forName("org.postgresql.Drive");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Person> index()  {
//        return people;
        List<Person> people = new ArrayList<>();
        try {
            ResultSet resultSet;
            try (Statement statement = connection.createStatement()) {

                String SQL = "Select * FROM  Person";
                resultSet = statement.executeQuery(SQL);
            }

            while (resultSet.next()){
               Person person = new Person();

               person.setId(resultSet.getInt("id"));
               person.setName(resultSet.getString("name"));
               person.setAge(resultSet.getInt("age"));
               person.setEmail(resultSet.getString("email"));

               people.add(person);
           }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
      return  people;
    }

    public Person show(int id){
      return null;
//      return   people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
//        person.setId(++PEOPLE_COUNT);
//        people.add(person);
    }

    public  void update(Person personUpdated ,int id){

        Person person = show(id);
        person.setName(personUpdated.getName());
        person.setAge(personUpdated.getAge());
        person.setEmail(personUpdated.getEmail());
    }
    public void remove(int id){
//        people.removeIf(p-> p.getId() == id);
    }

}

