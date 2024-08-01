# '통풍시트', '열선시트', '가죽시트' 중 하나 이상의 옵션이 포함된 자동차가 
# 자동차 종류 별로 몇 대

select CAR_TYPE, count(*) CARS from CAR_RENTAL_COMPANY_CAR
where regexp_like(OPTIONS, '통풍시트|열선시트|가죽시트')
group by CAR_TYPE
order by CAR_TYPE ASC