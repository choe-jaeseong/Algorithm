# select MEMBER_ID, count(*) count 
# from REST_REVIEW
# group by MEMBER_ID
# order by count desc
# limit 1

select p.MEMBER_NAME, r.REVIEW_TEXT, date_format(r.REVIEW_DATE , "%Y-%m-%d") REVIEW_DATE
from REST_REVIEW r
join MEMBER_PROFILE p on r.MEMBER_ID = p.MEMBER_ID
where r.MEMBER_ID = (select MEMBER_ID
                    from REST_REVIEW
                    group by MEMBER_ID
                    order by count(*) desc
                    limit 1)
order by 3 asc, 2 asc