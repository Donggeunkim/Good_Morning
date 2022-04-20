package Good_Morning;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileIo {
    public static ArrayList<String> inputCmdList;
    public static String fileName;

    public static ArrayList<String> readInputFile(String filePath) throws IOException {
        inputCmdList = new ArrayList<>();
        try {
            File fileObject = new File(filePath);
            fileName = fileObject.getName();
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        if (!isValidFileName(filePath)) return inputCmdList;

        if(!checkFileName(fileName)) {
            System.out.println("ERROR :: File extension NOT 'TXT'");
            return inputCmdList;
        }

        inputCmdList = (ArrayList<String>) Files.readAllLines(Paths.get(filePath));
        return inputCmdList;
    }

    public static void writePrint2File(String filePath, ArrayList<String> outputPrintList) throws IOException {

        try {
            File fileObject = new File(filePath);
            fileName = fileObject.getName();
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        if (!isValidFileName(filePath)) return;

        if(!checkFileName(fileName)) {
            System.out.println("ERROR :: File extension NOT 'TXT'");
            return;
        }

        FileWriter writer = new FileWriter(filePath);
        for(String str: outputPrintList) {
            writer.write(removeEnter(str) + System.lineSeparator());
        }
        writer.close();
    }

    public static boolean checkFileName(String fileName){
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        return ext.equals("txt");
    }

    public static boolean isValidFileName(String filePath) {
        for (int i = 0; i < filePath.length(); i++) {
            if (filePath.charAt(i) == '/') return false;
            if (filePath.charAt(i) == '\\') return false;
        }
        if (!(filePath.length() >= 1 && filePath.length() <= 30)) return false;

        String pattern = "[a-zA-Z0-9 ._\\[\\]\\(\\)]";
        for (int i = 0; i < filePath.length(); i++) {
            if(String.valueOf(filePath.charAt(i)).matches(pattern)) continue;
            return false;
        }
        return true;
    }

    private static String removeEnter(String str) {
        if (str.endsWith("\n")) {
            return str.substring(0, str.length() - 1);
        }
        return str;
    }
}
