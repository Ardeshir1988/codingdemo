create table person (
	person_id integer auto_increment not null,
	person_name varchar(25) not null,
	person_gender varchar(25) not null,
	person_age integer,
   primary key(person_id)
);

create table child (
	child_id integer auto_increment not null,
	child_name varchar(25) not null,
	child_gender varchar(25) not null,
	child_age integer,
	child_school_name varchar(25),
	child_parent_id integer not null,
   primary key(child_id)
);

create table house (
	house_id integer auto_increment not null,
	house_type varchar(10) not null,
	house_room integer not null,
	house_address varchar (15),
	house_person_id integer not null,
   primary key(house_id)
);