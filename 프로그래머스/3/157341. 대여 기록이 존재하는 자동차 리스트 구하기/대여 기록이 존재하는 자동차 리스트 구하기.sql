# 자동차 종류가 '세단'인 자동차들 중 
# 10월에 대여를 시작한 기록이 있는 
# 자동차 ID 리스트를 출력

select distinct c.CAR_ID from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
join CAR_RENTAL_COMPANY_CAR c on h.car_id = c.car_id
where c.car_type = '세단' and month(start_date) = 10
order by c.CAR_ID desc