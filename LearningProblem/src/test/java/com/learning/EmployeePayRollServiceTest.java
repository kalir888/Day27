package com.learning;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.learning.EmployeePayRollService.IOService.FILE_IO;
import static org.junit.jupiter.api.Assertions.*;

class EmployeePayRollServiceTest {
    @Test
    public void given3EmployeeWhenWrittenToFileShouldMatchEmployeeEntries() {
        EmployeePayRollData[] arrayOfEmps = {
                new EmployeePayRollData(1,"Ratan Tata",100000),
                new EmployeePayRollData(2,"Anil Ambani",200000),
                new EmployeePayRollData(3,"Adani",3000000)
        };
        EmployeePayRollService employeePayRollService;
        employeePayRollService = new EmployeePayRollService(Arrays.asList(arrayOfEmps));
        employeePayRollService.writeEmployeePayRollData(FILE_IO);
        employeePayRollService.printData(FILE_IO);
        long entries = employeePayRollService.countEntries(FILE_IO);
        Assertions.assertEquals(3, entries);
        employeePayRollService.readData(FILE_IO);
    }

}