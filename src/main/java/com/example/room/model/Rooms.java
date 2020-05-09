package com.example.room.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long numOfBaths;

    @Column(nullable = false)
    private Long numOfBeds;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String description;

}
