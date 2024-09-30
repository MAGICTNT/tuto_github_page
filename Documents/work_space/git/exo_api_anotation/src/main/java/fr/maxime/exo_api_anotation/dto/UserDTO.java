package fr.maxime.exo_api_anotation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private int idUser;
    private String pseudo;
    private String password;
    private List<BookDTO> books; // Liste des livres associés à l'utilisateur
}