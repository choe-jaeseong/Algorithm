select ANIMAL_ID, NAME, if(SEX_UPON_INTAKE like 'Neutered%' or SEX_UPON_INTAKE like 'Spayed%','O','X') '중성화'
from animal_ins