select * from scrumteam;

--adding new column
alter table SCRUMTEAM add salary integer;

--update existing employees salary
update SCRUMTEAM set SCRUMTEAM.salary = 100000 where EMP_ID = 1;
update SCRUMTEAM set SCRUMTEAM.salary = 90000 where EMP_ID = 2;
update SCRUMTEAM set SCRUMTEAM.salary = 120000 where EMP_ID = 4;

--rename the column
alter table SCRUMTEAM rename column salary to annual_salary;

--delete, drop column
alter table SCRUMTEAM drop column annual_salary;

--how to change table name?
alter table SCRUMTEAM rename to agileteam;

select * from  agileteam;

commit;

--truncate, if we want to delete all data from table, but still keep the table structure, we use truncate
truncate table agileteam;

--if we want to delete the table and data together
drop table agileteam;