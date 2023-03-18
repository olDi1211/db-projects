--find the highest 14th salary with OUT duplicates
select min(SALARY)
from (select distinct SALARY from EMPLOYEES order by SALARY desc )
where ROWNUM < 15;



--find employee info who is making 14th highest salary (with duplicates)
-- list salary high to low without duplicates values
select *
from EMPLOYEES
where SALARY = (select min(SALARY)
                from (select *
                from EMPLOYEES order by SALARY desc )
                where ROWNUM < 15);


-- list salary high to low without duplicate values
select distinct SALARY
from EMPLOYEES
order by SALARY desc;

--find the highest 14th salary(removing duplicate values)
select min(SALARY)
from (select distinct SALARY from EMPLOYEES order by SALARY desc )
where ROWNUM < 15;

--find employee info who is making 14th highest salary (with OUT duplicates)
select *
from EMPLOYEES
where SALARY = (select min(SALARY)
                from (select distinct SALARY
                      from EMPLOYEES order by SALARY desc )
                where ROWNUM < 15);