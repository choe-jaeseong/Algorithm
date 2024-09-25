SELECT left(product_code, 2) CATEGORY, count(*) PRODUCTS
from product
group by CATEGORY
order by product_code