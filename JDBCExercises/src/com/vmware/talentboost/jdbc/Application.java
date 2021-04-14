package com.vmware.talentboost.jdbc;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.vmware.talentboost.jdbc.data.Employee;
import com.vmware.talentboost.jdbc.data.Job;
import com.vmware.talentboost.jdbc.repository.BaseRepository;
import com.vmware.talentboost.jdbc.repository.EmployeesRepository;
import com.vmware.talentboost.jdbc.repository.JobsRepository;

public class Application {

    private static final JobsRepository jobsRepository = new JobsRepository();
    private static final EmployeesRepository employeesRepository = new EmployeesRepository();

    public static void main(String[] args) throws SQLException {
        printAllJobs();
        printJobsWithSalaryInRange();

        printEmployeeCount();
        int newEmployeeId = addNewEmployee();
        printEmployeeCount();
        printEmployee(newEmployeeId);
        updateEmployeeSalary(newEmployeeId);
        printEmployee(newEmployeeId);
        deleteEmployee(newEmployeeId);
        printEmployeeCount();
    }

    private static void printAllJobs() throws SQLException {
        System.out.println("Fetching all jobs...");
        List<Job> allJobs = jobsRepository.getAllJobs();
        System.out.printf("%d jobs found: %s%n", allJobs.size(), allJobs);
    }

    private static void printJobsWithSalaryInRange() throws SQLException {
        System.out.println("Fetching jobs with salary from 5 000 to 25 000...");
        List<Job> jobs = jobsRepository.getJobsWithSalaryInRange(5_000, 25_000);
        System.out.printf("%d jobs found: %s%n", jobs.size(), jobs);
    }

    private static void printEmployeeCount() throws SQLException {
        System.out.println("Fetching employee count...");
        int employeeCount = employeesRepository.getEmployeeCount();
        System.out.printf("Employee count: %s%n", employeeCount);
    }

    private static void printEmployee(int employeeId) throws SQLException {
        System.out.printf("Fetching employee with id %d...%n", employeeId);
        Optional<Employee> employee = employeesRepository.getEmployeeById(employeeId);
        if (employee.isPresent()) {
            System.out.printf("Employee: %s%n", employee);
        } else {
            System.out.printf("No employee found with id: %d%n", employeeId);
        }
    }

    private static int addNewEmployee() throws SQLException {
        System.out.println("Adding new employee...");
        Employee newEmployee = new Employee();
        newEmployee.setFirstName("Ada");
        newEmployee.setLastName("Lovelace");
        newEmployee.setEmail("ada@example.com");
        newEmployee.setPhoneNumber("202-555-0166");
        newEmployee.setJobId("IT_PROG");
        newEmployee.setHireDate(LocalDate.now());
        newEmployee.setSalary(5_000);

        int newEmployeeId = employeesRepository.addEmployee(newEmployee);
        System.out.printf("New employee id: %d%n", newEmployeeId);
        return newEmployeeId;
    }

    private static void updateEmployeeSalary(int employeeId) throws SQLException {
        System.out.println("Updating employee salary to 10 000...");
        boolean updated = employeesRepository.updateEmployeeSalary(employeeId, 10_000);
        System.out.printf("Updated successfully: %b%n", updated);
    }

    private static void deleteEmployee(int employeeId) throws SQLException {
        System.out.printf("Deleting employee with id %d...%n", employeeId);
        boolean deleted = employeesRepository.deleteEmployee(employeeId);
        System.out.printf("Deleted successfully: %b%n", deleted);
    }
}
