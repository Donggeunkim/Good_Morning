package Good_Morning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

abstract class SchHandler{
    public String searchEmpNum(Entry<String, Employee> employeeEntry, ArrayList<String> option, String schValue){
        return null;
    }
    public String searchEmpNum(HashMap<String, Employee> employee, ArrayList<String> option, String schValue){
        return null;
    }
}

class SchWithPhoneNum extends SchHandler{
    @Override
    public String searchEmpNum(Entry<String, Employee> employeeEntry, ArrayList<String> option, String schValue) {
        ArrayList<String> result = new ArrayList<>();
        String findOption = option.get(1);
        String phoneNum = employeeEntry.getValue().getPhoneNum();

        if(findOption.equals("m")) {
            phoneNum = phoneNum.split("-")[1];
        }
        else if(findOption.equals("l")){
            phoneNum = phoneNum.split("-")[2];
        }
        if(phoneNum.equals(schValue)){
            return employeeEntry.getValue().getEmployeeNum();
        }
        return null;
    }
}

class SchWithCl extends SchHandler{
    @Override
    public String searchEmpNum(Entry<String, Employee> employeeEntry, ArrayList<String> option, String schValue) {
        String cl = employeeEntry.getValue().getCl();
        if(cl.equals(schValue)){
            return employeeEntry.getValue().getEmployeeNum();
        }
        return null;
    }
}

class SchWithBirthday extends SchHandler{
    @Override
    public String searchEmpNum(Entry<String, Employee> employeeEntry, ArrayList<String> option, String schValue) {
        String birthday = employeeEntry.getValue().getBirthday();
        String findOption = option.get(1);

        if(findOption.equals("y")){
            birthday = birthday.substring(0,3);
        }
        else if(findOption.equals("m")){
            birthday = birthday.substring(4,5);
        }
        else if(findOption.equals("d")){
            birthday = birthday.substring(6);
        }

        if(birthday.equals(schValue)){
            return employeeEntry.getValue().getEmployeeNum();
        }
        return null;
    }
}

class SchWithCerti extends SchHandler{
    @Override
    public String searchEmpNum(Entry<String, Employee> employeeEntry, ArrayList<String> option, String schValue) {
        String certi = employeeEntry.getValue().getCerti();
        if(certi.equals(schValue)){
            return employeeEntry.getValue().getEmployeeNum();
        }
        return null;
    }
}

class SchWithEmpNum extends SchHandler{
    @Override
    public String searchEmpNum(HashMap<String, Employee> employee, ArrayList<String> option, String schValue) {
        return employee.get(schValue).getEmployeeNum();
    }

}

class SchWithName extends SchHandler{
    @Override
    public String searchEmpNum(Entry<String, Employee> employeeEntry, ArrayList<String> option, String schValue) {
        String name = employeeEntry.getValue().getName();
        String findOption = option.get(1);
        if(findOption.equals("f")) {
            name = name.split(" ")[0];
        }
        else if(findOption.equals("l")){
            name = name.split(" ")[1];
        }
        if(name.equals(schValue)){
            return employeeEntry.getValue().getEmployeeNum();
        }
        return null;
    }
}