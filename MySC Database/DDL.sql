DROP TABLE IF EXISTS Requests;							
DROP TABLE IF EXISTS Users;							
DROP TABLE IF EXISTS Services;							
DROP TABLE IF EXISTS Usertypes;		


CREATE TABLE Usertypes (							
usertypeid          int           NOT NULL AUTO_INCREMENT,							
usertypename        varchar(20)   NOT NULL UNIQUE,							
							
PRIMARY KEY (usertypeid)							
);							
				
CREATE TABLE Users (							
							
userid              int            NOT NULL AUTO_INCREMENT,							
usertypeid          int            NOT NULL,							
username            varchar(100)    NOT NULL UNIQUE,							
userpassword        varchar(100)   NOT NULL,																			
email               varchar(100)   NOT NULL UNIQUE,													
gsm                 varchar(11)    NOT NULL UNIQUE,							
roomNumber       	varchar(10)	   ,											
registirationdate   timestamp      DEFAULT CURRENT_TIMESTAMP ,							
							
PRIMARY KEY (userid),							
FOREIGN KEY (usertypeid) REFERENCES Usertypes(usertypeid) on delete cascade							
);							
		

CREATE TABLE Services (

serviceid			int				NOT NULL AUTO_INCREMENT,
servicename			varchar(50)		NOT NULL,
serviceExpl			varchar(200)	NOT NULL,

PRIMARY KEY (serviceid)
);

CREATE TABLE Requests (

requestid int NOT NULL AUTO_INCREMENT,
userid int 	NOT NULL,
serviceid int NOT NULL,
requestExpl varchar(200) NOT NULL,
requestedDate timestamp DEFAULT CURRENT_TIMESTAMP,
requestStatus int	DEFAULT 0,
requestCompletedDate	timestamp DEFAULT CURRENT_TIMESTAMP,

PRIMARY KEY (requestid),
FOREIGN KEY (userid) REFERENCES Users(userid) on delete cascade,	
FOREIGN KEY (serviceid) REFERENCES Services(serviceid) on delete cascade	

);