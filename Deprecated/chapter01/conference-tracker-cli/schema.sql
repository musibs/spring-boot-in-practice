create table CONFERENCES (
    CONFERENCE_ID identity not null,
    CONFERENCE_NAME varchar(100) not null,
    CONFERENCE_LOCATION varchar(50) not null,
    CONFERENCE_SPEAKER varchar(30) not null,
    CONFERENCE_DATE date not null
);