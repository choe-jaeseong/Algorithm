-- 대여중인 차량 id
# SELECT car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# where start_date <= '2022-10-16' and end_date >= '2022-10-16'
# group by car_id

-- 
select A.car_id, case when A.car_id in (SELECT car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY
                                        where start_date <= '2022-10-16' and end_date >= '2022-10-16'
                                        group by car_id) 
                    then '대여중'
                    else '대여 가능'
                    end AVAILABILITY
from (select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY group by car_id) A
order by car_id desc