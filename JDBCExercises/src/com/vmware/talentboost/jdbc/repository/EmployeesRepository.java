package com.vmware.talentboost.jdbc.repository;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

import com.vmware.talentboost.jdbc.data.Employee;

public class EmployeesRepository extends BaseRepository {

    /**
     * Returns the number of employees.
     */
    public int getEmployeeCount() throws SQLException {
        // TODO: implement (4)
        int result = 0;

        String query = "select count(*) from employees;";

        PreparedStatement statement = getConnection().prepareStatement(query);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            int count = resultSet.getInt("count");
            result = count;
        }

        return result;
    }

    /**
     * Returns employee by id.
     *
     * @return the employee. {@code Optional.empty()} if no employee is found with
     * the given id.
     */
    public Optional<Employee> getEmployeeById(int employeeId) throws SQLException {
        // TODO: implement (6)
        Employee employee = null;

        String query = "select * from employees where employee_id = ?;";

        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setInt(1, employeeId);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            ;
            String phoneNumber = resultSet.getString("phone_number");
            String email = resultSet.getString("email");
            String jobId = resultSet.getString("job_id");
            int salary = resultSet.getInt("salary");
            ;

            LocalDate hireDate = resultSet.getDate("hire_date").toLocalDate();

            employee = new Employee();

            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setHireDate(hireDate);
            employee.setJobId(jobId);
            employee.setSalary(salary);
            employee.setEmail(email);
            employee.setPhoneNumber(phoneNumber);
        }

        return Optional.of(employee);
    }

    /**
     * Adds new employee to the database.
     *
     * @return the id of the newly added employee.
     */
    public int addEmployee(Employee employee) throws SQLException {
        // TODO: implement (5)
        int employeeId = -1;
        try {
            String query = "insert into employees (first_name, last_name, phone_number, email, job_id, salary, hire_date)" +
                    "values (?, ?, ?, ?, ?, ?, ?);";

            PreparedStatement statement = getConnection().prepareStatement(query);


            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(4, employee.getEmail());
            statement.setString(3, employee.getPhoneNumber());
            statement.setString(5, employee.getJobId());
            statement.setInt(6, employee.getSalary());
            statement.setDate(7, Date.valueOf(employee.getHireDate()));
            statement.executeQuery();
        } catch (Exception ex) {

        }
        String idQuery = "select employee_id from employees where first_name = ? and last_name = ?";

        PreparedStatement idStatement = getConnection().prepareStatement(idQuery);

        idStatement.setString(1, employee.getFirstName());
        idStatement.setString(2, employee.getLastName());

        ResultSet resultSet = idStatement.executeQuery();

        if (resultSet.next()) {
            employeeId = resultSet.getInt("employee_id");
        }

        return employeeId;
    }

    /**
     * Updates the salary for given employee.
     *
     * @return whether the employee salary was updated or not.
     */
    public boolean updateEmployeeSalary(int employeeId, int newSalary) throws SQLException {
        // TODO: implement (7)
        String query = "UPDATE employees SET salary = ? WHERE employee_id = ?;";

        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setInt(1, newSalary);
        statement.setInt(2, employeeId);

        statement.executeUpdate();

        String salaryQuery = "select salary from employees where employee_id = ?;";

        PreparedStatement salaryStatement = getConnection().prepareStatement(salaryQuery);
        salaryStatement.setInt(1, employeeId);

        ResultSet resultSet = salaryStatement.executeQuery();
        int salary = 0;
        if(resultSet.next()) {
            salary = resultSet.getInt("salary");
        }

        return salary == newSalary;
    }

    /**
     * Deletes employee from the database.
     *
     * @return whether the employee was deleted or not.
     */
    public boolean deleteEmployee(int employeeId) throws SQLException {
        // TODO: implement (8)
        // Delete from employees where employee_id = ?

        String query = "DELETE FROM employees WHERE employee_id = ?";
        PreparedStatement statement = getConnection().prepareStatement(query);

        statement.setInt(1, employeeId);
        statement.executeUpdate();


        String idQuery = "select employee_id from employees where employee_id = ?;";

        PreparedStatement salaryStatement = getConnection().prepareStatement(idQuery);
        salaryStatement.setInt(1, employeeId);

        ResultSet resultSet = salaryStatement.executeQuery();

        return !resultSet.next();

    }

}
