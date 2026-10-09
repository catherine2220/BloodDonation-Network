package blooddonation;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/match")
public class MatchingController {

    private final DonorRepository donorRepository;
    private final TwilioService twilioService;

    public MatchingController(
            DonorRepository donorRepository,
            TwilioService twilioService) {

        this.donorRepository = donorRepository;
        this.twilioService = twilioService;
    }

    @GetMapping
    public List<Donor> findMatchingDonors(
            @RequestParam String bloodGroup,
            @RequestParam String location) {

        return donorRepository.findAll().stream()
                .filter(d -> isCompatible(bloodGroup, d.getBloodGroup()))
                .filter(d -> d.getLocation().equalsIgnoreCase(location))
                .filter(d -> d.getAvailability().equalsIgnoreCase("Available"))
                .collect(Collectors.toList());
    }

    @GetMapping("/notify/{donorId}")
    public String notifyDonor(
            @PathVariable Integer donorId,
            @RequestParam Integer requestId) {

        Donor donor = donorRepository.findById(donorId)
                .orElseThrow(() -> new RuntimeException("Donor not found"));

        String phone = donor.getPhone();

        String message =
                "BloodConnect: You have received an emergency blood donation request. " +
                "Request ID: " + requestId +
                ". Please respond to the request.";

        twilioService.sendSms(phone, message);

        return "SMS notification sent to donor successfully!";
    }

    private boolean isCompatible(String patientBlood, String donorBlood) {

        if (patientBlood.equalsIgnoreCase("A+"))
            return donorBlood.equalsIgnoreCase("A+")
                    || donorBlood.equalsIgnoreCase("A-")
                    || donorBlood.equalsIgnoreCase("O+")
                    || donorBlood.equalsIgnoreCase("O-");

        if (patientBlood.equalsIgnoreCase("A-"))
            return donorBlood.equalsIgnoreCase("A-")
                    || donorBlood.equalsIgnoreCase("O-");

        if (patientBlood.equalsIgnoreCase("B+"))
            return donorBlood.equalsIgnoreCase("B+")
                    || donorBlood.equalsIgnoreCase("B-")
                    || donorBlood.equalsIgnoreCase("O+")
                    || donorBlood.equalsIgnoreCase("O-");

        if (patientBlood.equalsIgnoreCase("B-"))
            return donorBlood.equalsIgnoreCase("B-")
                    || donorBlood.equalsIgnoreCase("O-");

        if (patientBlood.equalsIgnoreCase("AB+"))
            return true;

        if (patientBlood.equalsIgnoreCase("AB-"))
            return donorBlood.equalsIgnoreCase("AB-")
                    || donorBlood.equalsIgnoreCase("A-")
                    || donorBlood.equalsIgnoreCase("B-")
                    || donorBlood.equalsIgnoreCase("O-");

        if (patientBlood.equalsIgnoreCase("O+"))
            return donorBlood.equalsIgnoreCase("O+")
                    || donorBlood.equalsIgnoreCase("O-");

        if (patientBlood.equalsIgnoreCase("O-"))
            return donorBlood.equalsIgnoreCase("O-");

        return false;
    }
}