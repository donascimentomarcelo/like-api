package br.com.like.services;

import org.springframework.data.domain.Page;

import java.util.List;

public interface BaseService<T> {

    T create(final T object);

    void update(final T object, final Long id);

    T findOne(final Long id);

    List<T> findAll();

    Page<T> findPage(final Integer page, final Integer linesPerPage, final String orderBy, final String direction);

    void delete(final Long id);
}
