package fr.maxime.exo_api_anotation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user_book")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int idUser;

    @Column(name = "pseudo")
    private String pseudo;

    @Column(name = "password")
    private String password;

    // Un utilisateur peut avoir plusieurs livres
    @OneToMany(mappedBy = "user")
    private List<Book> books;
}