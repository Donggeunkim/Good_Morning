package Good_Morning;


import java.util.*;

public class ModCommand extends SchCommand{

    public ArrayList<String> executeJob(HashMap<String, Employee> Employee, ArrayList<String> EmployeeYearNum,
                                                ArrayList<String> Parameter) {
        String ModKey, ModValue;
        ArrayList<String> result = new ArrayList<>();

        try {
            ModKey = Parameter.get(2);
            ModValue = Parameter.get(3);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }

        if (!checkModKey(ModKey)) return result;

        for (String searchResult : EmployeeYearNum) {
            switch (ModKey){
                case "name":
                    Employee.get(searchResult).setName(ModValue);
                    break;
                case "cl":
                    Employee.get(searchResult).setCl(ModValue);
                    break;
                case "phoneNum":
                    Employee.get(searchResult).setPhoneNum(ModValue);
                    break;
                case "birthday":
                    Employee.get(searchResult).setBirthday(ModValue);
                    break;
                case "certi":
                    Employee.get(searchResult).setCerti(ModValue);
                    break;
                default :
                    return result;
            }
        }
        return result;
    }

    public static boolean checkModKey (String modKey){
        ArrayList<String> checkStrings = new ArrayList<>(Arrays.asList("employeeNum", "name", "cl",
                                                                       "phoneNum", "birthday", "certi"));
        return checkStrings.contains(modKey);
    }
}
