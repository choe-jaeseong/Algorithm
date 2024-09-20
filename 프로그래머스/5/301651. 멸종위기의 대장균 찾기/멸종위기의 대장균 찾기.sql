with recursive rc as (
    select id, parent_id, 1 as generation
    from ECOLI_DATA 
    where PARENT_ID is null
    
    union all
    
    select e.id, e.parent_id, generation + 1 as generation
    from ECOLI_DATA e
    join rc on e.parent_id = rc.id
)
select count(*) count, generation from rc
where id not in (
    select distinct PARENT_ID from ECOLI_DATA
    where PARENT_ID is not null
)
group by generation;



