CREATE TABLE IF NOT EXISTS Tasks(
    id INT IDENTITY,
    title VARCHAR(128) NOT NULL,
    details CLOB,
    completed BOOLEAN NOT NULL DEFAULT false
);
