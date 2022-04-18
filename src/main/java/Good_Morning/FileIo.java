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

        try {
            File fileObject = new File(filePath);
            fileName = fileObject.getName();
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        // 경로 및 파일명 체크
        if (!isValidFileName(filePath)) return null;

        // 확장자 체크
        if(!checkFileName(fileName)) {
            System.out.println("ERROR :: File extension NOT 'TXT'");
            return null;
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

        // 경로 및 파일명 체크
        if (!isValidFileName(filePath)) return;

        // 확장자 체크
        if(!checkFileName(fileName)) {
            System.out.println("ERROR :: File extension NOT 'TXT'");
            return;
        }

        FileWriter writer = new FileWriter(filePath);
        for(String str: outputPrintList) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }

    public static boolean checkFileName(String fileName){
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (ext.equals("txt")) return true;
        return false;
    }

    public static boolean isValidFileName(String filePath) {
        //'/'와 '\' 이 두가지가 들어오면 안된다.
        for (int i = 0; i < filePath.length(); i++) {
            if (filePath.charAt(i) == '/') return false;
            if (filePath.charAt(i) == '\\') return false;
        }
        //길이는 1 ~ 30 글자 까지 허용
        if (!(filePath.length() >= 1 && filePath.length() <= 30)) return false;
        //. [] () , 띄어쓰기, AZ, az, 0 9 까지 허용
        for (int i = 0; i < filePath.length(); i++) {
            if (filePath.charAt(i) == '.') continue;
            if (filePath.charAt(i) == '[') continue;
            if (filePath.charAt(i) == ']') continue;
            if (filePath.charAt(i) == '(') continue;
            if (filePath.charAt(i) == ')') continue;
            if (filePath.charAt(i) == ' ') continue;
            if (filePath.charAt(i) == '_') continue;
            if (filePath.charAt(i) >= 'A' && filePath.charAt(i) <= 'Z') continue;
            if (filePath.charAt(i) >= 'a' && filePath.charAt(i) <= 'z') continue;
            if (filePath.charAt(i) >= '0' && filePath.charAt(i) <= '9') continue;
            return false;
        }
        return true;
    }
}
