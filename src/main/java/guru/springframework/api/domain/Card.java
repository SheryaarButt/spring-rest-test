package guru.springframework.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Card extends BaseEntity {
    private String type;
    private String number;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonProperty("expiration_date")
    private CardExpirationDate expirationDate;
    private String iban;
    private String swift;
}
