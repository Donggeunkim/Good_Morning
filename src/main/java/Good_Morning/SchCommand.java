package Good_Morning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class SchCommand {

    public ArrayList<String> executeJob(HashMap<String, Employee> employee, ArrayList<String> option, ArrayList<String> schItem){
        if(employee==null) // validation check
            return null;
        ArrayList<String> result = new ArrayList<>();
        String schKey = schItem.get(0);
        String schValue = schItem.get(1);
        SchHandler schHandler = SetSchType(schKey);
        String resultEmpNum = null;


        if (schKey.equals("employeeNum")){
            resultEmpNum = schHandler.searchEmpNum(employee, option, schValue);
            if(resultEmpNum != null)
                result.add(resultEmpNum);
        }
        else {
            Set<Entry<String, Employee>> entrySet = employee.entrySet();
            for(Entry<String, Employee> entry : entrySet) {
                resultEmpNum = schHandler.searchEmpNum(entry, option, schValue);
                if(resultEmpNum != null)
                    result.add(resultEmpNum);
            }
        }
        return result;
    }

    private SchHandler SetSchType(String schKey){
        SchHandler schHandler = null;
        if(schKey.equals("employeeNum")) schHandler = new SchWithEmpNum();
        if(schKey.equals("name")) schHandler = new SchWithName();
        if(schKey.equals("cl")) schHandler = new SchWithCl();
        if(schKey.equals("phoneNum")) schHandler = new SchWithPhoneNum();
        if(schKey.equals("birthday")) schHandler = new SchWithBirthday();
        if(schKey.equals("certi")) schHandler = new SchWithCerti();

        return schHandler;
    }
}
