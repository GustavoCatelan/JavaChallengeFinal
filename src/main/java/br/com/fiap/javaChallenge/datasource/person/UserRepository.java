package br.com.fiap.javaChallenge.datasource.person;

import br.com.fiap.javaChallenge.domainmodel.person.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
