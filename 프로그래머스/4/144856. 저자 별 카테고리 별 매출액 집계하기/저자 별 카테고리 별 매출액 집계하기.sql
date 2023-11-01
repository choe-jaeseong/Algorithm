-- 2022년 1월에 판매된 도서
# SELECT * from BOOK_SALES
# where sales_date between '2022-01-01' and '2022-01-31'

-- 
# select a.author_id, a.author_name, b.category, b.price
# from author a
# join book b
# on a.author_id = b.author_id

-- 
select AUTHOR_ID, AUTHOR_NAME, CATEGORY, sum(price * sales) TOTAL_SALES
from (select a.author_id, a.author_name, b.category, b.book_id, b.price
        from author a
        join book b
        on a.author_id = b.author_id) A
join (SELECT * from BOOK_SALES
        where sales_date 
        between '2022-01-01' and '2022-01-31') B
on A.book_id = B.book_id
group by A.author_id, A.category
order by 1 asc, 3 desc