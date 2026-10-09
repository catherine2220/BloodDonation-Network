
package blooddonation;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {

    @Value("${twilio.account-sid:}")
    private String accountSid;

    @Value("${twilio.auth-token:}")
    private String authToken;

    @Value("${twilio.phone-number:}")
    private String fromPhoneNumber;

    public void sendSms(String toPhoneNumber, String messageText) {

        if (accountSid.isBlank()
                || authToken.isBlank()
                || fromPhoneNumber.isBlank()) {
            throw new IllegalStateException(
                "Twilio credentials are not configured"
            );
        }

        Twilio.init(accountSid, authToken);

        Message.creator(
                new PhoneNumber(toPhoneNumber),
                new PhoneNumber(fromPhoneNumber),
                messageText
        ).create();
    }
}