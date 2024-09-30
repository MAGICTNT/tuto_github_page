package fr.maxime.exo_api_anotation.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private int idBook;

    @Column(name = "name_book")
    private String nameBook;

    // Un livre ne peut appartenir qu'à un seul utilisateur à la fois
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
}