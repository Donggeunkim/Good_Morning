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
        switch(schKey){
            case "employeeNum":
                schHandler = new schWithEmpNum();
                break;
            case "name":
                schHandler = new schWithName();
                break;
            case "cl":
                schHandler = new schWithCl();
                break;
            case "phoneNum":
                schHandler = new schWithPhoneNum();
                break;
            case "birthday":
                schHandler = new schWithBirthday();
                break;
            case "certi":
                schHandler = new schWithCerti();
                break;
            default:
                return null;
        }
        return schHandler;
    }
}
