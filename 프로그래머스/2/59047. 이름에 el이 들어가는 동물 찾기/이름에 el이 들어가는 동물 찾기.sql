select ANIMAL_ID, NAME from animal_ins
where animal_type = 'Dog' and name like "%el%"
order by name