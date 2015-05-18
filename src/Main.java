

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {
    public static void main(String[] args) {


        Field field = new Field(10);

        Frame app = new Frame(field);
        app.setVisible(true);


    }
}