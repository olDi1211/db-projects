select * from testers
union
select * from developers;

select names from testers
union --remove duplicates but ALL value should be the SAME!
select names from developers;

--union all connect union with out remove duplicate values, and with out sorting

select names from developers
minus --MINUS return unique value, which are not appear in second table! Return different value!
select names from testers;

select names from developers
intersect --its sort values and remove duplicates, same value! Return unique values!
select names from testers;

--how to find duplicate names in employees table

select  first_name,count(*)
from employees
group by first_name
having count(*) >1;