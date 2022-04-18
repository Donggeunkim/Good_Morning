package Good_Morning;

import java.util.ArrayList;
import java.util.HashMap;

public class EmployeeHandler {
    public HashMap<String, Employee> employee = new HashMap<>();

    public void addEmployee(ArrayList<String> options, ArrayList<String> parameters){
        AddCommand addCommand = new AddCommand(options, parameters);
        Employee employeeData = addCommand.ExecuteJob();
        employee.put(employeeData.getEmployeeNum(), employeeData);
    }

    public void delEmployee(ArrayList<String> option, ArrayList<String> schItem){
        DelCommand searchBase = new DelCommand();
        ArrayList<String> employeeList = searchBase.executeJob(this.employee, option, schItem);

        printEmployee(employeeList, option.get(0).equals("-p"));

        for(String employeeNum : employeeList) {
            employee.remove(employeeNum);
        }
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

    private void printEmployee(ArrayList<String> employeeList, boolean option1) {
        if(employeeList.size() == 0) {
            System.out.println("DEL,NONE");
            return;
        }

        if(option1) {
            //Add Sorting
            for (String employeeNum : employeeList) {
                System.out.println("DEL,"+ this.employee.get(employeeNum).getName());
            }
        }
        else {
            System.out.print("DEL," + employeeList.size());
        }
    }
}

