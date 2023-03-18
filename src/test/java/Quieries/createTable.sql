create table ScrumTeam(
    Emp_ID INTEGER primary key,
    FirstName varchar(30) not null,
    LastName varchar(30),
    JobTitle varchar(20)
);

select * from ScrumTeam;

insert into ScrumTeam (Emp_ID, FirstName, LastName, JobTitle)
values (1,'Severus','Snape','Tester');

insert into ScrumTeam (Emp_ID, FirstName, LastName, JobTitle)
values (2,'Sirius','Black','Tester');

insert into ScrumTeam values (3,'Harry','Potter','Developer');

insert into ScrumTeam values (4,'Dmytro','Oleksiiuk','Wizard');

commit;

select * from ScrumTeam;

update ScrumTeam
set JobTitle = 'Tester'
WHERE Emp_ID = 4;

select * from ScrumTeam;

DELETE from ScrumTeam
where Emp_ID = 3;

select * from ScrumTeam;

commit;
