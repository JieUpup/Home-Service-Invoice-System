/*

1.show quote price window: add tittle,window add other service quote price.
2.


 */


package service.view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ColorModel;

public class BasicView extends JPanel {
    public static final int WIDTH = 900;
    public static final int HEIGHT = 600;
    public static int PAGE_EXISTS;
    public static int NO_SUCH_PAGE;
    public static final Color COLOR_BACKGROUND= new Color(160, 133, 0, 139);
    public static final Color COLOR_WINDOW = new Color(255, 255, 255, 178);
    public static final Color COLOR_BUTTON = new Color(45, 47, 60,50);
    public static final Color COLOR_TEXT_FIELD = new Color(241, 255, 50, 48);



    public BasicView() {

        setSize(WIDTH, HEIGHT);
        setBackground(COLOR_BACKGROUND);

    }


    public JPanel getView() {
        return this;
    }

}
