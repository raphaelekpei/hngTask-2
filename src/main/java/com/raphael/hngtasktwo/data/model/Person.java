package com.raphael.hngtasktwo.data.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    public Person(String name) {
        this.name = name;
    }

}
