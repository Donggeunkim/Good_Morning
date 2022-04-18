package Good_Morning;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class AddCommandTest {
    @Test
    void addFuncTest(){
        EmployeeHandler emphandler = new EmployeeHandler();

        ArrayList<String> option1 = new ArrayList<>();
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

        emphandler.addEmployee(option1, parameter1);
        assertEquals(1, emphandler.employee.size());
    }
}
