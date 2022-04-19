package Good_Morning;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        if (args.length !=2) {
            System.out.println("Please input and output file path...");
            System.out.println("Example: java -jar Good_Morning.jar input.txt output.txt");
            return;
        }

        ArrayList<String> outputStingList = new ArrayList<>();
        String inputFilePath = args[0];
        String outputFilePath = args[1];
        
        ArrayList<String> commandLines = FileIo.readInputFile(inputFilePath);

        EmployeeHandler employeeHandler = new EmployeeHandler();
        Parser parser = new Parser();
        for(String commandLine : commandLines) {
            parser.splitCommnadLine(commandLine);

            // main에서 처리?
            switch (parser.getCommand()){
                case "ADD":
                    employeeHandler.addEmployee(parser.getOptions(), parser.getValues());
                    break;
                case "SCH":
                    outputStingList.add(employeeHandler.searchEmployee(parser.getOptions(), parser.getValues()));
                    break;
                case "DEL":
                    outputStingList.add(employeeHandler.deleteEmployee(parser.getOptions(), parser.getValues()));
                    break;
                case "MOD":
                    outputStingList.add(employeeHandler.modifyEmployee(parser.getOptions(), parser.getValues()));
                    break;
                default :
                    break;
            }
        }
        FileIo.writePrint2File(outputFilePath, outputStingList);

    }
}

