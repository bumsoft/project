package com.erica.project.User.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserRole roles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Career> career;
}
