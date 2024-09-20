with joined as (
    select ID, EMAIL, SKILL_CODE, code, name, CATEGORY
    from DEVELOPERS
    cross join SKILLCODES
    where SKILL_CODE & code > 0
), A as (
    select "A" GRADE, ID, EMAIL from joined
    where category = "Front End"
    and id in (
        select id from joined
        where name = "Python"
    )
), B as (
    select "B" GRADE, ID, EMAIL from joined
    where name = "C#"
    and id not in (
        select id from A
    )
), C as (
    select "C" GRADE, ID, EMAIL from joined
    where category = "Front End"
    and id not in (
        select id from A
        union
        select id from B
    )
)
select * from A
union
select * from B
union
select * from C
order by GRADE, ID
