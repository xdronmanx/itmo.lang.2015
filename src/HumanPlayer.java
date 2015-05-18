/**
 * Created by Андрей on 27.02.2015.
 */

import java.util.Scanner;

public class HumanPlayer implements Player {
    public String playerName = "HumanPlayer";
    Cell.Type playerType;

    HumanPlayer(Cell.Type type) {
        playerType = type;
    }

    public Cell.Type getType() {
        return playerType;
    }

    public String getPlayerName() {
        return "HumanPlayer";
    }

    public Cell getTurn(Field field) {
        Scanner sc = new Scanner(System.in);
        int i;
        int j;
        int size = field.size();

        System.out.println("Введите координату по горизонтали");
        i = sc.nextInt();
        System.out.println("Введите координату по вертикали");
        j = sc.nextInt();
        while (i < 0 || i > size || j < 0 || j > size) {
            System.out.println("Неверная координата, попробуйте еще раз!");
            System.out.println("Введите координату по горизонтали");
            i = sc.nextInt();
            System.out.println("Введите координату по вертикали");
            j = sc.nextInt();
        }

        while (field.getCellType(i, j) != Cell.Type.Null) {
            System.out.println("Ячейка занята, попробуйте еще раз!");
            System.out.println("Введите координату по горизонтали");
            i = sc.nextInt();
            System.out.println("Введите координату по вертикали");
            j = sc.nextInt();
        }
        if (field.getCellType(i, j) == Cell.Type.Null) {
            field.setSymbol(playerType, i, j);
        }
        return new Cell(i, j, playerType);
    }
}
