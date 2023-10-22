package deploy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity(name = "tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String number;

    private String agency;

    // scale terão 11 inteiros e 2 decimais
    @Column(scale = 2, precision = 13)
    private BigDecimal balance;

    @Column(name = "account_limit", scale = 2, precision = 13)
    private BigDecimal limit;

}
