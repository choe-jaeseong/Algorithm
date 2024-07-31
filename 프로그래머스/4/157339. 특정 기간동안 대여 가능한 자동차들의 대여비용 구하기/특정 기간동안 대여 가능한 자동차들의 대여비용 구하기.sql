# WITH NOT_IN_DATA AS (
#     select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY
#     where date_format(start_date, "%Y-%m-%d") < '2022-11-31'
#     and date_format(end_date, "%Y-%m-%d") > '2022-11-01'
#     group by car_id
# ), DISCOUNT AS (
#     SELECT CAR_TYPE, DISCOUNT_RATE 
#     FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
#     WHERE CAR_TYPE IN ('세단', 'SUV') 
#     AND DURATION_TYPE LIKE "30%"
# )

# SELECT * FROM NOT_IN_DATA

# SELECT  C.CAR_ID
# FROM CAR_RENTAL_COMPANY_CAR C
# LEFT JOIN NOT_IN_DATA N
# ON C.CAR_ID = N.CAR_ID
# WHERE N.CAR_ID IS NULL
# AND C.CAR_TYPE IN ('세단', 'SUV')

# SELECT  C.CAR_ID, 
#         C.CAR_TYPE, 
#         ROUND((C.DAILY_FEE * 30) * (100 - (
#             SELECT DISCOUNT_RATE FROM DISCOUNT D
#             WHERE D.CAR_TYPE = C.CAR_TYPE
#         )) / 100) AS FEE
# FROM CAR_RENTAL_COMPANY_CAR C
# LEFT JOIN NOT_IN_DATA N
# ON C.CAR_ID = N.CAR_ID
# WHERE N.CAR_ID IS NULL
# AND C.CAR_TYPE IN ('세단', 'SUV')
# # AND (FEE >= 500000 AND FEE < 2000000)
# ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC

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