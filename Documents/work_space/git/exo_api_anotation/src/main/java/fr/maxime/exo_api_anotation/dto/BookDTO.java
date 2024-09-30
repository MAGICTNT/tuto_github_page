package fr.maxime.exo_api_anotation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {

    private int idBook;
    private String nameBook;
    private int userId; // L'ID de l'utilisateur qui possède le livre
}
