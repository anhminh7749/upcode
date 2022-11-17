package com.watch.shopwatchonline.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.watch.shopwatchonline.Model.Brand;

@Service
public interface BrandService {

    <S extends Brand> List<S> findAll(Example<S> example, Sort sort);

    <S extends Brand> List<S> findAll(Example<S> example);

    Brand getById(Integer id);

    void deleteAll();

    void deleteAll(Iterable<? extends Brand> entities);

    Brand getOne(Integer id);

    void deleteAllInBatch();

    void deleteAllById(Iterable<? extends Integer> ids);

    <S extends Brand, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

    void delete(Brand entity);

    void deleteAllByIdInBatch(Iterable<Integer> ids);

    void deleteById(Integer id);

    <S extends Brand> boolean exists(Example<S> example);

    long count();

    void deleteAllInBatch(Iterable<Brand> entities);

    <S extends Brand> long count(Example<S> example);

    void deleteInBatch(Iterable<Brand> entities);

    <S extends Brand> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Brand> List<S> saveAllAndFlush(Iterable<S> entities);

    boolean existsById(Integer id);

    <S extends Brand> S saveAndFlush(S entity);

    void flush();

    <S extends Brand> List<S> saveAll(Iterable<S> entities);

    Optional<Brand> findById(Integer id);

    List<Brand> findAllById(Iterable<Integer> ids);

    List<Brand> findAll(Sort sort);

    Page<Brand> findAll(Pageable pageable);

    List<Brand> findAll();

    <S extends Brand> Optional<S> findOne(Example<S> example);

    <S extends Brand> S save(S entity);

    

   

}
