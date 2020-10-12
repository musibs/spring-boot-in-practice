//@Repository
class DefaultConferenceRepository implements ConferenceRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    List<Conference> findAllConferences() {
         jdbcTemplate.query("""select CONFERENCE_ID, CONFERENCE_NAME, CONFERENCE_LOCATION, CONFERENCE_SPEAKER, CONFERENCE_DATE 
        from Conferences""", {
            resultSet, newRow -> new Conference(
                conferenceId : resultSet.getLong(1),
                conferenceName : resultSet.getString(2),
                conferenceLocation : resultSet.getString(3),
                conferenceSpeaker : resultSet.getString(4),
                conferenceDate : resultSet.getDate(5))
         } as RowMapper)
    }

    List<Conference> findConferencesByDate(Date date) {
        jdbcTemplate.query("""select CONFERENCE_ID, CONFERENCE_NAME, CONFERENCE_LOCATION, CONFERENCE_SPEAKER, CONFERENCE_DATE 
        from Conferences where CONFERENCE_DATE=?""", {
            resultSet, newRow -> new Conference(
                conferenceId : resultSet.getLong(1),
                conferenceName : resultSet.getString(2),
                conferenceLocation : resultSet.getString(3),
                conferenceSpeaker : resultSet.getString(4),
                conferenceDate : resultSet.getDate(5))
         } as RowMapper, date)
    }

    List<Conference> findConferencesBySpeaker(String speakerName) {
        jdbcTemplate.query("""select CONFERENCE_ID, CONFERENCE_NAME, CONFERENCE_LOCATION, CONFERENCE_SPEAKER, CONFERENCE_DATE 
        from Conferences where CONFERENCE_SPEAKER=?""", {
            resultSet, newRow -> new Conference(
                conferenceId : resultSet.getLong(1),
                conferenceName : resultSet.getString(2),
                conferenceLocation : resultSet.getString(3),
                conferenceSpeaker : resultSet.getString(4),
                conferenceDate : resultSet.getDate(5))
         } as RowMapper, speakerName)
    }
}