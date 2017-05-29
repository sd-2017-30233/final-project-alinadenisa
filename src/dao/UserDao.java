package dao;

import model.UserRole;
import model.Person;
import util.DBUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by iliesalinadenisa on 27/03/2017.
 */
public class UserDao {
    private Connection connection;

    public UserDao() {
        connection = DBUtil.getConnection();
        System.out.println("Conexiunea :" + connection);
    }

    public void addUser(Person person) {
        try {
            PreparedStatement statement =
                    connection.prepareStatement("insert into person(first_name,last_name,email,role) values (?, ?, ?, ?)");
            statement.setString(1, person.getFirstname());
            statement.setString(2, person.getLastname());
            statement.setString(3, person.getEmail());
            int role = 0;
            if (person.getRole().equals(UserRole.ADMIN)) role = 1;
            if (person.getRole().equals(UserRole.USER)) role = 2;
            statement.setInt(4, role);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(Person person) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update person set last_name=?, email=?" +
                            " where first_name=?");
            // Parameters start with 1
            preparedStatement.setString(1, person.getLastname());
            preparedStatement.setString(2, person.getEmail());
            preparedStatement.setString(3, person.getFirstname());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String firstName) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from person where first_name=?");
            // Parameters start with 1
            preparedStatement.setString(1, firstName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Person> findAll() {
        List<Person> users = new ArrayList<Person>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from person");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idPerson = rs.getInt("id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String email = rs.getString("email");
                int role = rs.getInt("role");

                UserRole roleEnum = null;
                if (role == 1) {
                    roleEnum = UserRole.ADMIN;
                } else if (role == 2) {
                    roleEnum = UserRole.USER;
                }
                Person person = new Person(idPerson, first_name, last_name, email, roleEnum);
                users.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    /*
    public User getUserByUsername(String username){
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where username =?");
            preparedStatement.setString(1,username);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idUser = rs.getInt("id");
                username = rs.getString("username");
                String password = rs.getString("password");
                String name = rs.getString("name");
                int role = rs.getInt("role");

                Role roleEnum = null;
                if (role == 1) {
                    roleEnum = Role.ADMIN;
                } else if (role == 2) {
                    roleEnum = Role.EMPLOYEE;
                }
                user.setId(idUser);
                user.setUsername(username);
                user.setPassword(password);
                user.setRole(roleEnum);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    */
}

