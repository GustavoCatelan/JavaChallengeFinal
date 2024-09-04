package br.com.fiap.javaChallenge.service.person;

import br.com.fiap.javaChallenge.domainmodel.person.User;

import java.util.List;

public interface UserService {

    User save(User u);

    void delete(User u);

    void deleteById(long id);

    List<User> findAllUser();
}
