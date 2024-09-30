package fr.maxime.exo_api_anotation.service;

import fr.maxime.exo_api_anotation.dto.BookDTO;
import fr.maxime.exo_api_anotation.entity.Book;
import fr.maxime.exo_api_anotation.repository.BookRepository;
import fr.maxime.exo_api_anotation.annotation.Log;
import fr.maxime.exo_api_anotation.annotation.Performance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Log
    @Performance
    public BookDTO createBook(BookDTO bookDTO) {
        Book book = convertToEntity(bookDTO);
        Book savedBook = bookRepository.save(book);
        return convertToDTO(savedBook);
    }

    @Log
    @Performance
    public void deleteBook(int idBook) {
        bookRepository.deleteById(idBook);
    }

    @Log
    @Performance
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Méthodes de conversion
    private BookDTO convertToDTO(Book book) {
        return BookDTO.builder()
                .idBook(book.getIdBook())
                .nameBook(book.getNameBook())
                .userId(book.getUser() != null ? book.getUser().getIdUser() : null)
                .build();
    }

    private Book convertToEntity(BookDTO bookDTO) {
        return Book.builder()
                .idBook(bookDTO.getIdBook())
                .nameBook(bookDTO.getNameBook())
                .build();
    }
}
