package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by iliesalinadenisa on 28/05/2017.
 */
public class View extends JFrame{

    private JFrame frame = new JFrame();
    private JPanel panel;
    private JButton joinEventButton;
    private JButton leftEventButton;
    JButton createProfileButton;
     JButton updateProfileButton;
    JButton deleteProfileButton;
     JButton viewEventsButton;
    JButton viewAttendaceListButton;
    private JButton viewFreePlacesButton;
    private JButton createEventButton;
    private JButton updateEventButton;
    private JButton deleteEventButton;

    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField emailTextField;
    private JTextField roleUserField;

    private JTextField titleActivityTextField;
    private JTextField descriptionTextField;

    private JTextField idEventTextField;
    private JTextField titleEventTextField;
    private JTextField descriptionEventTextField;
    private JTextField startDateTextField;
    private JTextField endDateTextField;
    private JTextField maxRegTextField;
    private JTextField activityIdTextField;
    private JTextField personIdTextField;
    private JTextField locationIdTextField;

    private JTextArea textArea;

    public View() {
        initComponents();
    }
    private void initComponents() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Sports Managment");
        frame.setSize(8000, 6000);
        frame.setResizable(false);
        frame.setVisible(true);
        panel = new JPanel();
        frame.add(panel);
        panel.setVisible(true);
        panel.setLayout(null);
        Image img;

        JLabel personLabel = new JLabel("Persons");
        JLabel firstNameLabel = new JLabel("First Name");
        JLabel lastNameLabel = new JLabel("Last name");
        JLabel emailLabel = new JLabel("Email");
        JLabel roleUserLabel = new JLabel("Role");

        panel.add(personLabel);
        panel.add(firstNameLabel);
        panel.add(lastNameLabel);
        panel.add(emailLabel);
        panel.add(roleUserLabel);

        personLabel.setBounds(150, 50, 180, 50);
        firstNameLabel.setBounds(50, 100, 150, 30);
        lastNameLabel.setBounds(50, 150, 150, 30);
        emailLabel.setBounds(50, 200, 150, 30);
        roleUserLabel.setBounds(50, 250, 150, 30);

        JLabel activityLabel = new JLabel("Activity");
        JLabel titleActiviyLabel = new JLabel("Title");
        JLabel descriptionActivityLabel = new JLabel("Description");

        panel.add(activityLabel);
        panel.add(titleActiviyLabel);
        panel.add(descriptionActivityLabel);

        activityLabel.setBounds(550, 50, 200, 70);
        activityLabel.setBackground(Color.RED);
        titleActiviyLabel.setBounds(500, 100, 150, 30);
        descriptionActivityLabel.setBounds(500, 150, 150, 30);

        JLabel eventLabel = new JLabel("Event");
        JLabel titleEventLabel = new JLabel("Title");
        JLabel descriptionEventLabel = new JLabel("Description");
        JLabel startDateLabel = new JLabel("Start date");
        JLabel endDateLabel = new JLabel("End date");
        JLabel maxRegLabel = new JLabel("Max Registration");
        JLabel activityIdLabel = new JLabel("Activity Id");
        JLabel personIdLabel = new JLabel("Person Id");
        JLabel locationIdLabel = new JLabel("Location Id");

        panel.add(eventLabel);
        panel.add(titleEventLabel);
        panel.add(descriptionEventLabel);
        panel.add(startDateLabel);
        panel.add(endDateLabel);
        panel.add(maxRegLabel);
        panel.add(activityIdLabel);
        panel.add(personIdLabel);
        panel.add(locationIdLabel);

        eventLabel.setBounds(900, 50, 180, 50);
        titleEventLabel.setBounds(900, 100, 150, 30);
        descriptionEventLabel.setBounds(900, 150, 150, 30);
        startDateLabel.setBounds(900, 200, 180, 50);
        endDateLabel.setBounds(900, 250, 150, 30);
        maxRegLabel.setBounds(900, 300, 150, 30);
        activityIdLabel.setBounds(900, 350, 180, 50);
        personIdLabel.setBounds(900, 400, 150, 30);
        locationIdLabel.setBounds(900, 450, 150, 30);

        joinEventButton = new JButton("Create User");
        leftEventButton = new JButton("Update User");
        createProfileButton = new JButton("Add profile(person) ");
        updateProfileButton = new JButton("Update profile");
        deleteProfileButton = new JButton("Delete profile");
        viewEventsButton = new JButton("View events");
        viewAttendaceListButton = new JButton("View attendance list");
        viewFreePlacesButton = new JButton("View free places");
        createEventButton = new JButton("Create Event");
        updateEventButton = new JButton("Update Event");
        deleteEventButton = new JButton("Delete Event");

