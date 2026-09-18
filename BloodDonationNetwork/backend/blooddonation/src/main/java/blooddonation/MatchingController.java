package blooddonation;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/match")
public class MatchingController {

    private final DonorRepository donorRepository;

    public MatchingController(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    @GetMapping
    public List<Donor> findMatchingDonors(
            @RequestParam String bloodGroup,
            @RequestParam String location) {

        return donorRepository.findAll().stream()
                .filter(d -> d.getBloodGroup().equalsIgnoreCase(bloodGroup))
                .filter(d -> d.getLocation().equalsIgnoreCase(location))
                .filter(d -> d.getAvailability().equalsIgnoreCase("Available"))
                .collect(Collectors.toList());
    }
}