package com.watch.shopwatchonline.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.watch.shopwatchonline.Model.Staff;

public interface StaffService {

    Staff getById(Integer id);

    void deleteAll();

    void deleteAll(Iterable<? extends Staff> entities);

    void deleteAllInBatch();

    void deleteAllById(Iterable<? extends Integer> ids);

    <S extends Staff, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

    void delete(Staff entity);

    void deleteAllByIdInBatch(Iterable<Integer> ids);

    void deleteById(Integer id);

    <S extends Staff> boolean exists(Example<S> example);

    long count();

    void deleteAllInBatch(Iterable<Staff> entities);

    <S extends Staff> List<S> saveAllAndFlush(Iterable<S> entities);

    boolean existsById(Integer id);

    <S extends Staff> S saveAndFlush(S entity);

    void flush();

    <S extends Staff> List<S> saveAll(Iterable<S> entities);

    Optional<Staff> findById(Integer id);

    List<Staff> findAllById(Iterable<Integer> ids);

    List<Staff> findAll(Sort sort);

    Page<Staff> findAll(Pageable pageable);

    List<Staff> findAll();

    <S extends Staff> Optional<S> findOne(Example<S> example);

    <S extends Staff> S save(S entity);

}
