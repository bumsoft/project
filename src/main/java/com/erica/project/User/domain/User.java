package com.erica.project.User.domain;
import com.erica.project.User.dto.UserRegisterDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
// JPA 어노테이션으로, 상속 전략을 단일 테이블 상속(Single Table Inheritance)으로 지정합니다.
// 이 전략은 모든 하위 클래스의 데이터가 하나의 테이블에 저장되는 방식입니다.
@DiscriminatorColumn(name = "user")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class User {

    public User(UserRegisterDto userRegisterDto)
    {
        this.username = userRegisterDto.getUsername();
        this.password = userRegisterDto.getPw();
        this.phoneNumber = userRegisterDto.getPh();
        this.name = userRegisterDto.getName();
        this.email = userRegisterDto.getEmail();
        this.role = userRegisterDto.getRole();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @CreatedDate
    private String joinDate;

    @Enumerated
    @Column(nullable = false)
    private UserRole role;

}