package Good_Morning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class EmployeeHandler {
    public HashMap<String, Employee> employee;
    public ArrayList<String> searchResult;

    private ArrayList<Employee> sortEmployee(){
        ArrayList<Employee> sortResult = new ArrayList<>();

        for(String employeeNum : searchResult){
            sortResult.add(employee.get(employeeNum));
        }

        Collections.sort(sortResult, new Comparator<Employee>(){
            public int compare(Employee o1, Employee o2) {
                if(o1.getEmployedYear()<o2.getEmployedYear()) {
                    return -1;
                }else if(o1.getEmployedYear()>o2.getEmployedYear()) {
                    return 1;
                }else {
                    if(o1.getEmployedYear()==o2.getEmployedYear()) {
                        return o2.getEmployeeNum().compareTo(o1.getEmployeeNum());
                    }else {
                        return 0;
                    }
                }
            }
        });

        return sortResult;
    }

    public void addEmployee(ArrayList<String> options, ArrayList<String> parameters){
        AddCommand addCommand = new AddCommand(options, parameters);
        Employee employeeData = addCommand.ExecuteJob(this.employee, options, parameters);
        //Add Sort Logic
        if(employeeData != null) employee.put(employeeData.getEmployeeNum(), employeeData);
    }

    public EmployeeHandler(){
        employee = new HashMap<>();
        searchResult = new ArrayList<>();
    }

    public int searchEmployee(ArrayList<String> option, ArrayList<String> searchItem){
        SchCommand search_base = new SchCommand();
        searchResult = search_base.executeJob(this.employee, option, searchItem);

        return searchResult.size();
    }

    public void deleteEmployee(ArrayList<String> option, ArrayList<String> searchItem){
        DelCommand searchBase = new DelCommand();
        ArrayList<String> employeeList = searchBase.executeJob(this.employee, option, searchItem);

        for(String employeeNum : employeeList) {
            employee.remove(employeeNum);
        }
    }

    public void modifyEmployee(ArrayList<String> option, ArrayList<String> searchItem){
    }

    // Del이나 Mod동작 SCH -> Print -> DEL or MOD ??
    public void printEmployee(String Command, ArrayList<String> option, ArrayList<String> searchItem){
        if(searchResult.size()==0) System.out.println(Command + ",NONE");
        else {
            if (option.get(0).equals("p")) {
                ArrayList<Employee> sortResult = sortEmployee();

                if (sortResult.size() > 5){
                    sortResult = new ArrayList<>(sortResult.subList(0,5));
                }

                for (Employee employee : sortResult) {
                    System.out.println(Command + "," + employee.getName());
                }

            } else {
                System.out.println(Command + "," + searchResult.size());
            }
        }
    }
}

