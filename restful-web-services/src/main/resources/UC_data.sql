
insert into categories values(10002);
insert into cat values(990,'Liquor',10002);
insert into cat values(991,'Cake',10002);
insert into cat values(992,'Cake mixes',10002);

--insert into categories_cat values(1,1);
--insert into categories_cat values(1,2);
--insert into categories_cat values(1,3);
 
insert into amount values(1,'cups','1 1/2');
insert into ing values (1,'Toasted Almonds; chopped',1);

insert into amount values(2,'package','1');
insert into ing values (2,'Yellow cake mix; no pudding',2);

insert into amount values(3,'','4');
insert into ing values(3,'Eggs',3);

insert into head values(10001,'Amaretto Cake',1,10002);

insert into ing_div values(10001,'');

insert into ingredients values(10001);

insert into ingredients_ingdiv values(10001,10001);

insert into directions values(10001,'stepsssssssss');

insert into recipe values(10001,10001,10001,10001);


insert  into ing_div_ing values(10001,1);
insert  into ing_div_ing values(10001,2);
insert  into ing_div_ing values(10001,3);