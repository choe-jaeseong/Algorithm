select a.APNT_NO, p.PT_NAME, p.PT_NO, a.MCDP_CD, d.DR_NAME, a.APNT_YMD 
from APPOINTMENT a
join PATIENT p on a.PT_NO = p.PT_NO
join DOCTOR d on a.mddr_id = d.dr_id
where APNT_CNCL_YN = 'N' and a.MCDP_CD = 'CS'
and date_format(a.APNT_YMD, '%Y-%m-%d') = '2022-04-13'
order by a.APNT_YMD 
