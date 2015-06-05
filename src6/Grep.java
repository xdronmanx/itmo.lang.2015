/**
 * Created by Андрей on 25.05.2015.
 */
import java.io.IOException;
import java.util.List;


public interface Grep {

    List<String> findLines(String regex) throws IOException;

    List<String> findParts(String regex) throws IOException;

    List<String> findInvertMatch(String regex) throws IOException;

}