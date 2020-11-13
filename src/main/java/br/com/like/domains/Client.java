package br.com.like.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
        this.user = user;
    }

    public boolean checkEmailEquals(String email) {
        return this.email.equals(email);
    }
}
