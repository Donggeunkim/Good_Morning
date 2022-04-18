package Good_Morning;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[ ] args) throws IOException {
        EmployeeHandler emphandler = new EmployeeHandler();
//        emphandler.addEmployee("18025906","KIM YOUNGJI","CL2","010-6654-9105","19941115","PRO");
//        emphandler.addEmployee("98025906","KIM YOUNGSAM","CL3","010-6654-9107","19670814","PRO");
//        emphandler.addEmployee("02025906","LEE EULCHOON","CL2","010-5654-9107","19920207","ADV");

        ArrayList<String> option1 = new ArrayList<>();
        option1.add(" ");
        option1.add(" ");
        option1.add(" ");

        ArrayList<String> parameter1 = new ArrayList<>();
        parameter1.add("14016092");
        parameter1.add("KIM MINHWAN");
        parameter1.add("CL3");
        parameter1.add("010-2802-9011");
        parameter1.add("19900109");
        parameter1.add("PRO");


        //emphandler.employee에 존재하지 않는 사번 입력 후 조회 시 예외 발생
        emphandler.addEmployee(option1, parameter1);

        ArrayList<String> schItem = new ArrayList<>();
        schItem.add("employeeNum");
        schItem.add("14016092");

        emphandler.delEmployee(option1, schItem);

//        ArrayList<String> option = new ArrayList<>();
//        option.add("p");
//        option.add("");
//        option.add("");
//
//        ArrayList<String> schItem = new ArrayList<>();
//        schItem.add("cl");
//        schItem.add("CL2");
//        emphandler.searchEmployee(option, schItem);
    }
}

