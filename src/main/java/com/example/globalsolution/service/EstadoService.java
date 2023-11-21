package com.example.globalsolution.service;

import com.example.globalsolution.entity.Estado;
import com.example.globalsolution.exception.EstadoNotFoundException;
import com.example.globalsolution.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado createEstado(Estado estado) {
        return estadoRepository.save(estado);
    }

    public Estado updateEstado(Long id, Estado updatedEstado) {
        Estado estado = estadoRepository.findById(id)
                .orElseThrow(() -> new EstadoNotFoundException("State not found with ID: " + id));
        estado.setNomeEstado(updatedEstado.getNomeEstado());
        return estadoRepository.save(estado);
    }

    public void deleteEstado(Long id) {
        estadoRepository.deleteById(id);
    }

    public List<Estado> getAllEstados() {
        return estadoRepository.findAll();
    }

    public Estado getEstadoById(Long id) {
        return estadoRepository.findById(id)
                .orElseThrow(() -> new EstadoNotFoundException("State not found with ID: " + id));
    }
}
