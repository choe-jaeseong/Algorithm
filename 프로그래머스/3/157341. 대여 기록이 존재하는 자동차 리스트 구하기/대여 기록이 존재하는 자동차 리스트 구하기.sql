-- 코드를 입력하세요
SELECT DISTINCT h.car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
where h.car_id in (select CAR_ID from CAR_RENTAL_COMPANY_CAR where CAR_TYPE = "세단")
    and START_DATE like "2022-10%"
order by CAR_ID DESC
    

# select CAR_ID from CAR_RENTAL_COMPANY_CAR where CAR_TYPE = "세단"