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
@Table(name = "replies")
public class Reply {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "seqReply")
    @SequenceGenerator(name = "seqReply", sequenceName = "seq_id_reply")
    private Long id;

    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Reply(final Long id, final String description, final Question question) {
        this.id = id;
        this.description = description;
        this.question = question;
    }
}
