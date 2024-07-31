with maxview as (
    select BOARD_ID, VIEWS
    from USED_GOODS_BOARD
    order by VIEWS desc
    limit 1
)

select concat('/home/grep/src/', BOARD_ID, '/', FILE_ID, FILE_NAME, FILE_EXT) FILE_PATH
from USED_GOODS_FILE
where BOARD_ID in (
    select BOARD_ID 
    from maxview
)
order by FILE_ID desc