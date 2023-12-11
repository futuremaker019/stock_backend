package com.stock.analysis.domain.entity;

import com.stock.analysis.domain.AuditingFields;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@ToString(callSuper = true)
@Table(indexes = {

})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserAccount extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private String userId;

    @Setter
    @Column(nullable = false)
    private String userPassword;

    @Setter
    @Column(length = 100)
    private String email;

    @Setter
    @Column(length = 100)
    private String nickname;

    private UserAccount(Long id, String userId, String userPassword, String email, String nickname) {
        this.id = id;
        this.userId = userId;
        this.userPassword = userPassword;
        this.email = email;
        this.nickname = nickname;
    }

    public static UserAccount of(Long id, String userId, String userPassword, String email, String nickname) {
        return new UserAccount(id, userId, userPassword, email, nickname);
    }

    public static UserAccount of(String userId, String userPassword, String email, String nickname) {
        return new UserAccount(null, userId, userPassword, email, nickname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAccount userAccount)) return false;
        return this.getId() != null && this.getId().equals(userAccount.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getUserId());
    }
}