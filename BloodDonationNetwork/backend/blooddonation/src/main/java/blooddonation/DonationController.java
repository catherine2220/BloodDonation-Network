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

    // Accept blood request
    @PutMapping("/{id}/accept")
    public Donation acceptDonation(@PathVariable Integer id) {

        Donation donation = donationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donation not found"));

        donation.setMatchStatus("Accepted");

        return donationRepository.save(donation);
    }

    // Reject blood request
    @PutMapping("/{id}/reject")
    public Donation rejectDonation(@PathVariable Integer id) {

        Donation donation = donationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donation not found"));

        donation.setMatchStatus("Rejected");

        return donationRepository.save(donation);
    }
}