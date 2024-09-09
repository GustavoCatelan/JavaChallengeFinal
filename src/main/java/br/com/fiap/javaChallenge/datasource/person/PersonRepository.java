package br.com.fiap.javaChallenge.datasource.person;

import br.com.fiap.javaChallenge.domainmodel.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
