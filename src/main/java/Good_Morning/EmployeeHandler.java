package Good_Morning;

import java.util.ArrayList;
import java.util.HashMap;

public class EmployeeHandler {
    public HashMap<String, Employee> employee;

    public void addEmployee(String employeeNum, String name, String cl, String phoneNum, String birthday, String certi){
        if (employee == null) employee = new HashMap<>();
        Employee employeeData = new Employee(employeeNum, name, cl, phoneNum, birthday, certi);
        employee.put(employeeNum, employeeData);
    }

    public int searchEmployee(ArrayList<String> option, ArrayList<String> schItem){
        SchCommand searchBase = new SchCommand();
        ArrayList<String> employeeList = searchBase.executeJob(this.employee, option, schItem);
        if(employeeList.size()==0) System.out.println("SCH,NONE");
        else {
            if (option.get(0).equals("p")) {
                for (String employeeNum : employeeList) {
                    System.out.println("SCH,"+ this.employee.get(employeeNum).getName());
                }

            } else {
                System.out.print("SCH," + employeeList.size());
            }
        }
        return employeeList.size();
    }
}

