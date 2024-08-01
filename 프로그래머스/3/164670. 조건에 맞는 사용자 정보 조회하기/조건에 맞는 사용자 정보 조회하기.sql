# 테이블에서 중고 거래 게시물을 3건 이상 등록한 사용자의 
# 사용자 ID, 닉네임, 전체주소, 전화번호를 조회

with user as (
    select WRITER_ID, count(*) count from USED_GOODS_BOARD
    group by WRITER_ID
    having count >= 3
)

select USER_ID, NICKNAME, concat(CITY, " ",STREET_ADDRESS1, " ", STREET_ADDRESS2) '전체주소', 
concat(substr(TLNO, 1, 3), "-", substr(TLNO, 4, 4), "-", substr(TLNO, 8, 4)) '전화번호'
from USED_GOODS_USER
where USER_ID in (
    select WRITER_ID
    from user
)
order by USER_ID desc