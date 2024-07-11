select B.INGREDIENT_TYPE, sum(A.TOTAL_ORDER) as TOTAL_ORDER from FIRST_HALF A
join ICECREAM_INFO B on A.FLAVOR = B.FLAVOR
group by INGREDIENT_TYPE
order by TOTAL_ORDER