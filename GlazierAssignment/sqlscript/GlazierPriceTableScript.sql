DROP TABLE if exists PRICE;

CREATE TABLE PRICE(	
	CATEGORY VARCHAR(20), 
    PTYPE VARCHAR(20),
	PRICE DECIMAL(8,2)  
);

Insert into PRICE (CATEGORY,PTYPE,PRICE) values ('GLASS','PLAIN',0.03);
Insert into PRICE (CATEGORY,PTYPE,PRICE) values ('FRAME','FRAMETYPE1',1);
Insert into PRICE (CATEGORY,PTYPE,PRICE) values ('FRAME','FRAMETYPE2',2);
Insert into PRICE (CATEGORY,PTYPE,PRICE) values ('FRAME','FRAMETYPE3',3.5);

commit;