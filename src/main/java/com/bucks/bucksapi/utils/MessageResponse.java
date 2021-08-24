package com.bucks.bucksapi.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author rodolfo-chicone
 * @version : $<br/>
 * : $
 * @since 01/05/2021 18:30
 */
@RequiredArgsConstructor
@Getter
public enum MessageResponse {

    SUCCESS("Success"),
    MESSAGE_FAILURE_COMMUNICATE_SWAPI_API("Falha ao comunicar com API."),
    MESSAGE_FILM_NOT_FOUND("Registro não encontrado."),
    MESSAGE_ERROR_UNEXPECTED("Erro não esperado."),
    MESSAGE_ERRORS_REQUEST("Erro na requisição.");

    private final String message;
}
