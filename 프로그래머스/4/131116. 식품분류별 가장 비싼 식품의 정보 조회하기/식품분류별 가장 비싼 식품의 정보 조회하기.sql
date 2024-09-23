select a.CATEGORY, a.price, a.product_name from food_product a
join (SELECT CATEGORY, max(price) price from food_product
        group by CATEGORY
        having CATEGORY in ('과자', '국', '김치', '식용유')) b
on a.CATEGORY = b.CATEGORY and a.price = b.price
order by a.price desc