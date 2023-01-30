package com.example.springday07.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor // always with entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // خلاص ما اضيف من البوست مان
    private int id;
    @NotEmpty(message = "title is required")
    @Column (columnDefinition = "varchar(25) not null")// لما ابي validation على مستوى DB
    private String title;

    @NotEmpty(message = "body is required")
    @Column (columnDefinition = "varchar(50) not null")// لما ابي validation على مستوى DB
    private String body;
}
