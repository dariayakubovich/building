
SELECT EMPLOYEES_ID, avg(SALARY) FROM salary
left JOIN employees ON employees.ID=salary.EMPLOYEES_ID
left JOIN address ON address.ID=employees.ADDRESS_ID
WHERE employees.ADDRESS_ID<3
group by employees.ID
having avg(salary.SALARY)>1000
order by employees.ID desc
LIMIT 5

















