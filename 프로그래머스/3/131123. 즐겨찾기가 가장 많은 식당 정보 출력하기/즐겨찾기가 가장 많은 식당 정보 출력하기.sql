-- 코드를 입력하세요
# select FOOD_TYPE, REST_ID, , favorites from rest_info
# from favorites = (SELECT max(sum(favorites)) from REST_INFO group by REST_NAME)

-- 음식 종류별 즐겨찾기수 1등 식당
# select REST_ID, max(favorites), food_type from REST_INFO
# group by FOOD_TYPE

select A.FOOD_TYPE, A.REST_ID, A.REST_NAME, A.FAVORITES from REST_INFO A
join (select REST_ID, max(favorites) FAVORITES, food_type 
        from REST_INFO
        group by FOOD_TYPE
        ORDER BY FOOD_TYPE DESC) B
on A.food_type = B.food_type and A.FAVORITES = B.FAVORITES
order by A.food_type desc