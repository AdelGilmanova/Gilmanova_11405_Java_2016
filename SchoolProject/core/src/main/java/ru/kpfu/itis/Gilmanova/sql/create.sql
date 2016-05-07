CREATE TABLE "students"(
	"id" INT NOT NULL,
	"last_name" VARCHAR(50), 
    "first_name"  VARCHAR(50),
    "class_id" integer,
	"user_id" integer,
	PRIMARY KEY("id")
	FOREIGN KEY ("class_id") REFERENCES "classes"("id")
	FOREIGN KEY ("user_id") REFERENCES "users"("id")
	);
	
CREATE TABLE "teachers"(
	"id" INT NOT NULL,
	"last_name"  VARCHAR(50) NOT NULL,
    "first_name"  VARCHAR(50) NOT NULL,
	"second_name" VARCHAR(50) NOT NULL,
	"gender" VARCHAR(10) NOT NULL,
	"birthday" DATE NOT NULL,
	"user_id" integer,
	PRIMARY KEY("id")
	FOREIGN KEY ("user_id") REFERENCES "users"("id")
	);

CREATE TABLE "objects"(
	"id" INT NOT NULL,
	"object" VARCHAR(50) NOT NULL,
	PRIMARY KEY("id")
	);

CREATE TABLE "classes"(
	"id" INT NOT NULL,
	"teacher_id" INT NOT NULL,
    "class" VARCHAR(50) NOT NULL,
	PRIMARY KEY("id"),
	FOREIGN KEY ("teacher_id") REFERENCES "teachers"("id")
	);
	
CREATE TABLE "questions"(
	"id" INT NOT NULL,
    "theme" VARCHAR(500) NOT NULL,
    "question_content" VARCHAR(1000) NOT NULL,
	"email" VARCHAR(100) NOT NULL,
	"question_name" VARCHAR(100) NOT NULL,
	"question_time" TIME NOT NULL,
	"question_date" DATE NOT NULL,
	PRIMARY KEY("id")
	);
	
CREATE TABLE "users"(
  id integer NOT NULL,
  username character varying(50) NOT NULL,
  password character varying(50) NOT NULL,
  role character varying(100),
  enable boolean,
  PRIMARY KEY("id")
);
	
CREATE TABLE "comments"(
    "id" integer primary key,
    "user_name" VARCHAR(50),
    "content" VARCHAR(1000),
    "time" TIME NOT NULL,
    "date" DATE NOT NULL
);	

create table teacher_object(
	id integer not null primary key,
	teacher_id integer,
	object_id integer,
	FOREIGN KEY ("teacher_id") REFERENCES "teachers"("id"),
	FOREIGN KEY ("object_id") REFERENCES "objects"("id")
);

CREATE TABLE home_work(
	id integer NOT NULL PRIMARY KEY,
	class_teacher_object_id integer,
	home_work varchar,
	"time" time,
	"date" date, 
	FOREIGN KEY ("class_teacher_object_id") REFERENCES "class_teacher_object"("id")
);

create table class_teacher_object(
	id integer not null primary key,
	class_id integer,
	teacher_object_id integer,
	foreign key (class_id) references classes(id),
	foreign key (teacher_object_id) references teacher_object(id)
);

