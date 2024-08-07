package com.erica.project.User.domain;
import com.erica.project.User.dto.UserRegisterDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
// JPA 어노테이션으로, 상속 전략을 단일 테이블 상속(Single Table Inheritance)으로 지정합니다.
// 이 전략은 모든 하위 클래스의 데이터가 하나의 테이블에 저장되는 방식입니다.
@DiscriminatorColumn(name = "user")
@EntityListeners(AuditingEntityListener.class)
public abstract class User {

    public User(UserRegisterDto userRegisterDto)
    {
        this.id = userRegisterDto.getId();
        this.pw = userRegisterDto.getPw();
        this.ph = userRegisterDto.getPh();
        this.name = userRegisterDto.getName();
        this.email = userRegisterDto.getEmail();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long autoID;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String pw;

    @Column(nullable = false)
    private String ph;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @CreatedDate
    private String joindate;
}