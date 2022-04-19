package Good_Morning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

public class DelCommandTest {
    EmployeeHandler employeeHandler;
    ArrayList<String> option1;
    ArrayList<String> parameter1;
    @BeforeEach
    void setup() {
        employeeHandler = new EmployeeHandler();

        option1 = new ArrayList<>();
        option1.add(" ");
        option1.add(" ");
        option1.add(" ");

        parameter1 = new ArrayList<>();
        parameter1.add("14016092");
        parameter1.add("KIM MINHWAN");
        parameter1.add("CL3");
        parameter1.add("010-2802-9011");
        parameter1.add("19900109");
        parameter1.add("PRO");
    }

    @Test
    void delFuncTest(){
        employeeHandler.addEmployee(option1, parameter1);

        ArrayList<String> schItem = new ArrayList<>();
        schItem.add("employeeNum");
        schItem.add("14016092");

        employeeHandler.deleteEmployee(option1, schItem);

        assertEquals(0, employeeHandler.employee.size());
    }

    @Test
    void delClSearchTest() throws IOException {

        String filePath = "input4Add.txt";
        ArrayList<String> commandLines = FileIo.readInputFile(filePath);

        ArrayList<String> outputStringList = new ArrayList<>();
        Parser parser = new Parser();

        for(String commandLine : commandLines) {
            parser.splitCommandLine(commandLine);
            String result = parser.executeJob(employeeHandler);
            if (result != null)
                outputStringList.add(result);
        }

        ArrayList<String> schItem = new ArrayList<>();
        schItem.add("cl");
        schItem.add("CL2");

        employeeHandler.deleteEmployee(option1, schItem);

        assertEquals(66220, employeeHandler.employee.size());
    }


}
