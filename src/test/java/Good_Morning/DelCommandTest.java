package Good_Morning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class DelCommandTest {
    EmployeeHandler employeeHandler;
    ArrayList<String> option1;
    @BeforeEach
    void setup() {
        employeeHandler = new EmployeeHandler();

        option1 = new ArrayList<>();
        option1.add(" ");
        option1.add(" ");
        option1.add(" ");

        ArrayList<String> parameter1 = new ArrayList<>();
        parameter1.add("14016092");
        parameter1.add("KIM MINHWAN");
        parameter1.add("CL3");
        parameter1.add("010-2802-9011");
        parameter1.add("19900109");
        parameter1.add("PRO");

        employeeHandler.addEmployee(option1, parameter1);
    }

    @Test
    void delFuncTest(){
        ArrayList<String> schItem = new ArrayList<>();
        schItem.add("employeeNum");
        schItem.add("14016092");

        employeeHandler.deleteEmployee(option1, schItem);

        assertEquals(0, employeeHandler.employee.size());
    }
}
