package one.dio.designPatternsChallenglibrayapi.core.exceptions;

public class FilterExceptionDTO {

    private final String field;
    private final String error;

    public FilterExceptionDTO(String field, String error) {
        super();
        this.field = field;
        this.error = error;
    }

    public String getField() {
        return field;
    }

    public String getError() {
        return error;
    }

}
