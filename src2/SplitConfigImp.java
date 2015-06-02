/**
 * Created by Андрей on 24.05.2015.
 */
public class SplitConfigImp implements SplitConfig {
    public String sourceFile;
    public String oddLinesFile;
    public String evenLinesFile;

    public SplitConfigImp(String sourceFile, String oddLinesFile, String evenLinesFile) {
        this.sourceFile = sourceFile;
        this.oddLinesFile = oddLinesFile;
        this.evenLinesFile = evenLinesFile;
    }

    public String getSourceFilePath() {
        return this.sourceFile;
    }

    public String getOddLinesFilePath() {
        return this.oddLinesFile;
    }

    public String getEvenLinesFilePath() {
        return this.evenLinesFile;
    }
}