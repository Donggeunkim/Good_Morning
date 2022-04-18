package Good_Morning;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileIo {
    public static ArrayList<String> input_CmdList;
    public static String file_Name;

    public static ArrayList<String> ReadInputFile(String file_Path) throws IOException {

        try {
            File file_Object = new File(file_Path);
            file_Name = file_Object.getName();
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        // 경로 및 파일명 체크
        if (!IsValidFileName(file_Path)) return null;

        // 확장자 체크
        if(!CheckFileName(file_Name)) {
            System.out.println("ERROR :: File extension NOT 'TXT'");
            return null;
        }

        input_CmdList = (ArrayList<String>) Files.readAllLines(Paths.get(file_Path));
        return input_CmdList;
    }

    public static void WritePrint2File(String file_Path, ArrayList<String> output_Print_List) throws IOException {

        try {
            File file_Object = new File(file_Path);
            file_Name = file_Object.getName();
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        // 경로 및 파일명 체크
        if (!IsValidFileName(file_Path)) return;

        // 확장자 체크
        if(!CheckFileName(file_Name)) {
            System.out.println("ERROR :: File extension NOT 'TXT'");
            return;
        }

        FileWriter writer = new FileWriter(file_Path);
        for(String str: output_Print_List) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }

    public static boolean CheckFileName(String file_Name){
        String ext = file_Name.substring(file_Name.lastIndexOf(".") + 1);
        if (ext.equals("txt")) return true;
        return false;
    }

    private static boolean IsValidFileName(String file_Path) {
        //'/'와 '\' 이 두가지가 들어오면 안된다.
        for (int i = 0; i < file_Path.length(); i++) {
            if (file_Path.charAt(i) == '/') return false;
            if (file_Path.charAt(i) == '\\') return false;
        }
        //길이는 1 ~ 30 글자 까지 허용
        if (!(file_Path.length() >= 1 && file_Path.length() <= 30)) return false;
        //. [] () , 띄어쓰기, AZ, az, 0 9 까지 허용
        for (int i = 0; i < file_Path.length(); i++) {
            if (file_Path.charAt(i) == '.') continue;
            if (file_Path.charAt(i) == '[') continue;
            if (file_Path.charAt(i) == ']') continue;
            if (file_Path.charAt(i) == '(') continue;
            if (file_Path.charAt(i) == ')') continue;
            if (file_Path.charAt(i) == ' ') continue;
            if (file_Path.charAt(i) >= 'A' && file_Path.charAt(i) <= 'Z') continue;
            if (file_Path.charAt(i) >= 'a' && file_Path.charAt(i) <= 'z') continue;
            if (file_Path.charAt(i) >= '0' && file_Path.charAt(i) <= '9') continue;
            return false;
        }
        return true;
    }
}
