package com.ksh.security.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Position {

    @Id
    private Long posNo;

    @Column
    private String posName;

    @OneToMany(mappedBy = "position")
    private List<Member> members = new ArrayList<>();
}
