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

import com.watch.shopwatchonline.Model.Blog;
import com.watch.shopwatchonline.Model.Product;
import com.watch.shopwatchonline.Repository.BlogRepository;
import com.watch.shopwatchonline.Repository.ProductRepository;
import com.watch.shopwatchonline.Service.BlogService;
import com.watch.shopwatchonline.Service.ProductService;

@Service
public class BlogServiceImpl implements BlogService {
    
   
    @Autowired
	private BlogRepository repository;

    @Override
    public <S extends Blog> S save(S entity) {
        return repository.save(entity);
    }

    @Override
    public <S extends Blog> Optional<S> findOne(Example<S> example) {
        return repository.findOne(example);
    }

    @Override
    public List<Blog> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Blog> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public List<Blog> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public <S extends Blog> List<S> saveAll(Iterable<S> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public void flush() {
        repository.flush();
    }

    @Override
    public <S extends Blog> S saveAndFlush(S entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public <S extends Blog> List<S> saveAllAndFlush(Iterable<S> entities) {
        return repository.saveAllAndFlush(entities);
    }

    @Override
    public <S extends Blog> Page<S> findAll(Example<S> example, Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
    public void deleteInBatch(Iterable<Blog> entities) {
        repository.deleteInBatch(entities);
    }

    @Override
    public <S extends Blog> long count(Example<S> example) {
        return repository.count(example);
    }

    @Override
    public void deleteAllInBatch(Iterable<Blog> entities) {
        repository.deleteAllInBatch(entities);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public <S extends Blog> boolean exists(Example<S> example) {
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
    public void delete(Blog entity) {
        repository.delete(entity);
    }

    @Override
    public <S extends Blog, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
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
    public Blog getOne(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public void deleteAll(Iterable<? extends Blog> entities) {
        repository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public Blog getById(Integer id) {
        return repository.getById(id);
    }

    @Override
    public <S extends Blog> List<S> findAll(Example<S> example) {
        return repository.findAll(example);
    }

    @Override
    public <S extends Blog> List<S> findAll(Example<S> example, Sort sort) {
        return repository.findAll(example, sort);
    }

    

    
   
}