        createProfileButton.setBounds(50, 400, 150, 30);
        updateProfileButton.setBounds(50, 450, 150, 30);
        deleteProfileButton.setBounds(50, 500, 150, 30);

        panel.add(createProfileButton);
        panel.add(updateProfileButton);
        panel.add(deleteProfileButton);

        viewEventsButton.setBounds(220, 400, 150, 30);
        viewAttendaceListButton.setBounds(220, 450, 150, 30);
        viewFreePlacesButton.setBounds(220, 500, 150, 30);

        panel.add(viewEventsButton);
        panel.add(viewAttendaceListButton);
        panel.add(viewFreePlacesButton);

        createEventButton.setBounds(390, 400, 150, 30);
        updateEventButton.setBounds(390, 450, 150, 30);
        deleteEventButton.setBounds(390, 500, 150, 30);

        panel.add(createEventButton);
        panel.add(updateEventButton);
        panel.add(deleteEventButton);

        firstNameTextField = new JTextField();
        lastNameTextField = new JTextField();
        emailTextField = new JTextField();
        roleUserField = new JTextField();

        firstNameTextField.setBounds(200, 100, 150, 30);
        lastNameTextField.setBounds(200, 150, 150, 30);
        emailTextField.setBounds(200, 200, 150, 30);
        roleUserField.setBounds(200, 250, 150, 30);

        panel.add(firstNameTextField);
        panel.add(lastNameTextField);
        panel.add(emailTextField);
        panel.add(roleUserField);

        titleActivityTextField = new JTextField();
        descriptionTextField = new JTextField();

        titleActivityTextField.setBounds(600, 100, 150, 30);
        descriptionTextField.setBounds(600, 150, 150, 30);

        panel.add(titleActivityTextField);
        panel.add(descriptionTextField);

        idEventTextField = new JTextField();
        titleEventTextField = new JTextField();
        descriptionEventTextField = new JTextField();
        startDateTextField = new JTextField();
        endDateTextField = new JTextField();
        maxRegTextField = new JTextField();
        activityIdTextField = new JTextField();
        personIdTextField = new JTextField();
        locationIdTextField = new JTextField();


        titleEventTextField.setBounds(1100, 100, 150, 30);
        descriptionEventTextField.setBounds(1100, 150, 150, 30);
        startDateTextField.setBounds(1100, 200, 150, 30);
        endDateTextField.setBounds(1100, 250, 150, 30);
        maxRegTextField.setBounds(1100, 300, 150, 30);
        activityIdTextField.setBounds(1100, 350, 150, 30);
        personIdTextField.setBounds(1100, 400, 150, 30);
        locationIdTextField.setBounds(1100, 450, 150, 30);

        panel.add(titleEventTextField);
        panel.add(descriptionEventTextField);
        panel.add(startDateTextField);
        panel.add(endDateTextField);
        panel.add(maxRegTextField);
        panel.add(activityIdTextField);
        panel.add(personIdTextField);
        panel.add(locationIdTextField);

