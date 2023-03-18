select * from employees;

select * from departments;


select first_name,last_name,department_name
from employees e left join departments d
on e.department_id = d.department_id;

select CUSTOMER_ID, FIRST_NAME, LAST_NAME, CUSTOMER.address_id, ADDRESS.ADDRESS_ID ADDRESS, PHONE
from CUSTOMER left outer join ADDRESS
on CUSTOMER.ADDRESS_ID = ADDRESS.ADDRESS_ID
where ADDRESS.ADDRESS_ID is null ;

SELECT * FROM customer FULL OUTER JOIN address
ON customer.address_id = address.address_id
where CUSTOMER.ADDRESS_ID is null or
ADDRESS.ADDRESS_ID is null ;