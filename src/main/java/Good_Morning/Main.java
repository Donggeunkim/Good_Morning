package Good_Morning;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[ ] args) throws IOException {
        String file_path = "input.txt";
        File_IO file_io = new File_IO();
        ArrayList<String> command_lines = file_io.readInputFile(file_path);

        EmployeeHandler employee_handler = new EmployeeHandler();
        Parser parser = new Parser();
        for(String command_line : command_lines) {
            parser.SplitCommnadLine(command_line);

            // main에서 처리?
            switch (parser.GetCommand()){
                case "ADD":
                    employee_handler.AddEmployee(parser.GetOptions(), parser.GetValues());
                    break;
                case "SCH":
                    employee_handler.SearchEmployee(parser.GetOptions(), parser.GetValues());
                    employee_handler.PrintEmployee(parser.GetCommand(), parser.GetOptions(), parser.GetValues());
                    break;
                case "DEL":
                    employee_handler.DeleteEmployee(parser.GetOptions(), parser.GetValues());
                    break;
                case "MOD":
                    employee_handler.ModifyEmployee(parser.GetOptions(), parser.GetValues());
                    break;
                default :
                    break;
            }
        }

    }
}
