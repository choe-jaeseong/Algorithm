select (price - (price % 10000)) PRICE_GROUP, count(*) PRODUCTS
from product
group by PRICE_GROUP
order by PRICE_GROUP
