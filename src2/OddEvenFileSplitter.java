/**
 * Created by Андрей on 24.05.2015.
 */
import java.io.*;

public class OddEvenFileSplitter implements FileSplitter {
    public OddEvenFileSplitter() {
    }

    public void splitFile(SplitConfig config) {
        String sourceFileName = config.getSourceFilePath();
        String oddLinesFileName = config.getOddLinesFilePath();
        String evenLinesFileName = config.getEvenLinesFilePath();

        try {
            FileReader sourceFileReader = new FileReader(sourceFileName);
            LineNumberReader sourceLineNumberReader = new LineNumberReader(sourceFileReader);
            FileWriter oddLinesFileWriter = new FileWriter(oddLinesFileName);
            BufferedWriter oddLinesBufferedWriter = new BufferedWriter(oddLinesFileWriter );
            FileWriter evenLinesFileWriter = new FileWriter(evenLinesFileName);
            BufferedWriter evenLinesBufferedWriter = new BufferedWriter(evenLinesFileWriter);

            String line;
            while ((line = sourceLineNumberReader.readLine()) != null) {
                if (sourceLineNumberReader.getLineNumber() % 2 == 1) {
                    oddLinesBufferedWriter.write(line);
                    oddLinesBufferedWriter.newLine();
                } else {
                    evenLinesBufferedWriter .write(line);
                    evenLinesBufferedWriter .newLine();
                }
            }

            sourceLineNumberReader.close();
            oddLinesBufferedWriter.close();
            evenLinesBufferedWriter .close();
        } catch (FileNotFoundException exc) {
            System.out.println("Не удается найти данный файл");
        } catch (IOException exc) {
            System.out.println("Error");
        }

    }



    public static void main(String[] args) {
    String sourceFile = args[0];
    String oddLinesFile = args[1];
    String evenLinesFile = args[2];
    OddEvenFileSplitter new1 = new OddEvenFileSplitter();
    SplitConfigImp configImp1 = new SplitConfigImp(sourceFile, oddLinesFile, evenLinesFile);
    new1.splitFile(configImp1);
}
}