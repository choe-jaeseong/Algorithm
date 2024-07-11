select b.TITLE, b.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, DATE_FORMAT(r.CREATED_DATE, "%Y-%m-%d")
from USED_GOODS_BOARD b
join USED_GOODS_REPLY r
on b.BOARD_ID = r.BOARD_ID
where b.BOARD_ID in (
    SELECT BOARD_ID from USED_GOODS_BOARD
    where year(CREATED_DATE) = 2022 
    and month(CREATED_DATE) = 10)
order by r.CREATED_DATE, b.TITLE;

# select * from USED_GOODS_REPLY
