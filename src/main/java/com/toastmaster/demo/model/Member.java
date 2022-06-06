package com.toastmaster.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "first_name", length = 50)
    private String firstName;

    @NotNull
    @Column(name = "last_name", length = 50)
    private String lastName;

    @Email
    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "country", length = 50)
    private String country;
}
