package Good_Morning;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SchCommand {

    public ArrayList<String> executeJob(TreeMap<String, Employee> employee, ArrayList<String> option, ArrayList<String> schItem){

        ArrayList<String> result = new ArrayList<>();
        String schKey = schItem.get(0);
        String schValue = schItem.get(1);

        if (schKey.equals("employeeNum")){
            if(setSchType(schKey).searchEmpNum(employee, option, schValue) != null)
                result.add(setSchType(schKey).searchEmpNum(employee, option, schValue));
        }
        else {
            for(Entry<String, Employee> entry : employee.entrySet()) {
                if(setSchType(schKey).searchEmpNum(entry, option, schValue) != null)
                    result.add(setSchType(schKey).searchEmpNum(entry, option, schValue));
            }
        }
        return result;
    }

    private SchHandler setSchType(String schKey){
        SchHandler schHandler = null;
        if(schKey.equals("employeeNum")) schHandler = new schWithEmpNum();
        if(schKey.equals("name")) schHandler = new schWithName();
        if(schKey.equals("cl")) schHandler = new schWithCl();
        if(schKey.equals("phoneNum")) schHandler = new schWithPhoneNum();
        if(schKey.equals("birthday")) schHandler = new schWithBirthday();
        if(schKey.equals("certi")) schHandler = new schWithCerti();

        return schHandler;
    }
}
