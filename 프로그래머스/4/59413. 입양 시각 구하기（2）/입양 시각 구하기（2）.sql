with recursive A as(
    select 0 as hour
    union all
    select hour+1 from a
    where hour < 23
)

SELECT a.hour HOUR, count(animal_id) COUNT
from A
left outer join ANIMAL_OUTS B on A.hour = hour(B.datetime)
group by a.hour
order by a.hour