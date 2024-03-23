select ID, LENGTH from fish_info
where length is not null
order by length DESC, ID ASC
limit 10;