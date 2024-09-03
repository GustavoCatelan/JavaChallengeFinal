package br.com.fiap.javaChallenge.domainmodel.analysis;


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
    private @Getter @Setter Long id;
    private @Getter @Setter String text;
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
}
