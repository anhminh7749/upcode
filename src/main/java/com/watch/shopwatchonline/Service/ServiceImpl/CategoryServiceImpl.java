package com.watch.shopwatchonline.Service.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.watch.shopwatchonline.Model.Category;
import com.watch.shopwatchonline.Repository.CategoryRepository;
import com.watch.shopwatchonline.Service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
    
    @Autowired
	private CategoryRepository repository;

    @Override
	public long count() {
        return repository.count();
    }

    @Override
	public <S extends Category> long count(Example<S> example) {
        return repository.count(example);
    }

    @Override
	public void delete(Category entity) {
        repository.delete(entity);
    }

    @Override
	public void deleteAll() {
        repository.deleteAll();
    }

    @Override
	public void deleteAll(Iterable<? extends Category> entities) {
        repository.deleteAll(entities);
    }

    @Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
        repository.deleteAllById(ids);
    }

    @Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
        repository.deleteAllByIdInBatch(ids);
    }

    @Override
	public void deleteAllInBatch() {
        repository.deleteAllInBatch();
    }

    @Override
	public void deleteAllInBatch(Iterable<Category> entities) {
        repository.deleteAllInBatch(entities);
    }

    @Override
	public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
	public void deleteInBatch(Iterable<Category> entities) {
        repository.deleteInBatch(entities);
    }

    @Override
	public <S extends Category> boolean exists(Example<S> example) {
        return repository.exists(example);
    }

    @Override
	public boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    @Override
	public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
	public List<Category> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
	public <S extends Category> List<S> findAll(Example<S> example) {
        return repository.findAll(example);
    }

    @Override
	public <S extends Category> List<S> findAll(Example<S> example, Sort sort) {
        return repository.findAll(example, sort);
    }

    @Override
	public Page<Category> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
	public <S extends Category> Page<S> findAll(Example<S> example, Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
	public List<Category> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    @Override
	public <S extends Category, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        return repository.findBy(example, queryFunction);
    }

    @Override
	public Optional<Category> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
	public <S extends Category> Optional<S> findOne(Example<S> example) {
        return repository.findOne(example);
    }

    @Override
	public void flush() {
        repository.flush();
    }

    @Override
	public Category getById(Integer id) {
        return repository.getById(id);
    }

    @Override
	public Category getOne(Integer id) {
        return repository.getOne(id);
    }

    @Override
	public <S extends Category> S save(S entity) {
        return repository.save(entity);
    }

    @Override
	public <S extends Category> List<S> saveAll(Iterable<S> entities) {
        return repository.saveAll(entities);
    }

    @Override
	public <S extends Category> List<S> saveAllAndFlush(Iterable<S> entities) {
        return repository.saveAllAndFlush(entities);
    }

    @Override
	public <S extends Category> S saveAndFlush(S entity) {
        return repository.saveAndFlush(entity);
    }

    
}
