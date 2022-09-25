package br.com.financeiro.model;

import lombok.*;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Builder @NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter @Setter @EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Activity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String title;

    private LocalDateTime date;

    private BigDecimal amount;

    private String description;

    @Enumerated(STRING)
    private  Category category;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private User user;
}
