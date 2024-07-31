select a.FLAVOR
from (
    select *
    from first_half
    union all
    select * from july
) a
group by a.FLAVOR
order by sum(a.total_order) desc
limit 3