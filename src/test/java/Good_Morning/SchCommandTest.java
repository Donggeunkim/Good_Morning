package Good_Morning;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SchCommandTest {
    @Test
    void search_test(){
        EmployeeHandler emphandler = new EmployeeHandler();
        emphandler.addEmployee("18025906","KIM YOUNGJI","CL2","010-6654-9105","19941115","PRO");
        emphandler.addEmployee("98025906","KIM YOUNGSAM","CL3","010-6654-9107","19670814","PRO");
        emphandler.addEmployee("02025906","LEE EULCHOON","CL2","010-5654-9107","19920207","ADV");

        ArrayList<String> option = new ArrayList<>();
        option.add("p");
        option.add("");
        option.add("");

        ArrayList<String> schItem = new ArrayList<>();
        schItem.add("cl");
        schItem.add("CL2");

        assertEquals(2,emphandler.searchEmployee(option, schItem));

        ArrayList<String> option1 = new ArrayList<>();
        option1.add("p");
        option1.add("l");
        option1.add("");
        ArrayList<String> schItem1 = new ArrayList<>();
        schItem1.add("name");
        schItem1.add("YOUNGJI");
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
}