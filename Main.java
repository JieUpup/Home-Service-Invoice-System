package service.view;

import javax.swing.*;

public class Main {
    public static LoginWindow loginView = new LoginWindow();

    public static ServiceInformationWindow serviceView = new ServiceInformationWindow();
    public static ShowQuotePriceForEachService feeView = new ShowQuotePriceForEachService();

    public static JFrame window = new JFrame();
    public static void main(String[] args) {
        window.setSize(BasicView.WIDTH, BasicView.HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        window.add(loginView.getView());
        window.setTitle("User Login Window");
        loginView.setVisible(true);


        window.setVisible(true);
    }
}
