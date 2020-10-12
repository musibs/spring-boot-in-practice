DROP TABLE IF EXISTS Course;
CREATE TABLE Course
(
    id int(15) NOT NULL,
    name varchar(100) NOT NULL,
    description varchar(1000) NOT NULL,
    PRIMARY KEY (id)
);
