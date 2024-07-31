select "1Q" QUARTER, count(*) ECOLI_COUNT from ECOLI_DATA
where month(DIFFERENTIATION_DATE) between 1 and 3
union all
select "2Q" QUARTER, count(*) ECOLI_COUNT from ECOLI_DATA
where month(DIFFERENTIATION_DATE) between 4 and 6
union all
select "3Q" QUARTER, count(*) ECOLI_COUNT from ECOLI_DATA
where month(DIFFERENTIATION_DATE) between 7 and 9
union all
select "4Q" QUARTER, count(*) ECOLI_COUNT from ECOLI_DATA
where month(DIFFERENTIATION_DATE) between 10 and 12