# select fp.PRODUCT_ID, fp.PRODUCT_NAME, sum(fo.amount * fp.price) TOTAL_SALES
# from food_order fo
#     join food_product fp
#     on fo.product_id = fp.product_id
# where fo.PRODUCE_DATE like "2022-03%"
# group by fp.product_id
# order by TOTAL_SALES desc, fp.PRODUCT_ID asc

select fo.PRODUCT_ID, fp.PRODUCT_NAME, sum(fo.amount * fp.price) TOTAL_SALES
from food_order fo
join food_product fp on fo.PRODUCT_ID = fp.PRODUCT_ID
where fo.PRODUCE_DATE like "2022-05%"
group by fo.product_id
order by TOTAL_SALES desc, fo.product_id asc;
