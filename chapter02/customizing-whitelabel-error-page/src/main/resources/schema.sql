CREATE TABLE conference
(
    conference_id varchar(30) NOT NULL,
    conference_name varchar(100) NOT NULL,
    conference_location varchar(50) NOT NULL,
    conference_speaker varchar(30) NOT NULL,
    conference_date date NOT NULL,
    PRIMARY KEY (conference_id)
);