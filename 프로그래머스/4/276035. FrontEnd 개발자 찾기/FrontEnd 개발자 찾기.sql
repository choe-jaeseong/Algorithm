with front as (
    select code from skillcodes
    where category = "Front End"
)

select ID, EMAIL, FIRST_NAME, LAST_NAME from developers
where id in (
    select d.ID
    from developers d
    cross join front f
    where d.skill_code & f.code > 0
)
order by id
