# SELECT YEAR(ED.DIFFERENTIATION_DATE) YEAR, (
#     (
#         SELECT MAX(SIZE_OF_COLONY) 
#         FROM ECOLI_DATA
#         WHERE YEAR(DIFFERENTIATION_DATE) = YEAR
#     ) - SIZE_OF_COLONY
# ) YEAR_DEV, 
# ED.ID 
# FROM ECOLI_DATA ED
# ORDER BY YEAR, YEAR_DEV

WITH MAX_COLONY AS (
SELECT YEAR(DIFFERENTIATION_DATE) AS YEAR, MAX(SIZE_OF_COLONY) AS MAX_SIZE
FROM ECOLI_DATA
GROUP BY YEAR)

SELECT 
    YEAR(E.DIFFERENTIATION_DATE) AS YEAR, 
    M.MAX_SIZE - E.SIZE_OF_COLONY AS YEAR_DEV, 
    E.ID
FROM ECOLI_DATA AS E 
    JOIN MAX_COLONY AS M 
    ON YEAR(E.DIFFERENTIATION_DATE) = M.YEAR
ORDER BY YEAR,YEAR_DEV;