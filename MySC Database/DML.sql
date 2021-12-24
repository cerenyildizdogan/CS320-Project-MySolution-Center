delete from Usertypes;
delete from Users;
delete from Services;
delete from Requests;

insert into Usertypes (usertypename)
values ("Resident");
insert into Usertypes (usertypename)
values ("Dormitory Official");

insert into Users (usertypeid, username, userpassword, email, gsm, roomNumber, registirationdate)											
values (1, "Heves Altunkalem", "kWZRLlllQJAspbOTjCcpgw==", "heves.altunkalem@ozu.edu.tr","05111111111","324", "2019-03-12 08:12:23");
insert into Users (usertypeid, username, userpassword, email, gsm, roomNumber, registirationdate)											
values (1, "Kerim Sarmini", "gN90fn9GTEJ7U7HL5W74Hg==", "kerim.sarmini@ozu.edu.tr","05214113111","224", "2019-05-22 10:13:23");
insert into Users (usertypeid, username, userpassword, email, gsm, roomNumber, registirationdate)											
values (1, "Kerem Selimoglu", "jFMa3t6yhfjJ0O67S+xQVw==", "kerem.selimoglu@ozu.edu.tr","05332511125","123", "2018-10-11 15:12:23");
insert into Users (usertypeid, username, userpassword, email, gsm,roomNumber, registirationdate)											
values (1, "Melike Akal", "oM3f4/NJGuM1ajB+8W5v4g==", "melike.akal@ozu.edu.tr","05389811111","119", "2019-03-12 08:12:23");
insert into Users (usertypeid, username, userpassword, email, gsm, roomNumber, registirationdate)											
values (1, "Ege Hekimoglu", "QSU06xUPoI3c+WOzGgzP6w==", "ege.hekimoglu@ozu.edu.tr","05389813261","225", "2018-02-11 08:12:23");
insert into Users (usertypeid, username, userpassword, email, gsm, roomNumber, registirationdate)											
values (1, "Meltem Şengul", "TLnkLEuRAD8VX2qOg6fDIA==", "meltem.sengul@ozu.edu.tr","05332811111","129", "2019-07-19 10:12:23");
insert into Users (usertypeid, username, userpassword, email, gsm, roomNumber, registirationdate)											
values (1, "Berkay Onal", "kSGgLu7Lvcpm0R2af3JJVQ==", "berkay.onal@ozu.edu.tr","05313451111","225", "2016-03-12 08:12:23");
insert into Users (usertypeid, username, userpassword, email, gsm, roomNumber, registirationdate)											
values (1, "Bartu Kose", "4q+K62uYRHi4DfFl1BP8NA==", "bartu.koseahmetoglu@ozu.edu.tr","05389845121","227", "2018-08-12 11:42:23");
insert into Users (usertypeid, username, userpassword, email, gsm, roomNumber, registirationdate)											
values (1, "Eser Sahiner", "aGbjKnxA/gVAeJnceH3h2g==", "eser.sahiner@ozu.edu.tr","05453545121","227", "2018-08-12 11:42:23");
insert into Users (usertypeid, username, userpassword, email, gsm, roomNumber, registirationdate)											
values (1, "Omer Tunayli", "+Kk9As/qDJsQIKCuAEvt+w==", "omer.tunayli@ozu.edu.tr","05319845121","225", "2018-08-12 11:42:23");
insert into Users (usertypeid, username, userpassword, email, gsm, roomNumber, registirationdate)											
values (1, "Dila Kurum", "S9qB6d7hNrEQHOjY2OOP6g==", "dila.kurum@ozu.edu.tr","05239845121","128", "2018-08-12 11:42:23");
insert into Users (usertypeid, username, userpassword, email, gsm, roomNumber, registirationdate)											
values (1, "Ece Cakir", "0Byfrzdbn0Z+frkiWmG3XA==", "ece.cakir@ozu.edu.tr","05338875121","127", "2018-12-30 11:42:23");
insert into Users (usertypeid, username, userpassword, email, gsm, roomNumber, registirationdate)											
values (1, "Anil Turgut", "49dkxuPUDKqe5n2LNzagng==", "anil.turgut@ozu.edu.tr","05373031111","514", "2016-02-23 12:12:23");
insert into Users (usertypeid, username, userpassword, email, gsm, roomNumber, registirationdate)											
values (1, "Ceren Yildizdogan","RhzcI2Z3i5I8Z8P5HE8/sQ==", "ceren.yildizdogan@ozu.edu.tr","05322702129","151",  "2016-09-01 12:03:12");
insert into Users (usertypeid, username, userpassword, email, gsm, roomNumber, registirationdate)											
values (1, "Ayca İdil", "fA/R7KR3+Kfaw66jjPvxvA==", "idil.kaya@ozu.edu.tr","05388875121","121", "2018-12-30 11:42:23");
insert into Users (usertypeid, username, userpassword, email, gsm,registirationdate)											
values (2, "Management", "LjQ9uabgW9xo3NMDAkmdCw==", "dormitoryofficial@ozu.edu.tr","4441122", "2012-12-01 09:42:23");


