package one.dio.designPatternsChallenglibrayapi.core.validation.validators;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import one.dio.designPatternsChallenglibrayapi.core.validation.annotations.UniqueValue;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, String> {

    /* Properties */

    @PersistenceContext
    private EntityManager em; //Faz a consulta no banco de dados para saber se é único ou não.
    private String object;
    private String field;

    /* Methods */

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        object = constraintAnnotation.domainClass().getSimpleName();
        field = constraintAnnotation.fieldName();
    }

    @Override
    @Transactional
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null) {
            return false;
        }

        //Construção da Query.

        Query query = em.createQuery("SELECT 1 FROM " + object + " WHERE " + field + " = :VALUE");
        query.setParameter("VALUE", value);

        return query.getResultList().isEmpty();
    }

}
