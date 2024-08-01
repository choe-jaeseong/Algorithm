with best_member as (
    select EMP_NO, sum(SCORE) SCORE from HR_GRADE
    group by EMP_NO
    order by SCORE desc
    limit 1
)

select b.SCORE, h.EMP_NO, h.EMP_NAME, h.POSITION, h.EMAIL 
from best_member b
join HR_EMPLOYEES h on b.EMP_NO = h.EMP_NO
