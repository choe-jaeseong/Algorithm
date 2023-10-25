-- 코드를 입력하세요
SELECT car_id, round(avg(datediff(end_date , start_date)+1),1) as period
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
having period >= 7
order by period desc, car_id desc