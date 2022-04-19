package Good_Morning;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SchCommand {

    public ArrayList<String> executeJob(TreeMap<String, Employee> employee, ArrayList<String> option, ArrayList<String> schItem){

        ArrayList<String> result = new ArrayList<>();
        String schKey = schItem.get(0);
        String schValue = schItem.get(1);

        SchHandler schHandler = getSchType(schKey);
        if (schHandler==null) return result;

        if (schKey.equals("employeeNum")){
            schValue = getEmployedYearNum(schValue);
            if(schHandler.searchEmpNum(employee, option, schValue) != null)
                result.add(schHandler.searchEmpNum(employee, option, schValue));
        }
        else {
            for(Entry<String, Employee> entry : employee.entrySet()) {
                if(schHandler.searchEmpNum(entry, option, schValue) != null)
                    result.add(schHandler.searchEmpNum(entry, option, schValue));
            }
        }
        return result;
    }

    private String getEmployedYearNum(String employeeNum){
        int year = Integer.parseInt(employeeNum.substring(0,2));
        if (year < 22)
            return "20" + employeeNum;
        else
            return "19" + employeeNum;
    }

    private SchHandler getSchType(String schKey){
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
                break;
        }
        return schHandler;
    }
}
