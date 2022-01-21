package com.marc7n.task.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table
public class Nauczyciel {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    @Column(name = "nauczyciel_id")
    private int nauczycielId;
    @Column
    @NotBlank
    @Size(min = 3)
    private String imie;
    @Column
    private String nazwisko;
    @Column
    @NotNull
    @Min(value = 19, message = "Musi mieć przynajmniej 18 lat")
    private int wiek;
    @Column
    @Email
    private String email;
    @Column
    private String przedmiot;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "nauczyciel_student",
            joinColumns = @JoinColumn(name = "nauczyciel_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    @JsonIgnoreProperties("nauczyciels")
    private List<Student> students = new ArrayList<>();
}
