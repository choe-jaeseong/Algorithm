-- 코드를 입력하세요
SELECT a.CATEGORY, sum(SALES) TOTAL_SALES from book_sales b
join BOOK a
on a.book_id = b.book_id
where b.SALES_DATE between '2022-01-01' and '2022-01-31'
group by a.CATEGORY
order by a.CATEGORY

# SELECT CATEGORY, SUM(SALES) AS TOTAL_SALES FROM BOOK_SALES
# INNER JOIN BOOK USING(BOOK_ID)
# WHERE DATE_FORMAT(SALES_DATE, '%Y-%m') = '2022-01'
# GROUP BY 1 
# ORDER BY 1;