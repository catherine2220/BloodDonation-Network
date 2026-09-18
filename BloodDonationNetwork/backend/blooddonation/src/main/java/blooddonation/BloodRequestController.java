package blooddonation;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/blood-requests")
public class BloodRequestController {

    private final BloodRequestRepository bloodRequestRepository;

    public BloodRequestController(BloodRequestRepository bloodRequestRepository) {
        this.bloodRequestRepository = bloodRequestRepository;
    }

    @PostMapping
    public BloodRequest addRequest(@RequestBody BloodRequest request) {

        request.setStatus("Pending");

        return bloodRequestRepository.save(request);
    }

    @GetMapping
    public List<BloodRequest> getRequests() {
        return bloodRequestRepository.findAll();
    }
}