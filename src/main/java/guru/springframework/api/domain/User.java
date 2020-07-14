package guru.springframework.api.domain;

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
public class User extends BaseEntity{
    private String gender;
    @OneToOne(cascade = CascadeType.ALL)
    private Name name;
    @OneToOne(cascade = CascadeType.ALL)
    private Location location;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private Login login;
    private String phone;
    @OneToOne(cascade = CascadeType.ALL)
    private Job job;
    @OneToOne(cascade = CascadeType.ALL)
    private Billing billing;
    private String language;
    private String currency;
}
