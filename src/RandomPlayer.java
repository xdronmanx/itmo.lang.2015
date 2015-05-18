/**
 * Created by Андрей on 27.02.2015.
 */

import java.util.Random;

public class RandomPlayer implements Player {
    public String playerName = "RandomPlayer";
    Cell.Type playerType;

    RandomPlayer(Cell.Type type) {
        playerType = type;
    }

    public Cell.Type getType() {
        return playerType;
    }

    public String getPlayerName() {
        return "RandomPlayer";
    }

    public Cell getTurn(Field field) {
        int size = field.size();

        Random random = new Random();
        int i;
        int j;

        while (true) {
            i = random.nextInt(size);
            j = random.nextInt(size);

            if (field.getCellType(i, j) == Cell.Type.Null) {
                field.setSymbol(playerType, i, j);
                return new Cell(i, j, playerType);
            }
        }
    }
}
