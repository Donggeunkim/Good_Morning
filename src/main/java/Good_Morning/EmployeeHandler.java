package Good_Morning;

import java.util.*;

public class EmployeeHandler {
    public TreeMap<String, Employee> employee;
    private ArrayList<String> searchResult;
    private String result;

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

    public String searchEmployee(ArrayList<String> option, ArrayList<String> searchItem){
        SchCommand searchBase = new SchCommand();
        searchResult = searchBase.executeJob(this.employee, option, searchItem);

        result = printEmployee("SCH", option);

        return result;
    }

    public String deleteEmployee(ArrayList<String> option, ArrayList<String> searchItem){
        DelCommand searchBase = new DelCommand();
        searchResult = searchBase.executeJob(this.employee, option, searchItem);

        result = printEmployee("DEL", option);

        for(String employeeYearNum : searchResult) {
            employee.remove(employeeYearNum);
        }
        return result;
    }

    public String modifyEmployee(ArrayList<String> option, ArrayList<String> searchItem){
        SchCommand search_base = new SchCommand();
        ModCommand modCommand = new ModCommand();

        searchResult = search_base.executeJob(this.employee, option, searchItem);
        result = printEmployee("MOD", option);
        modCommand.executeJob(this.employee, searchResult, searchItem);
        return result;
    }

    private String printEmployee(String Command, ArrayList<String> option){

        String result = "";
        if(searchResult.size()==0) {
            System.out.println(Command + ",NONE");
            return Command + ",NONE";
        }
        else {
            if (option.get(0).equals("-p")) {
                ArrayList<Employee> sortResult = new ArrayList<>();
                for(String employeeNum : searchResult){
                    if (sortResult.size() >= 5) break;
                    sortResult.add(this.employee.get(employeeNum));
                }

                for (Employee employee : sortResult) {
                    System.out.println(Command + "," + employee.getSixParams());
                    result += Command + "," + employee.getSixParams() + "\n";
                }
                return result;

            } else {
                System.out.println(Command + "," + searchResult.size());
                return Command + "," + searchResult.size();
            }
        }
    }
}

