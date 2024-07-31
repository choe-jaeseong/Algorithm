# 대여 시작일이 2022년 9월에 속하는 대여 기록에 대해서 
# 대여 기간이 30일 이상이면 '장기 대여' 그렇지 않으면 '단기 대여' 로 표시하는 컬럼(컬럼명: RENT_TYPE)을 추가하여 대여기록을 출력

select HISTORY_ID, CAR_ID,
date_format(START_DATE, '%Y-%m-%d') START_DATE, 
date_format(END_DATE, '%Y-%m-%d') END_DATE,
if(datediff(END_DATE, START_DATE) + 1 >= 30, '장기 대여', '단기 대여') RENT_TYPE
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where year(START_DATE) = 2022 and month(START_DATE) = 9
order by HISTORY_ID desc;