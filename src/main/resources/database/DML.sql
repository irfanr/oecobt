INSERT INTO pic (id,name) VALUES ('1','irfan');
INSERT INTO pic (id,name) VALUES ('2','herry');
INSERT INTO pic (id,name) VALUES ('3','beni');
INSERT INTO pic (id,name) VALUES ('4','tasya');
INSERT INTO pic (id,name) VALUES ('5','ayu');
INSERT INTO pic (id,name) VALUES ('6','surya');
INSERT INTO pic (id,name) VALUES ('7','arif');
INSERT INTO pic (id,name) VALUES ('8','purba');
INSERT INTO pic (id,name) VALUES ('9','nanda');
INSERT INTO pic (id,name) VALUES ('10','ika');
INSERT INTO pic (id,name) VALUES ('11','kiki');
INSERT INTO pic (id,name) VALUES ('12','kyla');
INSERT INTO pic (id,name) VALUES ('13','wujud');
INSERT INTO pic (id,name) VALUES ('14','andik');

INSERT INTO priority (id,name) VALUES ('1','high');
INSERT INTO priority (id,name) VALUES ('2','medium');
INSERT INTO priority (id,name) VALUES ('3','low');

INSERT INTO severity (id,name) VALUES ('1','critical');
INSERT INTO severity (id,name) VALUES ('2','high');
INSERT INTO severity (id,name) VALUES ('3','medium');
INSERT INTO severity (id,name) VALUES ('4','low');

INSERT INTO status (id,name) VALUES ('1','new');
INSERT INTO status (id,name) VALUES ('2','assigned');
INSERT INTO status (id,name) VALUES ('3','in progress');
INSERT INTO status (id,name) VALUES ('4','fixed');
INSERT INTO status (id,name) VALUES ('5','closed');

INSERT INTO "public"."defect" (id,description,estimate,notes,startdate,pic,priority,severity,status) VALUES (1,'test 1',1.0,null,{ts '2013-03-19 08:00:00.0'},1,1,1,1);
INSERT INTO "public"."defect" (id,description,estimate,notes,startdate,pic,priority,severity,status) VALUES (2,'test 2',2.0,null,{ts '2013-03-19 09:30:00.0'},2,2,2,2);
INSERT INTO "public"."defect" (id,description,estimate,notes,startdate,pic,priority,severity,status) VALUES (3,'test 3',3.0,null,{ts '2013-03-19 10:00:00.0'},3,3,3,3);
