package br.com.financeiro.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;

@Builder @NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter @Setter @EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Purchase {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String item;

    private String description;

    private BigDecimal price;

    private String link;
    
    private String image;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private User user;
}
