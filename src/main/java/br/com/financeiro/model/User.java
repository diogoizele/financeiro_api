package br.com.financeiro.model;

import lombok.*;

import javax.persistence.*;

import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;

@Builder @NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter @Setter @EqualsAndHashCode(of = "id") @ToString(of = "id")
@Table(name = "person")
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private String password;

    private BigDecimal wage;
}
