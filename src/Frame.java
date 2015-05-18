import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Frame extends JFrame implements Model {
    private Field field;
    private JButton[][] buttons;

    public Frame(final Field field) {
        super("Kvadratura");
        final Controller controller = new Controller(field);

        this.field = field;
        this.field.addObserver(this);

        JPanel panel = new JPanel();

        final int width = field.size();
        final int height = field.size();

        buttons = new JButton[width][height];

        panel.setLayout(new GridLayout(width, height, 2, 2));

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Cell.Type playerType = field.getCellType(i, j);
                final String string = (playerType == Cell.Type.Null) ? " " : playerType.toString();

                JButton button = new JButton(string);

                final int x = i;
                final int y = j;

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        controller.addO(x, y);

                    }
                });
                panel.add(button);

                buttons[i][j] = button;
            }
        }
        setContentPane(panel);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
    public void gameChanged() {
        final int width = field.size();
        final int height = field.size();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {

                Cell.Type playerType = field.getCellType(i, j);
                final String s = (playerType == Cell.Type.Null) ? " " : playerType.toString();

                buttons[i][j].setText(s);

            }
        }
    }
}


