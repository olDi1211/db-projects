-- how to find employees information who is making highest salary in the company
-- subquery solution in one shot
select *
from EMPLOYEES
where SALARY = (select max(SALARY) from EMPLOYEES);

--get me the highest salary
select max(SALARY)
from EMPLOYEES;

--highest salary employee information
select *
from EMPLOYEES
where SALARY = 24000;

--finding second highest salary
select *
from EMPLOYEES
where SALARY = (select max(SALARY) from EMPLOYEES);

--highest after 24k
select max(SALARY)
from EMPLOYEES;

--highest after 24k
select max(SALARY)
from EMPLOYEES
where SALARY < (select max(SALARY) from EMPLOYEES);

--employee information of who is making second highest salary
select *
from EMPLOYEES
where SALARY = (select max(SALARY) from EMPLOYEES where SALARY < (select max(SALARY) from EMPLOYEES));


-------------------------
select *
from EMPLOYEES
order by SALARY desc;

select *
from EMPLOYEES
where ROWNUM < 11;


--list of the employees who is making top 10 salary


-- get the first 10 people then order them high to low based salary
select *
from EMPLOYEES
where ROWNUM < 11
order by SALARY desc ;

-- order the all employees based on there salary from high to low then display first 10 result
select *
from (select * from EMPLOYEES order by SALARY desc)
where ROWNUM < 11;
