package ru.kata.spring.boot_security.demo.models;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Data
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="role_name")
    private String roleName;

    public Role() {
    }

    public Role(Long id, String role_user) {
    }


    @Override
    public String getAuthority() {
        return getRoleName();
    }
}
