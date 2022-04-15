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
    }
}