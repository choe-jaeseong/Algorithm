-- 코드를 입력하세요
SELECT  year(sales_date) YEAR, month(sales_date) MONTH, 
        count(distinct s.user_id) PUCHASED_USERS,
        round(count(distinct s.user_id) / (SELECT COUNT(*) FROM USER_INFO WHERE YEAR(joined) = 2021), 1) PUCHASED_RATIO
from USER_INFO u join ONLINE_SALE s on u.user_id = s.user_id and year(u.joined) = 2021
group by year(sales_date), month(sales_date)
order by 1, 2