WITH BEST_MEMBER AS (
    SELECT EMP_NO, SUM(SCORE) SUM FROM HR_GRADE
    GROUP BY EMP_NO
    ORDER BY SUM DESC
    LIMIT 1
)

SELECT B.SUM SCORE, H.EMP_NO, H.EMP_NAME, H.POSITION, H.EMAIL 
FROM HR_EMPLOYEES H
JOIN BEST_MEMBER B ON H.EMP_NO = B.EMP_NO
