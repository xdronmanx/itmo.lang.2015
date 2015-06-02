/**
 * Created by Андрей on 25.05.2015.
 */
import java.io.*;
import java.util.*;
import java.util.regex.*;
class SimpleGrepUtility implements Grep {
    private String[] lines;

    public SimpleGrepUtility(final InputStream sourceFileInputStream) throws IOException {
        BufferedInputStream reader = new BufferedInputStream(sourceFileInputStream);
        int n;
        String s = "";
        while ((n = reader.read()) != -1) {
            s += (char) n;
        }
        this.lines = s.split("\\n");
        reader.close();
    }

    public List<String> findLines(String regex) throws IOException {
        List<String> result = new ArrayList<String>();
        Pattern finalRegex = Pattern.compile(regex);
        for (String line : lines) {
            Matcher matcher = finalRegex.matcher(line);
            if (matcher.find()) {
                result.add(line);
            }
        }
        return result;
    }

    @Override
    public List<String> findParts(String regex) throws IOException {
        List<String> result = new ArrayList<String>();
        Pattern finalRegex = Pattern.compile(regex);
        for (String line : lines) {
            Matcher matcher= finalRegex.matcher(line);
            if (matcher.find()) {
                result.add(matcher.group());
            }
        }
        return result;
    }

    @Override
    public List<String> findInvertMatch(String regex) throws IOException {
        List<String> result = new ArrayList<String>();
        Pattern finalRegex = Pattern.compile(".*" + regex + ".*");
        for (String line : lines) {
            Matcher matcher = finalRegex.matcher(line);
            if (!matcher.find()) {
                result.add(line);
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 3){
            String regex = args[1];
            InputStream sourceFile = new FileInputStream(args[2]);
            if (args[0].equals("-o")){
                System.out.println(new SimpleGrepUtility(sourceFile).findParts(regex));
            }else {
                System.out.println(new SimpleGrepUtility(sourceFile).findInvertMatch(regex));
            }
        }else {
            String regex = args[0];
            InputStream sourceFile = new FileInputStream(args[1]);
            System.out.println(new SimpleGrepUtility(sourceFile).findLines(regex));
        }
    }
}