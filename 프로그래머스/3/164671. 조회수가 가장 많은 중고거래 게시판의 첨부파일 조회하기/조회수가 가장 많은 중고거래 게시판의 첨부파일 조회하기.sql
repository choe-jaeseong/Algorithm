-- 코드를 입력하세요
# SELECT BOARD_ID, max(VIEWS) from USED_GOODS_BOARD

select concat('/home/grep/src/', BOARD_ID, '/', FILE_ID, FILE_NAME, FILE_EXT) FILE_PATH
from USED_GOODS_FILE
where BOARD_ID = (SELECT BOARD_ID
                    from USED_GOODS_BOARD 
                    ORDER BY VIEWS DESC
                    LIMIT 1)
order by FILE_ID desc

# select * from USED_GOODS_FILE
