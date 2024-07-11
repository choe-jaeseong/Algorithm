SELECT ID, IFNULL(
                    (SELECT COUNT(*) FROM ECOLI_DATA
                     WHERE PARENT_ID = E.ID
                     GROUP BY PARENT_ID
                    ), 
                  0) CHILD_COUNT
FROM ECOLI_DATA E;
