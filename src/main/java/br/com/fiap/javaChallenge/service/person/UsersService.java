package br.com.fiap.javaChallenge.service.person;

import br.com.fiap.javaChallenge.domainmodel.person.Users;

import java.util.List;

public interface UsersService {

    Users save(Users u);

    void delete(Users u);

    void deleteById(long id);

    List<Users> findAllUser();
}
