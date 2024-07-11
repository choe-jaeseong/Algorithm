SELECT USER_ID, PRODUCT_ID FROM ONLINE_SALE
WHERE USER_ID 
GROUP BY USER_ID, PRODUCT_ID
HAVING COUNT(*) > 1
ORDER BY USER_ID ASC, PRODUCT_ID DESC;