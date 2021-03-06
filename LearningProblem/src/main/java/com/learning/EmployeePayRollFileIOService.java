package com.learning;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayRollFileIOService {
    public static String PAYROLL_FILE_NAME = "payroll-file.txt";
    public void writeData(List<EmployeePayRollData> employeePayRollList) {
        StringBuffer empBuffer = new StringBuffer();
        employeePayRollList.forEach(employeePayRollData -> {
            String employeeDataString = employeePayRollData.toString().concat("\n");
            empBuffer.append(employeeDataString);
        });

        try {
            Files.write(Paths.get(PAYROLL_FILE_NAME),empBuffer.toString().getBytes());
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void printData() {
        try {
            Files.lines(new File("payroll-file.txt").toPath()).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long countEntries() {
        long entries = 0;
        try {
            entries = Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }

    public List<EmployeePayRollData> readData() {
        List<EmployeePayRollData> employeePayRollList = new ArrayList<>();
        try {
            Files.lines(new File("payroll-file.txt").toPath()).map(line -> line.trim())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeePayRollList;
    }
}
