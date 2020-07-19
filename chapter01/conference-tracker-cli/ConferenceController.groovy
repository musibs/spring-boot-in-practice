import org.springframework.format.annotation.DateTimeFormat

@Grab("h2")
@Grab("spring-boot-starter-thymeleaf")
@Controller
@RequestMapping
class ConferenceController {

    @Autowired
    ConferenceRepository conferenceRepository;

    @GetMapping
    def getAllConferences(Model model) {
        List<Conference> conferences = conferenceRepository.findAllConferences();
        model.addAttribute("conferences", conferences)
        "conference"
    }

    @GetMapping("/date/{conferenceDate}")
    def getConferencesByDate(@PathVariable("conferenceDate") 
    @DateTimeFormat(pattern = "yyyy-MM-dd") Date conferenceDate, Model model) {
        List<Conference> conferences = conferenceRepository
        .findConferencesByDate(conferenceDate);
        model.addAttribute("conferences", conferences)
        "conference"
    }

    @GetMapping("/speaker/{conferenceSpeaker}")
    def getConferencesBySpeaker(@PathVariable("conferenceSpeaker") String conferenceSpeaker, Model model) {
        List<Conference> conferences = conferenceRepository
        .findConferencesBySpeaker(conferenceSpeaker);
        model.addAttribute("conferences", conferences)
        "conference"
    }
}