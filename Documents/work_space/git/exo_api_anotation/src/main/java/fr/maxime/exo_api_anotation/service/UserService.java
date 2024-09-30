package fr.maxime.exo_api_anotation.service;

import fr.maxime.exo_api_anotation.dto.UserDTO;
import fr.maxime.exo_api_anotation.entity.User;
import fr.maxime.exo_api_anotation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO createUser(UserDTO userDTO) {
        User user = User.builder()
                .pseudo(userDTO.getPseudo())
                .password(userDTO.getPassword())
                .books(null) // Ou une logique pour initialiser les livres
                .build();
        User savedUser = userRepository.save(user);
        return new UserDTO(savedUser.getIdUser(), savedUser.getPseudo(), savedUser.getPassword(), null);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserDTO(user.getIdUser(), user.getPseudo(), user.getPassword(), null))
                .collect(Collectors.toList());
    }
}
