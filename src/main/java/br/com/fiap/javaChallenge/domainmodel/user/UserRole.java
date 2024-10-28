package br.com.fiap.javaChallenge.domainmodel.user;

import org.springframework.transaction.annotation.Propagation;

public enum UserRole {

    ADMIN("admin"),

    USER("user");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
