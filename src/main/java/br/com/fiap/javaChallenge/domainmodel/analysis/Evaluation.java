package br.com.fiap.javaChallenge.domainmodel.analysis;


import br.com.fiap.javaChallenge.domainmodel.product.Negotiable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EVALUATION")
    private @Getter @Setter Long id;

    @Column(name = "TX_EVALUATION")
    private @Getter @Setter String text;

    @Column(name = "DT_EVALUATION")
    private @Getter @Setter LocalDate date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Evaluation evaluation)) return false;
        return id == evaluation.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "NEGOTIABLE",
            referencedColumnName = "ID_NEGOTIABLE",
            foreignKey = @ForeignKey(
                    name = "FK_NEGOTIABLE_EVALUATION"
            )
    )
    private Negotiable negotiable;
}
