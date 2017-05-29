package dao;

import model.Event;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by iliesalinadenisa on 28/05/2017.
 */
public class EventDao {
    private Connection connection;

    public EventDao() {
        connection = DBUtil.getConnection();
        System.out.println("Conexiunea :" + connection);
    }

    public void addEvent(Event event) {
        try {
            PreparedStatement statement =
                    connection.prepareStatement("insert into event(title,description,start_date,end_date,max_reg,activity_id,person_id,location_id) values (?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, event.getTitle());
            statement.setString(2, event.getDescription());
            statement.setDate(3, event.getStartTime());
            statement.setDate(4, event.getEndTime());
            statement.setInt(5, event.getMaximumRegistrations());
            statement.setInt(6, event.getActivity_id());
            statement.setInt(7, event.getPerson_id());
            statement.setInt(8, event.getLocation_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEvent(Event event) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update event set description=?, start_date=? , end_date =?, max_reg =?" +
                            " where title=?");
            // Parameters start with 1
            preparedStatement.setString(1, event.getDescription());
            preparedStatement.setDate(2, event.getStartTime());
            preparedStatement.setDate(3, event.getEndTime());
            preparedStatement.setInt(4,event.getMaximumRegistrations());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEvent(String title) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from event where title=?");
            // Parameters start with 1
            preparedStatement.setString(1, title);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<Event>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from event");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idEvent = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                java.sql.Date startDate = rs.getDate("start_date");
                java.sql.Date endDate = rs.getDate("end_date");
                int max_reg = rs.getInt("max_reg");
                int activity_id = rs.getInt("activity_id");
                int person_id = rs.getInt("person_id");
                int location_id = rs.getInt("location_id");
                Event event = new Event(idEvent,title,description,startDate,endDate,max_reg,activity_id,person_id,location_id);
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    public Event getEventById(int idEvent){
        Event event = new Event();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from event where id =?");
            preparedStatement.setInt(1,idEvent);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                String description = rs.getString("description");
                java.sql.Date startDate = rs.getDate("start_date");
                java.sql.Date endDate = rs.getDate("end_date");
                int max_reg = rs.getInt("max_reg");
                int activity_id = rs.getInt("activity_id");
                int person_id = rs.getInt("person_id");
                int location_id = rs.getInt("location_id");

                event.setTitle(title);
                event.setDescription(description);
                event.setStartTime(startDate);
                event.setEndTime(endDate);
                event.setMaximumRegistrations(max_reg);
                event.setActivity_id(activity_id);
                event.setPerson_id(person_id);
                event.setLocation_id(location_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return event;
    }
}
