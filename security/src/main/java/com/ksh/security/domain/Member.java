package com.ksh.security.domain;

import com.ksh.security.domain.base.DateEntity;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


@Getter
@Setter
@NoArgsConstructor
@Table(name = "member", uniqueConstraints = {
        @UniqueConstraint(columnNames = "memberEmail")
})
@Entity
public class Member{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberNo;

    @ManyToOne
    @JoinColumn(name = "job_no")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "pos_no")
    private Position position;

    @Column(length = 100, nullable = false)
    private String memberName;

    @Column(length =  1000, nullable = false)
    private String memberPassword;

    @Column(length = 500, nullable = false)
    private String memberEmail;

    @Column(length = 11, nullable = false)
    private String memberPhone;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

    private String providerId;

    @Enumerated(EnumType.STRING)
    @Column(name = "member_role")
    private Role role;

    @CreationTimestamp
    private Timestamp memberRegDtm;

    @UpdateTimestamp
    private Timestamp memberUpdateDtm;

    @Column(insertable = false, columnDefinition = "char(1) default 'Y'")
    private String memberUseYn;

    @Builder
    public Member(long memberNo, Job job, Position position, String memberName, String memberPassword, String memberEmail, String memberPhone, AuthProvider provider, String providerId, Role role, Timestamp memberRegDtm, Timestamp memberUpdateDtm, String memberUseYn) {
        this.memberNo = memberNo;
        this.job = job;
        this.position = position;
        this.memberName = memberName;
        this.memberPassword = memberPassword;
        this.memberEmail = memberEmail;
        this.memberPhone = memberPhone;
        this.provider = provider;
        this.providerId = providerId;
        this.role = role;
        this.memberRegDtm = memberRegDtm;
        this.memberUpdateDtm = memberUpdateDtm;
        this.memberUseYn = memberUseYn;
    }

    public String roleName() {
        return role.name();
    }
}
