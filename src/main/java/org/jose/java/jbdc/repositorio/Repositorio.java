package org.jose.java.jbdc.repositorio;

import java.util.List;

public interface Repositorio <T>{
    List<T> listar();

    List<String> listarNombre();

    T porId(Long id);

    void guardar(T t);

    void eliminar(Long id);
}
