/**
 * Created by Андрей on 19.05.2015.
 */
import java.io.IOException;
public interface FileSizeCalculator {
    long getSize(final String pathToDir, final String fileTemplate) throws IOException;
}
