package br.com.fiap.javaChallenge.domainmodel.person;

import br.com.fiap.javaChallenge.domainmodel.product.Product;
import br.com.fiap.javaChallenge.domainmodel.product.Service;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Distributor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DISTRIBUTOR")
    private @Getter @Setter Long id;

    @Column(name = "COV_DISTRIBUTOR")
    private @Getter @Setter String coverageArea;

    @Column(name = "LOCAT_DISTRIBUTOR")
    private @Getter @Setter String location;

    @Column(name = "TYPE_DISTRIBUTOR")
    private @Getter @Setter String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Distributor distributor)) return false;
        return id == distributor.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST}
    )
    @JoinTable(
            name = "SERVICE_DISTRIBUTOR",
            joinColumns = {
                    @JoinColumn(
                            name = "DISTRIBUTOR",
                            referencedColumnName = "ID_DISTRIBUTOR",
                            foreignKey = @ForeignKey(name = "FK_DISTRIBUTOR_SERVICE"))
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "SERVICE",
                            referencedColumnName = "ID_NEGOTIABLE",
                            foreignKey = @ForeignKey(name = "FK_SERVICE_DISTRIBUTOR"))
            }
    )
    private Set<Service> service = new LinkedHashSet<>();

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST}
    )
    @JoinTable(
            name = "PRODUCT_DISTRIBUTOR",
            joinColumns = {
                    @JoinColumn(
                            name = "DISTRIBUTOR",
                            referencedColumnName = "ID_DISTRIBUTOR",
                            foreignKey = @ForeignKey(name = "FK_DISTRIBUTOR_PRODUCT"))
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "PRODUCT",
                            referencedColumnName = "ID_NEGOTIABLE",
                            foreignKey = @ForeignKey(name = "FK_PRODUTO_DISTRIBUIDOR"))
            }
    )
    private Set<Product> product = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "PERSON",
            referencedColumnName = "ID_PERSON",
            foreignKey = @ForeignKey(
                    name = "FK_DISTRIBUTOR_PERSON"
            )
    )
    private Person person;
}
