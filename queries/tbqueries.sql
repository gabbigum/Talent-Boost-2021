2/3
SELECT first_name || ' ' || last_name AS "Full Name" , salary
FROM employees;

4
SELECT first_name || ' ' || last_name AS "Full Name"
FROM employees
WHERE salary > 15000;


6
select first_name || ' ' || last_name as "Full Name"
from employees
where job_id = 'AD_PRES';

7
select *
from employees
where hire_date > '1999-01-01';

8
select *
from employees
where commission_pct is NULL;

9
select salary, last_name
from employees
where first_name = 'Peter';

10
select first_name || ' ' || last_name as "Full Name",
12 * salary as "Yearly salary"
from employees
where job_id='IT_PROG';


11
select *
from countries
where region_id between 1 AND 3;

12
select job_title
from jobs
where min_salary between 1000 and 3000;


13
select *
from employees
where commission_pct is null
and salary between 3000 and 10000
and department_id = 30;

14
select *
from employees
where first_name like 'S%'
and last_name like 'S%';


15
select first_name, job_id
from employees
where salary > 5000
and department_id = 50
and first_name like 'A%';

16
select * 
from employees
where salary > 2000
and first_name like '%z%'
or last_name like '%z%';

17
select first_name || ' ' || last_name as "Full Name"
from employees
where job_id = 'AD_PRES'
or job_id = 'IT_PROG'
or job_id = 'ST_CLERK';

18
select job_id
from employees
where commission_pct is not null;

19
select * 
from jobs
order by job_title asc;

20
select * 
from jobs
order by max_salary desc;

21
select first_name || ' ' || last_name as "Full Name", salary
from employees
order by hire_date;

22
select country_name
from countries
order by country_name asc;

23
select first_name || ' ' || last_name as "Full Name"
from employees
where commission_pct is null and
salary between 2500 and 9000 
and job_id ='ST_MAN' or job_id='IT_PROG';

24
select first_name || ' ' || last_name as "Full Name", salary
from employees
where first_name = 'David'
order by last_name, salary asc;

25
select *
from employees
where employee_id between 100 and 130 
and manager_id=100 or manager_id=120
and hire_date > '1998-01-01'
order by salary asc;