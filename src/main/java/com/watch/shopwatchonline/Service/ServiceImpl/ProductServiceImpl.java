package com.watch.shopwatchonline.Service.ServiceImpl;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.watch.shopwatchonline.Model.Product;
import com.watch.shopwatchonline.Repository.ProductRepository;
import com.watch.shopwatchonline.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    
   
    @Autowired
	private ProductRepository repository;

    @Override
    public Page<Product> findByAllNotPrice(int id_brand, int id_cate, Pageable pageable) {
        return repository.findByAllNotPrice(id_brand, id_cate, pageable);
    }
    @Override
    public Page<Product> findByCategory(int id_cate, Pageable pageable) {
        return repository.findByCategory(id_cate, pageable);
    }
    @Override
    public Page<Product> findByBrand(int id_brand, Pageable pageable) {
        return repository.findByBrand(id_brand, pageable);
    }

    @Override
    public Page<Product> findByAllOrWhere(String id_cate, String id_brand, float min, float max, Pageable pageable) {
        return repository.findByAllOrWhere(id_cate, id_brand, min, max, pageable);
    }
    @Override
    public Page<Product> findByAll(int id_brand, int id_cate, float min, float max, Pageable pageable) {
        return repository.findByAll(id_brand, id_cate, min, max, pageable);
    }
    @Override
    public Page<Product> findByAllNotBrand(int id_cate, float min, float max, Pageable pageable) {
        return repository.findByAllNotBrand(id_cate, min, max, pageable);
    }
    @Override
    public Page<Product> findByAllNotCate(int id_brand, float min, float max, Pageable pageable) {
        return repository.findByAllNotCate(id_brand, min, max, pageable);
    }
    @Override
    public Page<Product> findByPriceBetween(float min, float max, Pageable pageable) {
        return repository.findByPriceBetween(min, max, pageable);
    }

    @Override
    public Page<Product> findByNameContaining(String keyword, Pageable pageable) {
        return repository.findByNameContaining(keyword, pageable);
    }

    @Override
    public <S extends Product> S save(S entity) {
        return repository.save(entity);
    }

    @Override
    public <S extends Product> Optional<S> findOne(Example<S> example) {
        return repository.findOne(example);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Product> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public List<Product> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public <S extends Product> List<S> saveAll(Iterable<S> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public void flush() {
        repository.flush();
    }

    @Override
    public <S extends Product> S saveAndFlush(S entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public <S extends Product> List<S> saveAllAndFlush(Iterable<S> entities) {
        return repository.saveAllAndFlush(entities);
    }

    @Override
    public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
    public void deleteInBatch(Iterable<Product> entities) {
        repository.deleteInBatch(entities);
    }

    @Override
    public <S extends Product> long count(Example<S> example) {
        return repository.count(example);
    }

    @Override
    public void deleteAllInBatch(Iterable<Product> entities) {
        repository.deleteAllInBatch(entities);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public <S extends Product> boolean exists(Example<S> example) {
        return repository.exists(example);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> ids) {
        repository.deleteAllByIdInBatch(ids);
    }

    @Override
    public void delete(Product entity) {
        repository.delete(entity);
    }
    @Override
    public Page<Product> findByUserName(String username, Pageable pageable) {
        return repository.findByUserName(username, pageable);
    }
    @Override
    public <S extends Product, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        return repository.findBy(example, queryFunction);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> ids) {
        repository.deleteAllById(ids);
    }

    @Override
    public void deleteAllInBatch() {
        repository.deleteAllInBatch();
    }

    @Override
    public Product getOne(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public void deleteAll(Iterable<? extends Product> entities) {
        repository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public Product getById(Integer id) {
        return repository.getById(id);
    }

    @Override
    public <S extends Product> List<S> findAll(Example<S> example) {
        return repository.findAll(example);
    }

    @Override
    public <S extends Product> List<S> findAll(Example<S> example, Sort sort) {
        return repository.findAll(example, sort);
    }

   
   
}