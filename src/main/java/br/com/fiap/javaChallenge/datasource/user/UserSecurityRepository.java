package br.com.fiap.javaChallenge.datasource.user;

import br.com.fiap.javaChallenge.domainmodel.user.UsersSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserSecurityRepository extends JpaRepository<UsersSecurity, String> {

    UserDetails findByLogin(String login);
}
