package Good_Morning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class EmployeeHandler {
    public HashMap<String, Employee> employee_;
    public ArrayList<String> search_result_;

    private ArrayList<Employee> SortEmployee(){
        ArrayList<Employee> sort_result = new ArrayList<>();

        for(String employee_num : search_result_){
            sort_result.add(employee_.get(employee_num));
        }

        Collections.sort(sort_result, new Comparator<Employee>(){
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

        return sort_result;
    }
  
    public void AddEmployee(ArrayList<String> options, ArrayList<String> parameters){
        AddCommand addCommand = new AddCommand(options, parameters);
        Employee employeeData = addCommand.ExecuteJob();
        employee.put(employeeData.getEmployeeNum(), employeeData);
    }

    public EmployeeHandler(){
        employee_ = new HashMap<>();
        search_result_ = new ArrayList<>();
    }

    public int SearchEmployee(ArrayList<String> option, ArrayList<String> search_item){
        SchCommand search_base = new SchCommand();
        search_result_ = search_base.executeJob(this.employee_, option, search_item);

        return search_result_.size();
    }

    public void DeleteEmployee(ArrayList<String> option, ArrayList<String> schItem){
        DelCommand searchBase = new DelCommand();
        ArrayList<String> employeeList = searchBase.executeJob(this.employee, option, schItem);

        PrintEmployee(employeeList, option.get(0).equals("-p"));

        for(String employeeNum : employeeList) {
            employee.remove(employeeNum);
        }
    }

    public void ModifyEmployee(ArrayList<String> option, ArrayList<String> search_item){
    }

    // Del이나 Mod동작 SCH -> Print -> DEL or MOD ??
    public void PrintEmployee(String Command, ArrayList<String> option, ArrayList<String> search_item){
        if(search_result_.size()==0) System.out.println(Command + ",NONE");
        else {
            if (option.get(0).equals("p")) {
                ArrayList<Employee> sort_result = SortEmployee();

                if (sort_result.size() > 5){
                    sort_result = new ArrayList<>(sort_result.subList(0,5));
                }

                for (Employee employee : sort_result) {
                    System.out.println(Command + "," + employee.getName());
                }

            } else {
                System.out.println(Command + "," + search_result_.size());
            }
        }
    }

}

