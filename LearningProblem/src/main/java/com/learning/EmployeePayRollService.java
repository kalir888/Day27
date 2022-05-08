package com.learning;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayRollService {
    public enum IOService {CONSOLE_IO,FILE_IO,DB_IO,REST_IO}
    private List<EmployeePayRollData> employeePayRollList;

    public EmployeePayRollService() {
    }

    public EmployeePayRollService(List<EmployeePayRollData> employeePayRollList) {
        this.employeePayRollList = employeePayRollList;
    }

    private void readEmployeePayRollData(Scanner consoleInputReader) {
        System.out.println("Enter Employee Id: ");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter Employee Name: ");
        String name = consoleInputReader.next();
        System.out.println("Enter Employee Salary: ");
        double salary = consoleInputReader.nextDouble();
        employeePayRollList.add(new EmployeePayRollData(id,name,salary));
    }

    public void writeEmployeePayRollData(IOService ioService) {
        if(ioService.equals(IOService.CONSOLE_IO))
            System.out.println("Writing EmployeePayroll Roaster to Console\n" + employeePayRollList);
        else if(ioService.equals(IOService.FILE_IO))
            new EmployeePayRollFileIOService().writeData(employeePayRollList);
    }

    public void printData(IOService ioService) {
        if(ioService.equals(IOService.FILE_IO))
            new EmployeePayRollFileIOService().printData();
    }

    public List<EmployeePayRollData> readData(IOService ioService) {
        if(ioService.equals(IOService.FILE_IO))
            return new EmployeePayRollFileIOService().readData();
        return null;
    }

    public long countEntries(IOService ioService) {
        if(ioService.equals(IOService.FILE_IO))
        return new EmployeePayRollFileIOService().countEntries();
        return 0;
    }

    public static void main(String args[]) {
        ArrayList<EmployeePayRollData> employeePayRollList = new ArrayList<>();
        EmployeePayRollService employeePayRollService = new EmployeePayRollService(employeePayRollList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayRollService.readEmployeePayRollData(consoleInputReader);
        employeePayRollService.writeEmployeePayRollData(IOService.FILE_IO);
    }
}
