package blooddonation;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "donation")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer donationId;

    private Integer donorId;
    private Integer requestId;
    private LocalDate donationDate;
    private Integer unitsDonated;
    private String matchStatus;

    public Integer getDonationId() {
        return donationId;
    }

    public Integer getDonorId() {
        return donorId;
    }

    public void setDonorId(Integer donorId) {
        this.donorId = donorId;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public LocalDate getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(LocalDate donationDate) {
        this.donationDate = donationDate;
    }

    public Integer getUnitsDonated() {
        return unitsDonated;
    }

    public void setUnitsDonated(Integer unitsDonated) {
        this.unitsDonated = unitsDonated;
    }

    public String getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(String matchStatus) {
        this.matchStatus = matchStatus;
    }
}