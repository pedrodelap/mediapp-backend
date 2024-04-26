package com.micode.model;

import jakarta.persistence.*;
import lombok.*;

/*@Getter
@Setter
@EqualsAndHashCode
@ToString*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity //(name = "A") //JPQL FROM A
@Table //(name = "tbl_patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idPatient;

    //camelCase -> lowerCamelCase  | UpperCamelCase | snake _
    @Column(length = 70, nullable = false) //, name = "xyz"
    private String firstName;

    @Column(length = 70, nullable = false)
    private String lastName;

    @Column(length = 8, nullable = false, unique = true )
    private String dni;

    @Column(length = 150, nullable = false)
    private String address;

    @Column(length = 9, nullable = false)
    private String phone;

    @Column(length = 70, nullable = false)
    private String email;

}
