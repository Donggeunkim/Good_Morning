package Good_Morning;

import java.util.*;

public class EmployeeHandler {
    public TreeMap<String, Employee> employee;
    public ArrayList<String> searchResult;

    public void addEmployee(ArrayList<String> options, ArrayList<String> parameters){
        AddCommand addCommand = new AddCommand(options, parameters);
        Employee employeeData = addCommand.ExecuteJob(this.employee, options, parameters);
        //Add Sort Logic
        if(employeeData != null) employee.put(employeeData.getEmployedYearNum(), employeeData);
    }

    public EmployeeHandler(){
        employee = new TreeMap<>();
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
            if (option.get(0).equals("-p")) {
                ArrayList<Employee> sortResult = new ArrayList<Employee>();
                for(String employeeNum : searchResult){
                    sortResult.add(this.employee.get(employeeNum));
                }

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

