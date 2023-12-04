package com.JoyTrav.service;

import java.util.List;
import java.util.Optional;

public interface IGenericService <T, E>{
    List<T> fetchALl();
    Optional<T> getById(E e);
    void create(T t);
    void save(T t);
    boolean existsById(E e);
}
