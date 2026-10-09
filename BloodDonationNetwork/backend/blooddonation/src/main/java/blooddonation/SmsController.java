package blooddonation;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/sms")
public class SmsController {

    private final TwilioService twilioService;

    public SmsController(TwilioService twilioService) {
        this.twilioService = twilioService;
    }

    @GetMapping("/test")
    public String sendTestSms(@RequestParam String phone) {

        String message =
                "BloodConnect Emergency Blood Request\n" +
                "Blood Group: O+\n" +
                "Location: Trichy\n" +
                "Units Required: 1\n" +
                "Please respond to the request.";

        twilioService.sendSms(phone, message);

        return "BloodConnect SMS sent successfully!";
    }
}