-- 코드를 입력하세요
# 2022년 3월의 
# 오프라인/온라인 상품 판매 데이터의 
# 판매 날짜, 
# 상품ID, 
# 유저ID, 
# 판매량

# SELECT date_format(SALES_DATE, "%Y-%m-%d") SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
# from ONLINE_SALE

# union all

# SELECT date_format(SALES_DATE, "%Y-%m-%d") SALES_DATE, PRODUCT_ID, NULL as USER_ID, SALES_AMOUNT
# from ONLINE_SALE 

# where SALES_DATE between '2022-03-01' and '2022-03-31'
# order by SALES_DATE, PRODUCT_ID, USER_ID

SELECT date_format(sales_date, '%Y-%m-%d') sales_date, product_id, user_id, sales_amount
from online_sale
where date_format(sales_date, '%Y-%m') = '2022-03'
union all
select date_format(sales_date, '%Y-%m-%d')sales_date, product_id, NULL as user_id, sales_amount
from offline_sale 
where date_format(sales_date, '%Y-%m') = '2022-03'
order by sales_date, product_id, user_id