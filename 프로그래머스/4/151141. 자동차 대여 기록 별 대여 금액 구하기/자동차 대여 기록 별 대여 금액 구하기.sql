# 자동차 종류가 '트럭'인 자동차의 대여 기록에 대해서 
# 대여 기록 별로 대여 금액(컬럼명: FEE)을 구하여 
# 대여 기록 ID와 대여 금액 리스트를 출력

select h.HISTORY_ID, round((datediff(end_date, start_date) + 1) * c.DAILY_FEE * (100 - ifnull((
    select DISCOUNT_RATE from CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
    where CAR_TYPE = '트럭'
    and DURATION_TYPE = case
                            when (datediff(end_date, start_date) + 1) >= 90 then "90일 이상"
                            when (datediff(end_date, start_date) + 1) >= 30 then "30일 이상"
                            when (datediff(end_date, start_date) + 1) >= 7 then "7일 이상"
                            else null
                        end
), 0)) / 100) FEE
from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
join CAR_RENTAL_COMPANY_CAR c on h.CAR_ID = c.CAR_ID
where c.CAR_TYPE = '트럭'
order by FEE desc, h.HISTORY_ID desc