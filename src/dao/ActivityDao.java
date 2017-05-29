package dao;

import model.Activity;
import model.Person;
import model.UserRole;
import util.DBUtil;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by iliesalinadenisa on 28/05/2017.
 */
public class ActivityDao {

    private Connection connection;

    public ActivityDao() {
        connection = DBUtil.getConnection();
        System.out.println("Conexiunea :" + connection);
    }

    public void addActivity(Activity activity) {
        try {
            PreparedStatement statement =
                    connection.prepareStatement("insert into activity(title,description) values (?, ?)");
            statement.setString(1, activity.getTitle());
            statement.setString(2, activity.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteActivity(String title) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from activity where title=?");
            // Parameters start with 1
            preparedStatement.setString(1, title);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Activity> findAllActivities() {
        List<Activity> activities = new ArrayList<Activity>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from activity");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idActivity = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                Activity activity = new Activity(idActivity,title,description);
                activities.add(activity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activities;
    }

    public Activity getActivityById(int id){
        Activity activity = new Activity();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from activity where id =?");
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idActivity = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");

                activity.setId(idActivity);
                activity.setTitle(title);
                activity.setDescription(description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activity;
    }

}
