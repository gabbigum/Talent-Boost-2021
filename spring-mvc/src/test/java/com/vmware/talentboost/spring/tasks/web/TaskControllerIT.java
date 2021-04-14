package com.vmware.talentboost.spring.tasks.web;

import java.util.List;

import com.vmware.talentboost.spring.tasks.impl.JdbcRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.vmware.talentboost.spring.tasks.data.Task;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TaskControllerIT {

    @Autowired
    private JdbcRepository respository;

    @Autowired
    private TestRestTemplate restTemplate;

    private void insertData() {
        Task task = new Task();
        task.setTitle("Implement get all tasks endpoint.");
        task.setDetails("Implement /GET task.");
        task.setCompleted(false);
        task.setId(1);
        respository.addTask(new Task());
    }

    @Test
    public void testGetAllTasks() {
        insertData();
        // Because of the type erasure in Java, List and List<Task> are the same.
        // ParameterizedTypeReference is workaround this. Check its Javadoc
        // for more details.
        // RestTemplate provides some shortcut methods such as getForEntity()
        // but they do not accept ParameterizedTypeReference.

        ResponseEntity<List<Task>> responseEntity = restTemplate.exchange("/tasks",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Task>>() {
                });
        HttpStatus responseStatus = responseEntity.getStatusCode();
        final List<Task> taskList = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseStatus);
        assertNotNull(taskList);
        assertFalse(taskList.isEmpty());
    }

    @Test
    public void testGetTaskById() {
        ResponseEntity<Task> responseEntity =
                restTemplate.exchange(
                        "/tasks/1",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<Task>() {
                        }
                );
        HttpStatus responseStatus = responseEntity.getStatusCode();
        final Task task = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseStatus);
        assertNotNull(task);
    }

    @Test
    public void testGetTaskByInvalidId() {
        ResponseEntity<Task> responseEntity =
                restTemplate.exchange(
                        "/tasks/2",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<Task>() {
                        }
                );
        HttpStatus responseStatus = responseEntity.getStatusCode();

        assertNotEquals(HttpStatus.OK, responseStatus);
    }

    @Test
    public void testGetTaskByStringInvalidId() {
        ResponseEntity<Task> responseEntity =
                restTemplate.exchange(
                        "/tasks/invalidId",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<Task>() {
                        }
                );
        HttpStatus responseStatus = responseEntity.getStatusCode();

        assertNotEquals(HttpStatus.OK, responseStatus);
    }


    @Test
    public void testGetAllTasksIfNoneExist() {
        ResponseEntity<List<Task>> responseEntity = restTemplate.exchange("/tasks",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Task>>() {
                });
        HttpStatus responseStatus = responseEntity.getStatusCode();
        final List<Task> taskList = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseStatus);
        assertNull(taskList);
        assertTrue(taskList.isEmpty());
    }

/*
    @Test
    public void testPostTask() {
        RequestEntity<Task> requestEntity =
        ResponseEntity<Task> responseEntity =
                restTemplate.exchange(
                        "/tasks",
                        HttpMethod.POST,
                        null,
                        new ParameterizedTypeReference<Task>() {}
                        );

        HttpStatus responseStatus = responseEntity.getStatusCode();
        final Task task = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseStatus);
        assertNotNull(task);
    }
*/


}
