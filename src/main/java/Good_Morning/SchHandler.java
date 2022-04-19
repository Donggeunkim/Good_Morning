package Good_Morning;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

interface SchHandler<T>{
    String searchEmpNum(T employeeEntry, ArrayList<String> option, String schValue);
}

class schWithPhoneNum implements SchHandler<Entry<String, Employee>>{
    @Override
    public String searchEmpNum(Entry<String, Employee> employeeEntry, ArrayList<String> option, String schValue) {
        ArrayList<String> result = new ArrayList<>();
        String findOption = option.get(1);
        String phoneNum = employeeEntry.getValue().getPhoneNum();

        if(findOption.equals("-m")) {
            phoneNum = phoneNum.split("-")[1];
        }
        else if(findOption.equals("-l")){
            phoneNum = phoneNum.split("-")[2];
        }
        if(phoneNum.equals(schValue)){
            return employeeEntry.getValue().getEmployedYearNum();
        }
        return null;
    }
}

class schWithCl implements SchHandler<Entry<String, Employee>>{
    @Override
    public String searchEmpNum(Entry<String, Employee> employeeEntry, ArrayList<String> option, String schValue) {
        String cl = employeeEntry.getValue().getCl();
        if(cl.equals(schValue)){
            return employeeEntry.getValue().getEmployedYearNum();
        }
        return null;
    }
}

class schWithBirthday implements SchHandler<Entry<String, Employee>>{
    @Override
    public String searchEmpNum(Entry<String, Employee> employeeEntry, ArrayList<String> option, String schValue) {
        String birthday = employeeEntry.getValue().getBirthday();
        String findOption = option.get(1);

        if(findOption.equals("-y")){
            birthday = birthday.substring(0,4);
        }
        else if(findOption.equals("-m")){
            birthday = birthday.substring(4,6);
        }
        else if(findOption.equals("-d")){
            birthday = birthday.substring(6);
        }

        if(birthday.equals(schValue)){
            return employeeEntry.getValue().getEmployedYearNum();
        }
        return null;
    }
}

class schWithCerti implements SchHandler<Entry<String, Employee>>{
    @Override
    public String searchEmpNum(Entry<String, Employee> employeeEntry, ArrayList<String> option, String schValue) {
        String certi = employeeEntry.getValue().getCerti();
        if(certi.equals(schValue)){
            return employeeEntry.getValue().getEmployedYearNum();
        }
        return null;
    }
}

class schWithEmpNum implements SchHandler<HashMap<String, Employee>>{
    @Override
    public String searchEmpNum(HashMap<String, Employee> employee, ArrayList<String> option, String schValue) {
        if(!employee.containsKey(schValue)) return null; // validation 메서드로 뺄까..?
        return employee.get(schValue).getEmployedYearNum();
    }
}

class schWithName implements SchHandler<Entry<String, Employee>>{
    @Override
    public String searchEmpNum(Entry<String, Employee> employeeEntry, ArrayList<String> option, String schValue) {
        String name = employeeEntry.getValue().getName();
        String findOption = option.get(1);
        if(findOption.equals("-f")) {
            name = name.split(" ")[0];
        }
        else if(findOption.equals("-l")){
            name = name.split(" ")[1];
        }
        if(name.equals(schValue)){
            return employeeEntry.getValue().getEmployedYearNum();
        }
        return null;
    }
}