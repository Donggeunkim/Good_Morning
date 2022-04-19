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

        ArrayList<String> outputStringList = new ArrayList<>();
        String inputFilePath = args[0];
        String outputFilePath = args[1];
        
        ArrayList<String> commandLines = FileIo.readInputFile(inputFilePath);

        EmployeeHandler employeeHandler = new EmployeeHandler();
        Parser parser = new Parser();

        for(String commandLine : commandLines) {
            parser.splitCommandLine(commandLine);
            String result = parser.executeJob(employeeHandler);
            if (result != null)
                outputStringList.add(result);
        }

        FileIo.writePrint2File(outputFilePath, outputStringList);

    }
}

