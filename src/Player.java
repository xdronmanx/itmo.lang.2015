/**
 * Created by Андрей on 27.02.2015.
 */
public interface Player {
    public Cell getTurn(Field field);

    public Cell.Type getType();

    public String getPlayerName();
}
