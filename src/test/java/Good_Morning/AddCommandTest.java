package Good_Morning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

public class AddCommandTest {
    EmployeeHandler employeeHandler;
    ArrayList<String> option1;
    ArrayList<String> parameter1;
    ArrayList<String> parameter2;

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

        parameter2 = new ArrayList<>();
        parameter2.add("14016093");
        parameter2.add("KIM MINHWAN");
        parameter2.add("CL3");
        parameter2.add("010-2802-9011");
        parameter2.add("19900109");
        parameter2.add("PRO");
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

        Parser parser = new Parser();
        for(String commandLine : commandLines) {
            parser.splitCommnadLine(commandLine);
            employeeHandler.addEmployee(parser.getOptions(), parser.getValues());
        }

        assertEquals(99723, employeeHandler.employee.size());
    }
}
