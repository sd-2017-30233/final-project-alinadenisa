package view;

import controller.Controller;
import dao.ActivityDao;
import dao.EventDao;
import dao.UserDao;

/**
 * Created by iliesalinadenisa on 29/05/2017.
 */
public class main {
    public static void main(String[] args) {
        View view = new View();
        ActivityDao activityDao = new ActivityDao();
        EventDao eventDao = new EventDao();
        UserDao userDao = new UserDao();
        Controller controller = new Controller(view,activityDao,eventDao,userDao);
    }
}
