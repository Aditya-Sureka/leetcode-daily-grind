# Write your MySQL query statement below
SELECT p.Product_id, IFNULL(ROUND(SUM(units * price) / SUM(units), 2), 0)  AS average_price
FROM Prices AS  p
LEFT JOIN UnitsSold AS us
ON p.Product_id = us.Product_id
AND us.purchase_date BETWEEN p.start_date AND p.end_date
GROUP BY p.Product_id;