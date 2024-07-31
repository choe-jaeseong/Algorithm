select mp.MEMBER_NAME, rr.REVIEW_TEXT , date_format(rr.REVIEW_DATE, "%Y-%m-%d") REVIEW_DATE
from rest_review rr
join member_profile mp on rr.member_id = mp.member_id
where rr.MEMBER_ID = (
    select rr.member_id from rest_review rr
    join member_profile mp on rr.member_id = mp.member_id
    group by rr.member_id
    order by count(*) desc
    limit 1
)
order by REVIEW_DATE asc, REVIEW_TEXT asc