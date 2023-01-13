package one.dio.designPatternsChallenglibrayapi.author;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autor")
public class AuthorController {

    /* Attributes */

    @Autowired
    AuthorRepository repository;

    /* Methods */

    @PostMapping
    @Transactional
    public void createAuthor(@RequestBody @Valid AuthorRequest request) { //uso do padrão DTO.
        AuthorModel author = request.toModel();
        repository.save(author);
    }

}
