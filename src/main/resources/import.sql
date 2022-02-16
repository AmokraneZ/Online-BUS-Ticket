insert into client values(1,'TOTO@TITI.com','TOTO');
insert into reservation (ID, TRIP_DATE, CLIENT_ID) values (1,'2022-02-16',1);
insert into reservation (ID, TRIP_DATE, CLIENT_ID) values (2,'2022-02-16',1);
insert into BUS values(1,'09:00:00',30,50);
insert into BUS values(2,'09:30:00',50,80);
insert into BUS values(3,'09:00:00',30,50);
insert into BUS values(4,'09:30:00',50,40);
insert into RESERVATION_BUSES values(1,1);
insert into RESERVATION_BUSES values(1,2);

insert into RESERVATION_BUSES values(2,3);
insert into RESERVATION_BUSES values(2,3);