insert into Services (servicename, serviceExpl)
values ("Furniture", "If there is a problem with the furniture in the room");
insert into Services (servicename, serviceExpl)
values ("Bathroom", "If there is a problem with the bathroom in the room");
insert into Services (servicename, serviceExpl)
values ("Electronics", "If there is a problem with the electronical devices or rooms' electronics");
insert into Services (servicename, serviceExpl)
values ("WiFi", "If there is a problem with internet access");
insert into Services (servicename, serviceExpl)
values ("Laundry Room", "If there is a problem with laundry room");
insert into Services (servicename, serviceExpl)
values ("Cleaning", "If you want to clean your room");
insert into Services (servicename, serviceExpl)
values ("Heating", "If there is a problem with heating of the room");
insert into Services (servicename, serviceExpl)
values ("Others", "Please State the problem");


insert into Requests (userid, serviceid, requestExpl, requestedDate, requestStatus, requestCompletedDate)
values (2, 3, "Electrics are not working properly", "2020-10-22 11:32:30",1,"2020-10-24 11:32:30");
insert into Requests (userid, serviceid, requestExpl, requestedDate, requestStatus, requestCompletedDate)
values (3, 4, "WiFi is not working properly", "2020-10-25 21:32:30",1,"2020-10-28 10:32:30");
insert into Requests (userid, serviceid, requestExpl, requestedDate, requestStatus, requestCompletedDate)
values (1, 6, "I want my room to be cleaned", "2020-10-15 10:32:30",1,"2020-10-16 11:32:30");  
insert into Requests (userid, serviceid, requestExpl, requestedDate, requestStatus, requestCompletedDate)
values (4, 2, "My bathroom is leaking water out", "2019-10-18 08:45:30",1,"2019-10-19 11:32:30"); 
insert into Requests (userid, serviceid, requestExpl, requestedDate, requestStatus, requestCompletedDate)
values (6, 3, "Air conditioner is not working", "2020-06-15 14:32:30",1,"2020-06-20 16:42:30"); 
insert into Requests (userid, serviceid, requestExpl, requestedDate, requestStatus, requestCompletedDate)
values (7, 4, "Internet is very slow", "2019-10-18 08:45:30",1,"2019-10-19 11:32:30"); 
insert into Requests (userid, serviceid, requestExpl, requestedDate, requestStatus, requestCompletedDate)
values (3, 5, "Laundry machine is not available", "2018-02-10 10:32:30",1,"2018-03-20 11:32:30"); 
insert into Requests (userid, serviceid, requestExpl, requestedDate, requestStatus, requestCompletedDate)
values (2, 6, "I want my room to be cleaned", "2020-10-15 10:32:30",1,"2020-10-16 11:32:30");
insert into Requests (userid, serviceid, requestExpl, requestedDate, requestStatus, requestCompletedDate)
values (3, 1, "My lamp is broken", "2020-10-15 10:32:30",1,"2020-10-16 11:32:30"); 
insert into Requests (userid, serviceid, requestExpl, requestedDate, requestStatus, requestCompletedDate)
values (4, 1, "My bed is not comfortable", "2020-10-23 10:32:30",1,"2020-10-28 11:32:30"); 
insert into Requests (userid, serviceid, requestExpl, requestedDate, requestStatus, requestCompletedDate)
values (5, 8, "Private situation", "2020-10-15 10:32:30",1,"2020-10-16 11:32:30"); 
insert into Requests (userid, serviceid, requestExpl, requestedDate, requestStatus, requestCompletedDate)
values (10, 2, "Shower is problematic", "2020-04-12 18:32:30",1,"2020-04-18 11:32:30"); 
insert into Requests (userid, serviceid, requestExpl, requestedDate, requestStatus, requestCompletedDate)
values (11, 3, "Electric is being cut continuously", "2020-10-28 10:32:30",1,"2020-10-29 11:32:30"); 
insert into Requests (userid, serviceid, requestExpl, requestedDate, requestStatus, requestCompletedDate)
values (12, 7, "Room is so cold", "2020-10-15 10:32:30",1,"2020-10-16 11:32:30"); 
insert into Requests (userid, serviceid, requestExpl, requestedDate, requestStatus,requestCompletedDate)
values (3, 5, "Laundry machine is not working", "2021-10-15 11:32:30",0, NULL);