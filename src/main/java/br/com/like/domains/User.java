package br.com.like.domains;

import br.com.like.domains.enums.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "seqUser")
    @SequenceGenerator(name = "seqUser", sequenceName = "seq_id_user")
    private Long id;
    private String username;
    private String password;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="PROFILES")
    private Set<Integer> profiles = new HashSet<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Client client;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();

    public User(final String username, final String password) {
        this.username = username;
        this.password = password;
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

    public User(Long userId) {
        id = userId;
    }
}
