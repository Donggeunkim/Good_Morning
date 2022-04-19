package Good_Morning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class AddCommandTest {
    EmployeeHandler employeeHandler;
    ArrayList<String> option1;
    ArrayList<String> parameter1;
    ArrayList<String> parameter2;

    @BeforeEach
    void setup() {
        employeeHandler = new EmployeeHandler();

        option1 = new ArrayList<>(Arrays.asList(" ", " ", " "));
        parameter1 = new ArrayList<>(Arrays.asList("14016092", "KIM MINHWAN", "CL3", "010-2802-9011", "19900109", "PRO"));
        parameter2 = new ArrayList<>(Arrays.asList("14016093", "KIM MINHWAN", "CL3", "010-2802-9011", "19900109", "PRO"));

    }

    @Test
    void addFuncTest(){
        employeeHandler.addEmployee(option1, parameter1);
        assertEquals(1, employeeHandler.employee.size());
    }

    @Test
    void addFuncSameEmployeeNumTest(){
        employeeHandler.addEmployee(option1, parameter1);
        employeeHandler.addEmployee(option1, parameter1);
        assertEquals(1, employeeHandler.employee.size());
    }

    @Test
    void addFuncDiffEmployeeNumTest(){
        employeeHandler.addEmployee(option1, parameter1);
        employeeHandler.addEmployee(option1, parameter2);
        assertEquals(2, employeeHandler.employee.size());
    }

    @Test
    void addFuncInputFileTest() throws IOException {
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

        assertEquals(99723, employeeHandler.employee.size());
    }
}
