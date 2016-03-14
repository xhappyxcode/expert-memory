SELECT rights.rightName FROM rights WHERE rights.rightId IN 
(SELECT groupright.rightId FROM groupright 
WHERE groupright.groupId = 1 AND groupright.active = 1) 
AND rights.active = 1