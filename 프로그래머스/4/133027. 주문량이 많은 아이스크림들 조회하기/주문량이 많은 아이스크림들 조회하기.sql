-- 코드를 입력하세요
select flavor
from (
    SELECT *
    from FIRST_HALF
    union all
    SELECT *
    from JULY
) a
group by FLAVOR
order by sum(total_order) desc
limit 3