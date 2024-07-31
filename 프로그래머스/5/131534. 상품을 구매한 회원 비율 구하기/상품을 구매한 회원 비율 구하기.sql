# 2021년에 가입한 전체 회원들 중 
# 상품을 구매한 회원수와 
# 상품을 구매한 회원의 비율
# (=2021년에 가입한 회원 중 상품을 구매한 회원수 / 2021년에 가입한 전체 회원 수)을 
# 년, 월 별로 출력

select year(s.SALES_DATE) YEAR, month(s.SALES_DATE) MONTH, count(distinct s.user_id) PURCHASED_USERS, 
round(count(distinct s.user_id) / (
    select count(*)
    from user_info
    where year(joined) = 2021
), 1) PUCHASED_RATIO
from online_sale s
join user_info i on s.user_id = i.user_id
where year(i.joined) = 2021
group by year(s.SALES_DATE), month(s.SALES_DATE)
order by year(s.SALES_DATE), month(s.SALES_DATE)