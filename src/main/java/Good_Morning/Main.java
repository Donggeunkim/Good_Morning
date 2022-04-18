package Good_Morning;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[ ] args) throws IOException {
        String filePath = "input.txt";
        FileIo fileIo = new FileIo();
        ArrayList<String> commandLines = fileIo.readInputFile(filePath);

        employeeHandler employeeHandler = new employeeHandler();
        Parser parser = new Parser();
        for(String commandLine : commandLines) {
            parser.splitCommnadLine(commandLine);

            // main에서 처리?
            switch (parser.getCommand()){
                case "ADD":
                    employeeHandler.addEmployee(parser.getOptions(), parser.getValues());
                    break;
                case "SCH":
                    employeeHandler.searchEmployee(parser.getOptions(), parser.getValues());
                    employeeHandler.printEmployee(parser.getCommand(), parser.getOptions(), parser.getValues());
                    break;
                case "DEL":
                    employeeHandler.deleteEmployee(parser.getOptions(), parser.getValues());
                    break;
                case "MOD":
                    employeeHandler.modifyEmployee(parser.getOptions(), parser.getValues());
                    break;
                default :
                    break;
            }
        }

    }
}

