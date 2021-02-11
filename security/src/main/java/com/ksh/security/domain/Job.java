package com.ksh.security.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
public class Job {

    @Id
    private Long jobNo;

    @Column(length = 100)
    private String jobName;

    @OneToMany(mappedBy = "job")
    private List<Member> members = new ArrayList<>();
}
