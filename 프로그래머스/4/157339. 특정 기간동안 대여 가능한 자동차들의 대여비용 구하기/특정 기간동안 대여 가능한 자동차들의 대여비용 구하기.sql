# select * from CAR_RENTAL_COMPANY_RENTAL_HISTORY

# car_type
# select * from CAR_RENTAL_COMPANY_CAR
# where CAR_TYPE in ('세단','SUV')

-- car_type + 대여가능


# select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# where date_format(end_date, "%Y-%m-%d") < '2022-11-01'
# or '2022-11-31' < date_format(start_date, "%Y-%m-%d")
# group by car_id
# order by car_id


select c.car_id, c.car_type, round((30 * c.DAILY_FEE)*(100 - p.DISCOUNT_RATE)/100) as FEE 
from CAR_RENTAL_COMPANY_CAR c
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p on c.CAR_TYPE = p.CAR_TYPE
where c.CAR_TYPE in ('세단','SUV')
and CAR_ID not in (select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY
                where date_format(start_date, "%Y-%m-%d") < '2022-11-31'
                and date_format(end_date, "%Y-%m-%d") > '2022-11-01'
                group by car_id)
and p.DURATION_TYPE like "30%"
and round((30 * c.DAILY_FEE)*(100 - p.DISCOUNT_RATE)/100) between 500000 and 2000000
order by fee desc, c.car_type asc, c.car_id desc