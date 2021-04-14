package com.vmware.talentboost.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vmware.talentboost.jdbc.data.Job;

public class JobsRepository extends BaseRepository {

    /**
     * Returns a list of all jobs.
     */
    public List<Job> getAllJobs() throws SQLException {
        List<Job> result = new ArrayList<>();

        String query = "select * from jobs;";

        PreparedStatement statement = getConnection().prepareStatement(query);

        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()) {
            String jobId = resultSet.getString("job_id");
            String jobTitle = resultSet.getString("job_title");
            int minSalary = resultSet.getInt("min_salary");
            int maxSalary = resultSet.getInt("max_salary");

            Job job = new Job();
            job.setId(jobId);
            job.setTitle(jobTitle);
            job.setMinSalary(minSalary);
            job.setMaxSalary(maxSalary);

            result.add(job);
        }

        return result;
    }

    /**
     * Returns a list of all jobs with salary in given range.
     */
    public List<Job> getJobsWithSalaryInRange(int minSalary, int maxSalary) throws SQLException {
        // TODO: implement (3)
        List<Job> result = new ArrayList<>();

        String query = "select *" +
                " from jobs " +
                "where min_salary > ? " +
                "and max_salary < ?;";

        PreparedStatement statement = getConnection().prepareStatement(query);

        statement.setInt(1, minSalary);
        statement.setInt(2, maxSalary);

        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()) {
            String jobId = resultSet.getString("job_id");
            String jobTitle = resultSet.getString("job_title");
            int minSalaryQuery = resultSet.getInt("min_salary");
            int maxSalaryQuery = resultSet.getInt("max_salary");

            Job job = new Job();
            job.setId(jobId);
            job.setTitle(jobTitle);
            job.setMinSalary(minSalaryQuery);
            job.setMaxSalary(maxSalaryQuery);

            result.add(job);
        }

        return result;
    }

}
