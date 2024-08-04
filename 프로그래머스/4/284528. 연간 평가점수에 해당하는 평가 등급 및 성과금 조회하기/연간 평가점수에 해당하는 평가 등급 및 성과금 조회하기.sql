with score as (
    select EMP_NO, avg(SCORE) avg from HR_GRADE
    group by EMP_NO
)

select h.EMP_NO
, h.EMP_NAME
, (
    case when s.avg >= 96 then "S"
         when s.avg >= 90 then "A"
         when s.avg >= 80 then "B"
         else "C"
    end
) GRADE
, h.SAL * (
    case when s.avg >= 96 then 0.2
         when s.avg >= 90 then 0.15
         when s.avg >= 80 then 0.1
         else 0
    end
) BONUS
from HR_EMPLOYEES h
join score s on h.EMP_NO = s.EMP_NO