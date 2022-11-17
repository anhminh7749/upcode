package com.watch.shopwatchonline.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.watch.shopwatchonline.Model.Blog;
import com.watch.shopwatchonline.Model.Product;

@Service
public interface BlogService {

    <S extends Blog> List<S> findAll(Example<S> example, Sort sort);

    <S extends Blog> List<S> findAll(Example<S> example);

    Blog getById(Integer id);

    void deleteAll();

    void deleteAll(Iterable<? extends Blog> entities);

    Blog getOne(Integer id);

    void deleteAllInBatch();

    void deleteAllById(Iterable<? extends Integer> ids);

    <S extends Blog, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

    void delete(Blog entity);

    void deleteAllByIdInBatch(Iterable<Integer> ids);

    void deleteById(Integer id);

    <S extends Blog> boolean exists(Example<S> example);

    long count();

    void deleteAllInBatch(Iterable<Blog> entities);

    <S extends Blog> long count(Example<S> example);

    void deleteInBatch(Iterable<Blog> entities);

    <S extends Blog> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Blog> List<S> saveAllAndFlush(Iterable<S> entities);

    boolean existsById(Integer id);

    <S extends Blog> S saveAndFlush(S entity);

    void flush();

    <S extends Blog> List<S> saveAll(Iterable<S> entities);

    Optional<Blog> findById(Integer id);

    List<Blog> findAllById(Iterable<Integer> ids);

    List<Blog> findAll(Sort sort);

    Page<Blog> findAll(Pageable pageable);

    List<Blog> findAll();

    <S extends Blog> Optional<S> findOne(Example<S> example);

    <S extends Blog> S save(S entity);

    
}
