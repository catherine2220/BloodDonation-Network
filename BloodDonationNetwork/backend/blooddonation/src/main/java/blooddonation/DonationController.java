package blooddonation;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/donations")
public class DonationController {

    private final DonationRepository donationRepository;

    public DonationController(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @PostMapping
    public Donation addDonation(@RequestBody Donation donation) {
        return donationRepository.save(donation);
    }

    @GetMapping
    public List<Donation> getDonations() {
        return donationRepository.findAll();
    }
}