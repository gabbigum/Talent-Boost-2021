package com.vmware.talentboost.spring.tasks.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vmware.talentboost.spring.tasks.IRepository;
import com.vmware.talentboost.spring.tasks.data.Task;

@Repository
public class JdbcRepository implements IRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Task> getAllTasks() {
        return jdbcTemplate.query("SELECT * FROM Tasks", this::mapTaskRow);
    }

    @Override
    public List<Task> getTasksByCompletionStatus(boolean completed) {
        return jdbcTemplate.query("SELECT * FROM Tasks WHERE completed = ?", this::mapTaskRow, completed);
    }

    @Override
    public Task getTask(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Tasks WHERE id = ?", this::mapTaskRow, id);
    }

    @Override
    public void addTask(Task task) {
        jdbcTemplate.update("INSERT INTO Tasks (title, details, completed) VALUES (?, ?, ?)",
            task.getTitle(), task.getDetails(), task.isCompleted());
    }

    @Override
    public void updateTask(int id, Task task) {
        jdbcTemplate.update("UPDATE Tasks SET title = ?, details = ?, completed = ? WHERE id= ?",
            task.getTitle(), task.getDetails(), task.isCompleted(), id);
    }

    @Override
    public void deleteTask(int id) {
        jdbcTemplate.update("DELETE FROM Tasks WHERE id = ?", id);
    }

    private Task mapTaskRow(ResultSet rs, int rowNum) throws SQLException {
        Task result = new Task();
        result.setId(rs.getInt("id"));
        result.setTitle(rs.getString("title"));
        result.setDetails(rs.getString("details"));
        result.setCompleted(rs.getBoolean("completed"));

        return result;
    }
}
