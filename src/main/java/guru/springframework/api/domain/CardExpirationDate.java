package guru.springframework.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CardExpirationDate extends BaseEntity {
    private String date;
    @JsonProperty("timezone_type")
    private Integer timezoneType;
    private String timezone;
}
