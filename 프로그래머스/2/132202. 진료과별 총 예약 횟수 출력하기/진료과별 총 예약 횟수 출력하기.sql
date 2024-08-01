# select MCDP_CD "진료과코드", count(*) '5월예약건수' 
# from APPOINTMENT
# where APNT_YMD like "2022-05%"
# group by MCDP_CD
# order by "5월예약건수" asc, MCDP_CD asc

SELECT MCDP_CD AS '진료과코드', COUNT(*) AS '5월예약건수'
FROM APPOINTMENT
where APNT_YMD like '2022-05%'
GROUP BY MCDP_CD
ORDER BY 5월예약건수, MCDP_CD