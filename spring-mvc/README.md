# Tasks API

1. Implement the given API
2. Add integration tests for `GET /tasks/:id` and `POST /tasks`.
   Make sure that you cover some negative cases as well.
   Hint: Some of the test cases will fail.
   Next lab we are going to see how to fix them.
3. Discussion: How we can use the API to create new application.
   Or to integrate it in existing one.
   The implemented service is almost ready for production use.
   Almost. Something obvious is that for production use we should not
   use in-memory database. But there are other not so obvious issues.
   Can you spot them?

## Get All Tasks

Returns list of all tasks.
```
GET /tasks
```

### Parameters

| Name    | Type        | Description                                                    |
|---------|-------------|----------------------------------------------------------------|
| status  | TaskStatus  | Optional, if provided returns only tasks with the given status |

### Response

```
Status: 200 OK

[
    {
        "id": 1,
        "title": "Read the README file",
        "details": "Read the assignment.",
        "completed": true
    },
    {
        "id": 2,
        "title": "Implement get all tasks endpoint",
        "details": "Implement GET /tasks.",
        "completed": false
    }
]
```

## Get Task

Returns single tasks.
If no task with the given id is found 404 NOT FOUND is returned.
```
GET /tasks/:id
```

### Response

```
Status: 200 OK

{
    "id": 1,
    "title": "Read the README file",
    "details": "Read the assignment.",
    "completed": true
}
```

## Add Task

Creates new task.
```
POST /tasks
```

### Parameters

| Name      | Type    | Description                                    |
|-----------|---------|------------------------------------------------|
| title     | String  | The title of the task                          |
| details   | String  | Detailed description of the task               |
| completed | boolean | Indicates whether the task is completed or not |

#### Example

```
{
    "title": "Implement create new task API",
    "details": "Implement POST /tasks",
    "completed": false
}
```

### Response

```
STATUS: 204 NO CONTENT
```

## Update Task

Edits existing task.
```
PUT /tasks/:id 
```

### Parameters

| Name      | Type    | Description                                    |
|-----------|---------|------------------------------------------------|
| title     | String  | The title of the task                          |
| details   | String  | Detailed description of the task               |
| completed | boolean | Indicates whether the task is completed or not |

#### Example

```
{
    "title": "Implement get all tasks endpoint",
    "details": "Implement GET /tasks.",
    "completed": true
}
```

### Response

```
STATUS: 204 NO CONTENT
```

## Delete Task

Removes existing task.
```
DELETE /tasks/:id
```

### Response

```
STATUS: 204 NO CONTENT
```
