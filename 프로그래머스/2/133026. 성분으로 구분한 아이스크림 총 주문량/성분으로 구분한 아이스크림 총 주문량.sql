select INGREDIENT_TYPE, sum(TOTAL_ORDER) TOTAL_ORDER from FIRST_HALF h
join ICECREAM_INFO i on h.FLAVOR = i.FLAVOR
group by INGREDIENT_TYPE
order by TOTAL_ORDER asc