interface ConferenceRepository {
    List<Conference> findAllConferences()
    List<Conference> findConferencesByDate(Date date)
    List<Conference> findConferencesBySpeaker(String speakerName)
}