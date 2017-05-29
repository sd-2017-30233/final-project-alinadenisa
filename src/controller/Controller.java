package controller;

import dao.ActivityDao;
import dao.EventDao;
import dao.UserDao;
import model.Event;
import model.Person;
import model.UserRole;
import view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by iliesalinadenisa on 29/05/2017.
 */
public class Controller {
    View view;
    ActivityDao activityDao = new ActivityDao();
    EventDao eventDao = new EventDao();
    UserDao userDao = new UserDao();

    public Controller(View view, ActivityDao activityDao, EventDao eventDao, UserDao userDao) {
        this.view = view;
        this.activityDao = activityDao;
        this.eventDao = eventDao;
        this.userDao = userDao;
        this.view.addCreateProfileListener(new CreateProfileListener());
        this.view.addUpdateProfileListener(new UpdateProfileListener());
        this.view.addDeleteProfileListener(new DeleteProfileListener());
        this.view.addViewEventsListener(new ViewEventsListener());
       // this.view.addViewAttendanceListListener(new ViewAttendanceListListener());
       // this.view.addViewFreePlacesListener(new ViewFreePlacesListener());
        this.view.addCreateEventListener(new CreateEventListener());
        this.view.addUpdateEventListener(new UpdateEventListener());
        this.view.addDeleteEventListener(new DeleteEventListener());
    }

    class CreateProfileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstName = view.getFirstNameTextField().getText();
            String lastName = view.getLastNameTextField().getText();
            String email = view.getEmailTextField().getText();
            String role = view.getRoleUserField().getText();
            UserRole role1 = null;
            if (role.equals("admin")) {
                role1 = UserRole.ADMIN;
            } else if (role.equals("user")) {
                role1 = UserRole.USER;
            } else {
                JOptionPane.showMessageDialog(null, "Nu exista acest rol", "Atentie",
                        JOptionPane.ERROR_MESSAGE);
            }
            Person person = new Person(firstName, lastName, email, role1);
            userDao.addUser(person);
            JOptionPane.showMessageDialog(null, "User successfully added",
                    "Succes", JOptionPane.INFORMATION_MESSAGE);

        }


    }

    class UpdateProfileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstName = view.getFirstNameTextField().getText();
            String lastName = view.getLastNameTextField().getText();
            String email = view.getEmailTextField().getText();
            Person person = new Person();
            person.setFirstname(firstName);
            person.setLastname(lastName);
            person.setEmail(email);
            userDao.updateUser(person);
            JOptionPane.showMessageDialog(null, "User successfully updated",
                    "Succes", JOptionPane.INFORMATION_MESSAGE);

        }
    }

     class DeleteProfileListener implements ActionListener {
         @Override
         public void actionPerformed(ActionEvent e) {
             String firstName = view.getFirstNameTextField().getText();
             userDao.deleteUser(firstName);
             JOptionPane.showMessageDialog(null, "User successfully deleted",
                     "Succes", JOptionPane.INFORMATION_MESSAGE);
         }
     }

    class ViewEventsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Event> events =  eventDao.getAllEvents();
            System.out.print("rewre");
            for (Event event : events) {
                view.getTextArea().append(event.toString());
            }
        }
    }

    class CreateEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = view.getTitleEventTextField().getText();
            String description = view.getDescriptionEventTextField().getText();
            String startDate = view.getStartDateTextField().getText();
            String endDate = view.getEndDateTextField().getText();
            String maxRegStr = view.getMaxRegTextField().getText();
            String activity_IdStr = view.getActivityIdTextField().getText();
            String person_IdStr = view.getPersonIdTextField().getText();
            String location_IdStr = view.getLocationIdTextField().getText();
            int maxReg = Integer.parseInt(maxRegStr);
            int activity_Id = Integer.parseInt(activity_IdStr);
            int person_Id = Integer.parseInt(person_IdStr);
            int location_Id = Integer.parseInt(location_IdStr);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            java.util.Date date = null;
            java.util.Date date1 = null;
            try {
                date = sdf.parse(startDate);
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
            java.sql.Date sqlDate = new Date(date.getTime());

            try {
                date1 = sdf.parse(endDate);
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
            java.sql.Date sqlDate1 = new Date(date1.getTime());

            Event event = new Event(title,description,sqlDate,sqlDate1,maxReg,activity_Id,person_Id,location_Id);
            eventDao.addEvent(event);
            JOptionPane.showMessageDialog(null, "Event successfully added",
                    "Succes", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    class UpdateEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = view.getTitleEventTextField().getText();
            String description = view.getDescriptionEventTextField().getText();
            String startDate = view.getStartDateTextField().getText();
            String endDate = view.getEndDateTextField().getText();
            String maxRegStr = view.getMaxRegTextField().getText();
            int maxReg = Integer.parseInt(maxRegStr);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            java.util.Date date = null;
            java.util.Date date1 = null;
            try {
                date = sdf.parse(startDate);
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
            java.sql.Date sqlDate = new Date(date.getTime());

            try {
                date1 = sdf.parse(endDate);
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
            java.sql.Date sqlDate1 = new Date(date1.getTime());


            Event event = new Event();
            event.setTitle(title);
            event.setDescription(description);
            event.setStartTime(sqlDate);
            event.setEndTime(sqlDate1);
            event.setMaximumRegistrations(maxReg);
            eventDao.updateEvent(event);
            JOptionPane.showMessageDialog(null, "Event successfully updated",
                    "Succes", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    class DeleteEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = view.getTitleEventTextField().getText();
            eventDao.deleteEvent(title);
            JOptionPane.showMessageDialog(null, "Event successfully deleted",
                    "Succes", JOptionPane.INFORMATION_MESSAGE);

        }
    }
}