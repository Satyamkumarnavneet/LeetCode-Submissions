WITH t AS (
    SELECT * 
    FROM Stadium 
    WHERE people >= 100
)
SELECT * 
FROM t 
WHERE id IN (SELECT id-1 FROM t) AND id IN (SELECT id-2 FROM t) 
UNION
SELECT * 
FROM t 
WHERE id IN (SELECT id-1 FROM t) AND id IN (SELECT id+1 FROM t) 
UNION
SELECT * 
FROM t 
WHERE id IN (SELECT id+1 FROM t) AND id IN (SELECT id+2 FROM t) 
ORDER BY visit_date;
