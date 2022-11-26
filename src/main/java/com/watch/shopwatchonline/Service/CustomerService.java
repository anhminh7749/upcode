package com.watch.shopwatchonline.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.watch.shopwatchonline.Model.Customer;

public interface CustomerService {

    Customer getById(Integer id);

    void deleteAll();

    void deleteAll(Iterable<? extends Customer> entities);

    void deleteAllInBatch();

    void deleteAllById(Iterable<? extends Integer> ids);

    <S extends Customer, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

    void delete(Customer entity);

    void deleteAllByIdInBatch(Iterable<Integer> ids);

    void deleteById(Integer id);

    <S extends Customer> boolean exists(Example<S> example);

    long count();

    void deleteAllInBatch(Iterable<Customer> entities);

    <S extends Customer> List<S> saveAllAndFlush(Iterable<S> entities);

    boolean existsById(Integer id);

    <S extends Customer> S saveAndFlush(S entity);

    void flush();

    <S extends Customer> List<S> saveAll(Iterable<S> entities);

    Optional<Customer> findById(Integer id);

    List<Customer> findAllById(Iterable<Integer> ids);

    List<Customer> findAll(Sort sort);

    Page<Customer> findAll(Pageable pageable);

    List<Customer> findAll();

    <S extends Customer> S save(S entity);

}
