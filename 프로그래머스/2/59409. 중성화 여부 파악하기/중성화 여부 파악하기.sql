-- 코드를 입력하세요
SELECT  ANIMAL_ID, NAME, 
        # IF(SEX_UPON_INTAKE REGEXP ('Neutered|Spayed'),'O','X') AS 중성화   
        if(SEX_UPON_INTAKE regexp "Spayed|Neutered", "O", "X") "중성화"
        # case when SEX_UPON_INTAKE like "%Neutered%" or SEX_UPON_INTAKE like "%Spayed%" then "O" else "X" end "중성화"
from ANIMAL_INS
order by ANIMAL_ID