package Good_Morning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class SchCommand {

    public ArrayList<String> executeJob(HashMap<String, Employee> employee, ArrayList<String> option, ArrayList<String> schItem){
        ArrayList<String> result = new ArrayList<>();
        String schKey = schItem.get(0);
        String schValue = schItem.get(1);

        if (schKey.equals("employeeNum")){
            result.add(employee.get(schValue).getEmployeeNum());
        }
        else {
            Set<Entry<String, Employee>> entrySet = employee.entrySet();
            for(Entry<String, Employee> entry : entrySet) {
                switch(schKey){
                    case "name" :
                        String name = entry.getValue().getName();

                        if(option.get(1).equals("f")) {
                            name = name.split(" ")[0];
                        }
                        else if(option.get(1).equals("l")){
                            name = name.split(" ")[1];
                        }
                        if(name.equals(schValue)){
                            result.add(entry.getValue().getEmployeeNum());
                        }
                        break;
                    case "cl" :
                        if(entry.getValue().getCl().equals(schValue)){
                            result.add(entry.getValue().getEmployeeNum());
                        }
                        break;
                    case "phoneNum" :
                        String phoneNum = entry.getValue().getPhoneNum();

                        if(option.get(1).equals("m")){
                            phoneNum = phoneNum.substring(4,7);
                        }
                        else if(option.get(1).equals("l")){
                            phoneNum = phoneNum.substring(9);
                        }

                        if(phoneNum.equals(schValue)){
                            result.add(entry.getValue().getEmployeeNum());
                        }
                        break;
                    case "birthday" :
                        String birthday = entry.getValue().getBirthday();

                        if(option.get(1).equals("y")){
                            birthday = birthday.substring(0,3);
                        }
                        else if(option.get(1).equals("m")){
                            birthday = birthday.substring(4,5);
                        }
                        else if(option.get(1).equals("d")){
                            birthday = birthday.substring(6);
                        }

                        if(birthday.equals(schValue)){
                            result.add(entry.getValue().getEmployeeNum());
                        }
                        break;
                    case "certi" :
                        if(entry.getValue().getCerti().equals(schValue)){
                            result.add(entry.getValue().getEmployeeNum());
                        }
                        break;
                }
            }
        }
        return result;
    }
}
