package fr.maxime.exo_api_anotation.repository;

import fr.maxime.exo_api_anotation.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    // Tu peux ajouter des méthodes de requêtes spécifiques ici si nécessaire
}
