package br.com.like.domains;

import br.com.like.domains.enums.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "seqClient")
    @SequenceGenerator(name = "seqClient", sequenceName = "seq_id_client")
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "client")
    private Address address;

    @ElementCollection
    @CollectionTable(name="PHONES")
    private Set<String> phones = new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="PROFILES")
    private Set<Integer> profiles = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public Client(final Long clientId) {
        id = clientId;
    }

    public Client(final String name, final String lastName, final String email, final String cpf, final Set<String> phones, final User user) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.cpf = cpf;
        this.phones = phones;
        this.profiles = profiles;
        this.user = user;
        addProfile(Profile.CLIENT);
    }

    public Set<Profile> getProfiles() {
        return profiles.stream()
                    .map(profile -> Profile.toEnum(profile))
                    .collect(Collectors.toSet());
    }

    public void addProfile(final Profile profile) {
        profiles.add(profile.getCode());
    }

    public boolean checkEmailEquals(String email) {
        return this.email.equals(email);
    }
}
