package one.dio.designPatternsChallenglibrayapi.core.validation.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import one.dio.designPatternsChallenglibrayapi.core.validation.validators.UniqueValueValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {UniqueValueValidator.class})

@Target({
        ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR,
        ElementType.PARAMETER, ElementType.TYPE_USE
})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {

    Class <?> domainClass();

    String fieldName();

    String message() default "Esse valor já existe!";

    Class <?>[] groups() default {};

    Class <? extends Payload>[] payload() default {};
}
