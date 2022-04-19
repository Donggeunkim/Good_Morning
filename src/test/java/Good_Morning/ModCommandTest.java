package Good_Morning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class ModCommandTest {
    ModCommand modCommand;
    EmployeeHandler employeeHandler;
    ArrayList<String> option;
    ArrayList<String> parameter;

    @BeforeEach
    void setUp() {
        employeeHandler = new EmployeeHandler();
        modCommand = mock(ModCommand.class);
        option = new ArrayList<>(Arrays.asList(" ", " ", " "));
        parameter = new ArrayList<>(Arrays.asList("18882535", "EUYBHPS JANG", "CL3", "010-0479-6410", "19910904", "ADV"));
        employeeHandler.addEmployee(option, parameter);
        parameter = new ArrayList<>(Arrays.asList("06490407", "ZMHTVCM SIN", "CL1", "010-7726-8518", "19791014", "ADV"));
        employeeHandler.addEmployee(option, parameter);
        parameter = new ArrayList<>(Arrays.asList("75266735", "EJRQLAT AN", "CL1", "010-1089-5053", "19480623", "ADV"));
        employeeHandler.addEmployee(option, parameter);
        parameter = new ArrayList<>(Arrays.asList("99418318", "OMENUQL OH", "CL3", "010-1939-2346", "19721108", "EX"));
        employeeHandler.addEmployee(option, parameter);
        parameter = new ArrayList<>(Arrays.asList("84349963", "JXWVNPO YANG", "CL3", "010-3519-5313", "19571027", "ADV"));
        employeeHandler.addEmployee(option, parameter);
    }

    @Test
    void setModCommandTest01() {
        ArrayList<String> searchItem = new ArrayList<>(Arrays.asList("employeeNum", "75266735", "certi", "PRO"));
        employeeHandler.modifyEmployee(option, searchItem);
        String result = employeeHandler.employee.get("1975266735").getCerti();
        assertEquals("PRO", result);

        searchItem = new ArrayList<>(Arrays.asList("certi", "ADV", "cl", "CL2"));
        employeeHandler.modifyEmployee(option, searchItem);
        String result1 = employeeHandler.employee.get("2018882535").getCl();
        String result2 = employeeHandler.employee.get("2006490407").getCl();
        String result3 = employeeHandler.employee.get("1984349963").getCl();
        assertEquals("CL2", result1);
        assertEquals("CL2", result2);
        assertEquals("CL2", result3);
    }

    @Test
    void setModCommandTest02() {
        ArrayList<String> searchItem = new ArrayList<>(Arrays.asList("75266735", "75266735", "PRO", "certi"));
        employeeHandler.modifyEmployee(option, searchItem);
        String result = employeeHandler.employee.get("1975266735").getCerti();
        assertEquals("ADV", result);
    }

    @Test
    void checkModKeyTest() {
        assertEquals(false, modCommand.checkModKey("lastname"));
        assertEquals(true, modCommand.checkModKey("cl"));
        assertEquals(false, modCommand.checkModKey("phone"));
        assertEquals(true, modCommand.checkModKey("phoneNum"));
    }

}
