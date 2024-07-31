-- 수원 지역의 연도 별 평균 미세먼지 오염도와 평균 초미세먼지 오염도를 조회하는 SQL문

select year(YM) YEAR, 
    round(avg(pm_val1), 2) 'PM10', 
    round(avg(pm_val2), 2) 'PM2.5'
from AIR_POLLUTION
where LOCATION2 = '수원'
group by YEAR
order by YEAR