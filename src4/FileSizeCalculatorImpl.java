
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileSizeCalculatorImpl implements FileSizeCalculator {
    private static String mask = null;
    private int size;
    int event = 0;

    public long getSize(String pathToDir, final String fileTemplate) throws IOException {
        mask = null;
        size = 0;
        final Path input = Paths.get(pathToDir);
        if (fileTemplate.startsWith("*") && (!fileTemplate.endsWith("*"))) {
            mask = fileTemplate.substring(1, fileTemplate.length());
            event = 1;
        } else if (fileTemplate.endsWith("*") && (!fileTemplate.startsWith("*"))) {
            mask = fileTemplate.substring(0, fileTemplate.lastIndexOf("*"));
            event = 2;
        } else if (fileTemplate.startsWith("*") && fileTemplate.endsWith("*")) {
            mask = fileTemplate.substring(1, fileTemplate.lastIndexOf("*"));
        }
        FileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
            public FileVisitResult visitFile(Path path, BasicFileAttributes attrs)
                    throws IOException {
                if (mask != null) {
                    if (event == 1){
                        if ((path.getFileName().toString()).endsWith(mask)) {
                            size += Files.size(path);
                        }
                    }else if (event == 2) {
                        if ((path.getFileName().toString()).startsWith(mask)) {
                            size += Files.size(path);
                        }
                    }
                    else{
                        if ((path.getFileName().toString()).contains(mask)) {
                            size += Files.size(path);
                        }
                    }
                } else {
                    if (fileTemplate.equals(path.getFileName().toString())) {
                        size += Files.size(path);
                    }
                }
                return FileVisitResult.CONTINUE;
            }
        };
        Files.walkFileTree(input, visitor);
        return size;
    }

    public static void main(String[] args) {
        String pathToDir = args[0];
        String fileTemplate = args[1];

        FileSizeCalculator newCalculator = new FileSizeCalculatorImpl();
        try {
            System.out.println(newCalculator.getSize(pathToDir, fileTemplate));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}