package one.dio.designPatternsChallenglibrayapi.author;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_AUTHOR")
public class AuthorModel {

    /* Attributes */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true) //para e-mail único, não repetido.
    private String email;
    @Column(nullable = false, length = 400)
    private String description;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdAt; //data de criação do autor.

    /* Constructors */

    @Deprecated
    public AuthorModel() {
    }

    public AuthorModel(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    /* Methods */

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}
