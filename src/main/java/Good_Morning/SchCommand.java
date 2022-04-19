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
            String searchResult = schHandler.searchEmpNum(employee, option, schValue);
            if(searchResult != null)
                result.add(searchResult);
        }
        else {
            for(Entry<String, Employee> entry : employee.entrySet()) {
                String searchResult = schHandler.searchEmpNum(entry, option, schValue);
                if(searchResult != null)
                    result.add(searchResult);
            }
        }
        return result;
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
