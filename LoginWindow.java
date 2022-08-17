package service.view;

import utils.SpringUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


public class LoginWindow extends BasicView {
    private JTextField userNameTextField;
    private JTextField passwordTextField;


    private static final String[] LOGIN_LABLES = {"UserId", "Password"};

    private HashMap<String, String> userDB = new HashMap<>();

    public void loadUserData() {
        File inputFile = new File("src/Service/UserLoginNameAndPassword");
        Scanner sc = null;
        try {
            sc = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String firstLine = sc.nextLine();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] arr = line.split(",");
            userDB.put(arr[0], arr[1]);
        }
    }


    public JPanel getLoginPanel() {
        int numPairs = LOGIN_LABLES.length;
        JTextField [] textFields = new JTextField[numPairs];
        JPanel loginPanel = new JPanel(new SpringLayout());


        for (int i = 0; i < numPairs; i ++) {
            JLabel label = new JLabel(LOGIN_LABLES[i], JLabel.TRAILING);
            loginPanel.add(label);

            JTextField textField = new JTextField(10);
            label.setLabelFor(textField);
            loginPanel.add(textField);
            loginPanel.setBackground(COLOR_BACKGROUND);

            textFields[i] = textField;
        }

        // set the instance var for input text field
        userNameTextField = textFields[0];
        passwordTextField = textFields[1];



        SpringUtilities.makeCompactGrid(loginPanel,
                numPairs, 2,
                6,6,
                6,6);

        return loginPanel;
    }

    @Override
    public JPanel getView() {
        setLayout(new BorderLayout());

        add(getLoginPanel(), BorderLayout.NORTH);
        add(getLoginButtonPanel(), BorderLayout.SOUTH);


        return this;
    }
    public LoginWindow() {
        setSize(WIDTH, HEIGHT);


        loadUserData();
        setBackground(COLOR_BACKGROUND);
    }

    private JButton getLoginButtonPanel() {
        JButton loginButton = new JButton("Login");
        loginButton.setSize(30, 10);
        loginButton.setBackground(COLOR_BUTTON);
        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = userNameTextField.getText();
                String password = passwordTextField.getText();
                passwordTextField.setBackground(Color.LIGHT_GRAY);
                userNameTextField.setBackground(Color.YELLOW);

                if (userDB.containsKey(userName)) {
                    String storedPasswd = userDB.get(userName);
                    if (storedPasswd.equals(password)) {
                        System.out.println("Login successfully");
                        Main.loginView.setVisible(false);

                        Main.window.add(Main.serviceView.getView());
                        Main.serviceView.setVisible(true);
                        Main.window.setTitle("Service Window");
                    } else {
                        System.out.println("UserName and password not match");
                        userNameTextField.setText("");
                        passwordTextField.setText("");

                    }
                } else {
                    System.out.println("UserName and password not match");
                    userNameTextField.setText("");
                    passwordTextField.setText("");
                }


            }
        });

        return loginButton;
    }
}