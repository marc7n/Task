package com.marc7n.task.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;
    @Column
    @Size(min = 3)
    @NotBlank
    private String imie;
    @Column
    private String nazwisko;
    @Column
    @NotNull
    @Min(value = 19)
    private int wiek;
    @Column
    @Email
    private String email;
    @Column
    private String kierunek;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "students")
    @JsonIgnoreProperties("students")
    private List<Nauczyciel> nauczyciels = new ArrayList<>();

}
