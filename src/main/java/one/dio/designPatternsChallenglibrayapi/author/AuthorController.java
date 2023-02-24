package one.dio.designPatternsChallenglibrayapi.author;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("library/author")
public class AuthorController {

    /* Attributes */

    @Autowired
    AuthorRepository repository;

    /* Methods */

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<?> createAuthor(@RequestBody @Valid AuthorRequest request, UriComponentsBuilder uriBuilder) { //uso do padrão DTO.
        AuthorModel author = request.toModel();
        repository.save(author);
        long id = author.getId();
        URI uri = uriBuilder.path("library/author/profile/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

}
