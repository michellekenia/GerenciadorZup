package br.zup.GerenciadorZup.gerenciador.config;

import br.zup.GerenciadorZup.gerenciador.exceptions.NomeMenorDoQuePermitido;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler (MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)

    public List <MensagemDeErro> manipularErrosDeValidacao (MethodArgumentNotValidException exception) {
        List<MensagemDeErro> erros = new ArrayList<>();
        for (FieldError fieldError: exception.getFieldErrors()) {
            MensagemDeErro erroValidacao = new MensagemDeErro(fieldError.getDefaultMessage());
            erros.add(erroValidacao);

        }
    return erros;

    }

    /*@ExceptionHandler (NomeMenorDoQuePermitido)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemDeErro manipularExcecaoNomeInvalido(NomeMenorDoQuePermitido exception) {

        return new MensagemDeErro(exception.getMessage());
    */

}
