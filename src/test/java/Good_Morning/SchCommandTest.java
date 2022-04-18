package Good_Morning;

import org.junit.jupiter.api.Test;

import java.security.Principal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SchCommandTest {
    @Test
    void search_test(){
        EmployeeHandler emphandler = new EmployeeHandler();
        ArrayList<String> employ1 = new ArrayList<>();
        employ1.add("18025906");
        employ1.add("KIM YOUNGJI");
        employ1.add("CL2");
        employ1.add("010-6654-9105");
        employ1.add("19941115");
        employ1.add("PRO");
        ArrayList<String> option = new ArrayList<>();
        option.add("p");
        option.add("");
        option.add("");
        emphandler.addEmployee(option,employ1);

        ArrayList<String> employ2 = new ArrayList<>();
        employ2.add("98402365");
        employ2.add("KIM YONZZANG");
        employ2.add("CL3");
        employ2.add("010-6154-9105");
        employ2.add("19901115");
        employ2.add("PRO");
        emphandler.addEmployee(option,employ2);

        ArrayList<String> schItem = new ArrayList<>();
        schItem.add("cl");
        schItem.add("CL3");

        assertEquals(1,emphandler.searchEmployee(option, schItem));

        ArrayList<String> option1 = new ArrayList<>();
        option1.add("p");
        option1.add("-l");
        option1.add("");
        ArrayList<String> schItem1 = new ArrayList<>();
        schItem1.add("name");
        schItem1.add("YONZZANG");
        assertEquals(1,emphandler.searchEmployee(option1, schItem1));

        ArrayList<String> option2 = new ArrayList<>();
        option2.add("p");
        option2.add("");
        option2.add("");
        ArrayList<String> schItem2 = new ArrayList<>();
        schItem2.add("certi");
        schItem2.add("PRO");
        assertEquals(2,emphandler.searchEmployee(option2, schItem2));

    }

    @Test
    void search_employNum_null_test() {
        EmployeeHandler empHandler = new EmployeeHandler();

        System.out.println("size : " + empHandler.employee.size());
        ArrayList<String> option1 = new ArrayList<>();
        option1.add("-p");
        option1.add("-f");
        option1.add(" ");

        ArrayList<String> schItem = new ArrayList<>();
        schItem.add("employeeNum");
        schItem.add("14016093");

        assertDoesNotThrow(() -> empHandler.searchEmployee(option1, schItem));

        ArrayList<String> schItem2 = new ArrayList<>();
        schItem2.add("name");
        schItem2.add("abc");

        assertDoesNotThrow(() -> empHandler.searchEmployee(option1, schItem2));

        ArrayList<String> schItem3 = new ArrayList<>();
        schItem3.add("noitem");
        schItem3.add("kkk");

        assertDoesNotThrow(() -> empHandler.searchEmployee(option1, schItem3));

    }
}