        textArea = new JTextArea(5,20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(textArea);
        panel.add(scrollPane);

        textArea.setVisible(true);
        textArea.setBounds(300,600,700,100);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void addCreateProfileListener(ActionListener a) {
        createProfileButton.addActionListener(a);
    }
    public void addUpdateProfileListener(ActionListener a) {
        updateProfileButton.addActionListener(a);
    }
    public void addDeleteProfileListener(ActionListener a) {
        deleteProfileButton.addActionListener(a);
    }

    public void addViewEventsListener(ActionListener a) {
        viewEventsButton.addActionListener(a);
    }

    public void addViewAttendanceListListener(ActionListener a) {
        viewAttendaceListButton.addActionListener(a);
    }

    public void addViewFreePlacesListener(ActionListener a) {
        viewFreePlacesButton.addActionListener(a);
    }

    public void addCreateEventListener(ActionListener a) {
        createEventButton.addActionListener(a);
    }

    public void addUpdateEventListener(ActionListener a) {
        updateEventButton.addActionListener(a);
    }
    public void addDeleteEventListener(ActionListener a) {
        deleteEventButton.addActionListener(a);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JButton getJoinEventButton() {
        return joinEventButton;
    }

    public void setJoinEventButton(JButton joinEventButton) {
        this.joinEventButton = joinEventButton;
    }

    public JButton getLeftEventButton() {
        return leftEventButton;
    }

    public void setLeftEventButton(JButton leftEventButton) {
        this.leftEventButton = leftEventButton;
    }

    public JButton getCreateProfileButton() {
        return createProfileButton;
    }

    public void setCreateProfileButton(JButton createProfileButton) {
        this.createProfileButton = createProfileButton;
    }

    public JButton getUpdateProfileButton() {
        return updateProfileButton;
    }

    public void setUpdateProfileButton(JButton updateProfileButton) {
        this.updateProfileButton = updateProfileButton;
    }

    public JButton getDeleteProfileButton() {
        return deleteProfileButton;
    }

    public void setDeleteProfileButton(JButton deleteProfileButton) {
        this.deleteProfileButton = deleteProfileButton;
    }

    public JButton getViewEventsButton() {
        return viewEventsButton;
    }

    public void setViewEventsButton(JButton viewEventsButton) {
        this.viewEventsButton = viewEventsButton;
    }

    public JButton getViewAttendaceListButton() {
        return viewAttendaceListButton;
    }

    public void setViewAttendaceListButton(JButton viewAttendaceListButton) {
        this.viewAttendaceListButton = viewAttendaceListButton;
    }

    public JButton getViewFreePlacesButton() {
        return viewFreePlacesButton;
    }

    public void setViewFreePlacesButton(JButton viewFreePlacesButton) {
        this.viewFreePlacesButton = viewFreePlacesButton;
    }

    public JButton getCreateEventButton() {
        return createEventButton;
    }

    public void setCreateEventButton(JButton createEventButton) {
        this.createEventButton = createEventButton;
    }

    public JButton getUpdateEventButton() {
        return updateEventButton;
    }

    public void setUpdateEventButton(JButton updateEventButton) {
        this.updateEventButton = updateEventButton;
    }

    public JButton getDeleteEventButton() {
        return deleteEventButton;
    }

    public void setDeleteEventButton(JButton deleteEventButton) {
        this.deleteEventButton = deleteEventButton;
    }

    public JTextField getFirstNameTextField() {
        return firstNameTextField;
    }

    public void setFirstNameTextField(JTextField firstNameTextField) {
        this.firstNameTextField = firstNameTextField;
    }

    public JTextField getLastNameTextField() {
        return lastNameTextField;
    }

    public void setLastNameTextField(JTextField lastNameTextField) {
        this.lastNameTextField = lastNameTextField;
    }

    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public void setEmailTextField(JTextField emailTextField) {
        this.emailTextField = emailTextField;
    }

    public JTextField getRoleUserField() {
        return roleUserField;
    }

    public void setRoleUserField(JTextField roleUserField) {
        this.roleUserField = roleUserField;
    }

    public JTextField getTitleActivityTextField() {
        return titleActivityTextField;
    }

    public void setTitleActivityTextField(JTextField titleActivityTextField) {
        this.titleActivityTextField = titleActivityTextField;
    }

    public JTextField getDescriptionTextField() {
        return descriptionTextField;
    }

    public void setDescriptionTextField(JTextField descriptionTextField) {
        this.descriptionTextField = descriptionTextField;
    }

    public JTextField getIdEventTextField() {
        return idEventTextField;
    }

    public void setIdEventTextField(JTextField idEventTextField) {
        this.idEventTextField = idEventTextField;
    }

    public JTextField getTitleEventTextField() {
        return titleEventTextField;
    }

    public void setTitleEventTextField(JTextField titleEventTextField) {
        this.titleEventTextField = titleEventTextField;
    }

    public JTextField getDescriptionEventTextField() {
        return descriptionEventTextField;
    }

    public void setDescriptionEventTextField(JTextField descriptionEventTextField) {
        this.descriptionEventTextField = descriptionEventTextField;
    }

    public JTextField getStartDateTextField() {
        return startDateTextField;
    }

    public void setStartDateTextField(JTextField startDateTextField) {
        this.startDateTextField = startDateTextField;
    }

    public JTextField getEndDateTextField() {
        return endDateTextField;
    }

    public void setEndDateTextField(JTextField endDateTextField) {
        this.endDateTextField = endDateTextField;
    }

    public JTextField getMaxRegTextField() {
        return maxRegTextField;
    }

    public void setMaxRegTextField(JTextField maxRegTextField) {
        this.maxRegTextField = maxRegTextField;
    }

    public JTextField getActivityIdTextField() {
        return activityIdTextField;
    }

    public void setActivityIdTextField(JTextField activityIdTextField) {
        this.activityIdTextField = activityIdTextField;
    }

    public JTextField getPersonIdTextField() {
        return personIdTextField;
    }

    public void setPersonIdTextField(JTextField personIdTextField) {
        this.personIdTextField = personIdTextField;
    }

    public JTextField getLocationIdTextField() {
        return locationIdTextField;
    }

    public void setLocationIdTextField(JTextField locationIdTextField) {
        this.locationIdTextField = locationIdTextField;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }
}
