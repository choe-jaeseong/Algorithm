with recursive cte as (
    select id, parent_id, 1 as generation
    from ECOLI_DATA
    where parent_id is null
    
    union all
    
    select e.id, e.parent_id, generation + 1 as generation
    from ECOLI_DATA e
    join cte c on e.parent_id = c.id
)

select count(*) COUNT, generation GENERATION
from cte
where id not in (
    select parent_id 
    from ECOLI_DATA
    where parent_id is not null
)
group by generation
order by generation
