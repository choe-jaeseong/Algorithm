-- 코드를 입력하세요
SELECT PRODUCT_CODE, sum(p.price * s.SALES_AMOUNT) SALES
from PRODUCT p
    join OFFLINE_SALE s
        on p.product_id = s.product_id
group by PRODUCT_CODE
order by SALES desc, PRODUCT_CODE