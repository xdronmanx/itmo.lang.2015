import javax.swing.*;

public class Controller {

    private final Player computer = new RandomPlayer(Cell.Type.X);

    private final Field field;

    public Controller(Field field) {
        this.field = field;
    }

    public void addO(int x, int y) {
        field.setSymbol(Cell.Type.O, x, y);


        if (field.isWinner(new Cell(x, y, Cell.Type.O))) {
            JOptionPane.showMessageDialog(null, "Вы победили");
            return;
        }

        Cell cell = computer.getTurn(field);

        if (field.isWinner(cell)) {
            JOptionPane.showMessageDialog(null, "Победил: " + computer.getPlayerName());
        }
    }

}