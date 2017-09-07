
CREATE TABLE article (
	identifier INTEGER  PRIMARY KEY AUTO_INCREMENT,
	author varchar(255) not null,
	title varchar(255) not null,
	contents varchar(255) not null
);
