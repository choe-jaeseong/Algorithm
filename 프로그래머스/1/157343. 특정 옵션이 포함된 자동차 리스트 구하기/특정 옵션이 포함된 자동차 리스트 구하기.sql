select * from CAR_RENTAL_COMPANY_CAR
where regexp_like(options, "네비게이션")
order by car_id desc;