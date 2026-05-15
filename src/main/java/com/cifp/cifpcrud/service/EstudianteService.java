package com.cifp.cifpcrud.service;

import com.cifp.cifpcrud.exception.EstudianteNotFoundException;
import com.cifp.cifpcrud.model.Estudiante;
import com.cifp.cifpcrud.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository repository;

    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    public List<Estudiante> obtenerTodos() {
        return repository.findAll();
    }

    public Estudiante obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EstudianteNotFoundException(id));
    }

    public Estudiante actualizarEstudiante(Long id, Estudiante datos) {
        Estudiante existente = obtenerPorId(id);
        existente.setNombre(datos.getNombre());
        existente.setEmail(datos.getEmail());
        existente.setEdad(datos.getEdad());
        return repository.save(existente);
    }

    public void eliminarEstudiante(Long id) {
        obtenerPorId(id);
        repository.deleteById(id);
    }
}