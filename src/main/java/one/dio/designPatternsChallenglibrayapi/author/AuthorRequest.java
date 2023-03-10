package one.dio.designPatternsChallenglibrayapi.author;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import one.dio.designPatternsChallenglibrayapi.core.validation.annotations.UniqueValue;

//Classe de requisição "Front". DTO.
//Classe para transacionar as informações do front para o back, para não expor dados sensíveis(exemplo: dinheiro, saldo, senha, etc.) e evitar alterações indesejadas no banco de dados.
public class AuthorRequest {

    /* Attributes */

    @NotBlank
    private final String name;

    @NotBlank
    @Email
    @UniqueValue(domainClass = AuthorModel.class, fieldName = "email")
    private final String email;

    @NotBlank
    @Size(max = 400)
    private final String description;

    /* Constructors */

    public AuthorRequest(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    /* Methods */
    public AuthorModel toModel(){
        return new AuthorModel(name, email, description);
    }
}
