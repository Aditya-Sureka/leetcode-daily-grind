# Write your MySQL query statement below
SELECT unique_id, name
FROM Employees AS e
LEFT JOIN EmployeeUNI AS eu
ON eu.id = e.id;