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

import com.watch.shopwatchonline.Model.Product;

@Service
public interface ProductService {

    <S extends Product> List<S> findAll(Example<S> example, Sort sort);

    <S extends Product> List<S> findAll(Example<S> example);

    Product getById(Integer id);

    void deleteAll();

    void deleteAll(Iterable<? extends Product> entities);

    Product getOne(Integer id);

    void deleteAllInBatch();

    void deleteAllById(Iterable<? extends Integer> ids);

    <S extends Product, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

    void delete(Product entity);

    void deleteAllByIdInBatch(Iterable<Integer> ids);

    void deleteById(Integer id);

    <S extends Product> boolean exists(Example<S> example);

    long count();

    void deleteAllInBatch(Iterable<Product> entities);

    <S extends Product> long count(Example<S> example);

    void deleteInBatch(Iterable<Product> entities);

    <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Product> List<S> saveAllAndFlush(Iterable<S> entities);

    boolean existsById(Integer id);

    <S extends Product> S saveAndFlush(S entity);

    void flush();

    <S extends Product> List<S> saveAll(Iterable<S> entities);

    Optional<Product> findById(Integer id);

    List<Product> findAllById(Iterable<Integer> ids);

    List<Product> findAll(Sort sort);

    Page<Product> findAll(Pageable pageable);

    List<Product> findAll();

    <S extends Product> Optional<S> findOne(Example<S> example);

    <S extends Product> S save(S entity);

    Page<Product> findByNameContaining(String keyword, Pageable pageable);

    Page<Product> findByAll(int id_brand, int id_cate, float min, float max, Pageable pageable);
	Page<Product> findByAllNotBrand(int id_cate, float min, float max, Pageable pageable) ;
	Page<Product> findByAllNotCate(int id_brand, float min, float max, Pageable pageable);
	Page<Product> findByPriceBetween(float min, float max, Pageable pageable) ;
    Page<Product> findByAllOrWhere(String id_cate, String id_brand, float min, float max, Pageable pageable);
    Page<Product> findByAllNotPrice(int id_brand, int id_cate, Pageable pageable);
    Page<Product> findByCategory(int id_cate, Pageable pageable);
    Page<Product> findByBrand(int id_brand, Pageable pageable);

    Page<Product> findByUserName(String username, Pageable pageable);
}
