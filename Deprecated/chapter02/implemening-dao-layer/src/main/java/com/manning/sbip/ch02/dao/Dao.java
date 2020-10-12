package com.manning.sbip.ch02.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> findById(long Id);

    List<T> findAll();

    void save(T t);

    void update(long Id, T t);

    void delete(T t);

}
