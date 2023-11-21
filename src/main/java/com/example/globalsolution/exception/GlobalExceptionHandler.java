package com.example.globalsolution.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PacienteNotFoundException.class)
    public ResponseEntity<Object> handlePacienteNotFoundException(PacienteNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MedicoNotFoundException.class)
    public ResponseEntity<Object> handleMedicoNotFoundException(MedicoNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HospitalClinicaNotFoundException.class)
    public ResponseEntity<Object> handleHospitalClinicaNotFoundException(HospitalClinicaNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HistoricoClinicoNotFoundException.class)
    public ResponseEntity<Object> handleHistoricoClinicoNotFoundException(HistoricoClinicoNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EstadoNotFoundException.class)
    public ResponseEntity<Object> handleEstadoNotFoundException(EstadoNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EnderecoNotFoundException.class)
    public ResponseEntity<Object> handleEnderecoNotFoundException(EnderecoNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ContatoEmergencialNotFoundException.class)
    public ResponseEntity<Object> handleContatoEmergencialNotFoundException(ContatoEmergencialNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CidadeNotFoundException.class)
    public ResponseEntity<Object> handleCidadeNotFoundException(CidadeNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlocacaoMedicoNotFoundException.class)
    public ResponseEntity<Object> handleAlocacaoMedicoNotFoundException(AlocacaoMedicoNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AgendamentoConsultaNotFoundException.class)
    public ResponseEntity<Object> handleAgendamentoConsultaNotFoundException(AgendamentoConsultaNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
