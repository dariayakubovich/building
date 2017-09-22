
 SELECT * FROM employees LEFT JOIN address ON address.ID =employees.ADDRESS_ID
                         LEFT JOIN region ON region.ID = address.REGION_ID
                         
                         LEFT JOIN salary ON salary.ID =employees.SALARY_ID
                         
                         LEFT JOIN administration_employees ON administration_employees.EMPLOYEES_ID = employees.ID
                         LEFT JOIN construction_employees ON construction_employees.EMPLOYEES_ID = employees.ID
                         LEFT JOIN project_employees ON project_employees.EMPLOYEES_ID = employees.ID
                         
                         LEFT JOIN management ON management.ADMINISTRATION_EMPLOYEES_ID = administration_employees.ID
                         LEFT JOIN economists ON economists.ADMINISTRATION_EMPLOYEES_ID = administration_employees.ID
                         
                         LEFT JOIN builder_workers ON builder_workers.CONSTRUCTION_EMPLOYEES_ID = CONSTRUCTION_EMPLOYEES.ID
                         LEFT JOIN machine_operators ON machine_operators.CONSTRUCTION_EMPLOYEES_ID = CONSTRUCTION_EMPLOYEES.ID
                         
                         LEFT JOIN engineers ON engineers.PROJECT_EMPLOYEES_ID = PROJECT_EMPLOYEES.ID
                         LEFT JOIN managers_project ON managers_project.PROJECT_EMPLOYEES_ID = PROJECT_EMPLOYEES.ID
                         
order by employees.ID asc