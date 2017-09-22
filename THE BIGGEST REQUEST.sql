SELECT * FROM salary
left JOIN employees ON employees.SALARY_ID=salary.ID
left JOIN address ON address.ID=employees.ADDRESS_ID
WHERE employees.ADDRESS_ID<5
order by employees.ID desc
LIMIT 15

