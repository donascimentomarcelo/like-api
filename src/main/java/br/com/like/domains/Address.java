package br.com.like.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "adresses")
public class Address {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "seqAddress")
    @SequenceGenerator(name = "seqAddress", sequenceName = "seq_id_address")
    private Long id;
    private String zipcode;
    private String street;
    private String neighborhood;
    private String complement;
    private String city;
    private String state;

    @OneToOne
    @JoinColumn(name="client_id")
    @JsonIgnore
    private Client client;
}
