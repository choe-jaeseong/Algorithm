SELECT MCDP_CD AS '진료과코드', COUNT(*) AS '5월예약건수'
FROM APPOINTMENT
where APNT_YMD like '2022-05%'
GROUP BY MCDP_CD
ORDER BY 5월예약건수, MCDP_CD