import java.util.ArrayList;
import java.util.List;

public class Field {

    private int n;
    private Cell.Type[][] field;

    private List<Model> observers = new ArrayList<Model>();

    public Field(int n) {
        this.n = n;
        field = new Cell.Type[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                field[i][j] = Cell.Type.Null;
            }
        }
    }

    public void setSymbol(Cell.Type playerType, int i, int j) {
        field[i][j] = playerType;
        notifyObservers();
    }


    public int size() {
        return n;
    }

    void setCell(Cell cell) {
        field[cell.i][cell.j] = cell.type;
    }

    public Cell.Type getCellType(int i, int j) {
        return field[i][j];
    }

    boolean isWinner(Cell cell) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (((((i - cell.i) * (j - cell.j)) <= 0) && (cell.i - Math.abs(cell.j - j) >= 0) && (cell.i - Math.abs(cell.j - j) < 10) && (cell.j - Math.abs(cell.i - i) >= 0) && (cell.j - Math.abs(cell.i - i) < 10) && (i - Math.abs(cell.j - j) >= 0) && (i - Math.abs(cell.j - j) < 10) && (j - Math.abs(cell.i - i) >= 0) && (j - Math.abs(cell.i - i) < 10) && (field[i - Math.abs(cell.j - j)][j - Math.abs(cell.i - i)] == cell.type) && (field[cell.i - Math.abs(cell.j - j)][cell.j - Math.abs(cell.i - i)] == cell.type) && (field[i][j] == cell.type) && ((cell.j != j) || (cell.i != i)))
                        || ((((i - cell.i) * (j - cell.j)) <= 0) && (cell.i + Math.abs(cell.j - j) >= 0) && (cell.i + Math.abs(cell.j - j) < 10) && (cell.j + Math.abs(cell.i - i) >= 0) && (cell.j + Math.abs(cell.i - i) < 10) && (i + Math.abs(cell.j - j) >= 0) && (i + Math.abs(cell.j - j) < 10) && (j + Math.abs(cell.i - i) >= 0) && (j + Math.abs(cell.i - i) < 10) && (field[i + Math.abs(cell.j - j)][j + Math.abs(cell.i - i)] == cell.type) && (field[cell.i + Math.abs(cell.j - j)][cell.j + Math.abs(cell.i - i)] == cell.type) && (field[i][j] == cell.type) && ((cell.j != j) || (cell.i != i)))
                        || ((((i - cell.i) * (j - cell.j)) >= 0) && (cell.i - Math.abs(cell.j - j) >= 0) && (cell.i - Math.abs(cell.j - j) < 10) && (cell.j + Math.abs(cell.i - i) >= 0) && (cell.j + Math.abs(cell.i - i) < 10) && (i - Math.abs(cell.j - j) >= 0) && (i - Math.abs(cell.j - j) < 10) && (j + Math.abs(cell.i - i) >= 0) && (j + Math.abs(cell.i - i) < 10) && (field[i - Math.abs(cell.j - j)][j + Math.abs(cell.i - i)] == cell.type) && (field[cell.i - Math.abs(cell.j - j)][cell.j + Math.abs(cell.i - i)] == cell.type) && (field[i][j] == cell.type) && ((cell.j != j) || (cell.i != i)))
                        || ((((i - cell.i) * (j - cell.j)) >= 0) && (cell.i + Math.abs(cell.j - j) >= 0) && (cell.i + Math.abs(cell.j - j) < 10) && (cell.j - Math.abs(cell.i - i) >= 0) && (cell.j - Math.abs(cell.i - i) < 10) && (i + Math.abs(cell.j - j) >= 0) && (i + Math.abs(cell.j - j) < 10) && (j - Math.abs(cell.i - i) >= 0) && (j - Math.abs(cell.i - i) < 10) && (field[i + Math.abs(cell.j - j)][j - Math.abs(cell.i - i)] == cell.type) && (field[cell.i + Math.abs(cell.j - j)][cell.j - Math.abs(cell.i - i)] == cell.type) && (field[i][j] == cell.type) && ((cell.j != j) || (cell.i != i)))) {
                    return true;
                }

            }
        }

        return false;
    }


    boolean isFieldFilled() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (field[i][j] == Cell.Type.Null) {
                    return false;
                }
            }
        }

        return true;
    }

    void printField() {
        System.out.print("# ");
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < n; j++) {
                char c = '.';
                if (field[i][j] == Cell.Type.X)
                    c = 'X';
                else if (field[i][j] == Cell.Type.O)
                    c = 'O';

                System.out.print(c + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    private void notifyObservers() {
        for (final Model observer : observers) {
            observer.gameChanged();
        }
    }

    public void addObserver(final Model observer) {
        observers.add(observer);
    }


}
