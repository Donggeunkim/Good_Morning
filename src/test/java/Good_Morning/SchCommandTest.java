package Good_Morning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SchCommandTest {

    EmployeeHandler employeeHandler;
    ArrayList<String> option1;
    ArrayList<String> parameter1;

    @BeforeEach
    void setup() {
        employeeHandler = new EmployeeHandler();
        option1 = new ArrayList<>(Arrays.asList(" ", " ", " "));
        parameter1 = new ArrayList<>(Arrays.asList("14016092", "MINHWAN KIM",
                                                   "CL3", "010-2802-9011", "19900109", "PRO"));
    }

    @Test
    void search_test(){
        EmployeeHandler emphandler = new EmployeeHandler();
        ArrayList<String> employ1 = new ArrayList<>(Arrays.asList("18025906", "YOUNGJI KIM",
                                                                  "CL2", "010-6654-9105", "19941115", "PRO"));
        ArrayList<String> option = new ArrayList<>(Arrays.asList("p", "", ""));
        emphandler.addEmployee(option,employ1);

        ArrayList<String> employ2 = new ArrayList<>(Arrays.asList("98402365", "YONZZANG KIM",
                                                                  "CL3", "010-6154-9105", "19901115", "PRO"));
        emphandler.addEmployee(option,employ2);

        ArrayList<String> schItem = new ArrayList<>(Arrays.asList("cl", "CL3"));
        assertEquals("SCH,1",emphandler.searchEmployee(option, schItem));

        option1 = new ArrayList<>(Arrays.asList("", "-l", ""));
        ArrayList<String> schItem1 = new ArrayList<>(Arrays.asList("name", "YONZZANG"));
        assertEquals("SCH,NONE",emphandler.searchEmployee(option1, schItem1));

        ArrayList<String> option2 = new ArrayList<>(Arrays.asList("", "", ""));
        ArrayList<String> schItem2 = new ArrayList<>(Arrays.asList("certi", "PRO"));
        assertEquals("SCH,2",emphandler.searchEmployee(option2, schItem2));
    }

    @Test
    void search_employNum_null_test() {
        EmployeeHandler empHandler = new EmployeeHandler();

        ArrayList<String> option1 = new ArrayList<>(Arrays.asList("-p", "-f", " "));
        ArrayList<String> schItem = new ArrayList<>(Arrays.asList("employeeNum", "14016093"));

        assertDoesNotThrow(() -> empHandler.searchEmployee(option1, schItem));

        ArrayList<String> schItem2 = new ArrayList<>(Arrays.asList("name", "abc"));

        assertDoesNotThrow(() -> empHandler.searchEmployee(option1, schItem2));

        ArrayList<String> schItem3 = new ArrayList<>(Arrays.asList("noitem", "kkk"));

        assertDoesNotThrow(() -> empHandler.searchEmployee(option1, schItem3));

    }

    @Test
    void searchClTest() throws IOException {
        String filePath = "input4add.txt";
        ArrayList<String> commandLines = FileIo.readInputFile(filePath);

        ArrayList<String> outputStringList = new ArrayList<>();
        Parser parser = new Parser();

        for(String commandLine : commandLines) {
            parser.splitCommandLine(commandLine);
            String result = parser.executeJob(employeeHandler);
            if (result != null)
                outputStringList.add(result);
        }

        ArrayList<String> schItem = new ArrayList<>(Arrays.asList("cl", "CL2"));

        assertEquals("SCH,33503", employeeHandler.searchEmployee(option1, schItem));
    }
}