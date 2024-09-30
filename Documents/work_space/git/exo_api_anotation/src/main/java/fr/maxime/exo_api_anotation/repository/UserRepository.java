package fr.maxime.exo_api_anotation.repository;

import fr.maxime.exo_api_anotation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Tu peux ajouter des méthodes de requêtes spécifiques ici si nécessaire
}
