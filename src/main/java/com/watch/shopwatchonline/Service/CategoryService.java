package com.watch.shopwatchonline.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.watch.shopwatchonline.Model.Category;

@Service
public interface CategoryService {

	<S extends Category> S saveAndFlush(S entity);

	<S extends Category> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Category> List<S> saveAll(Iterable<S> entities);

	<S extends Category> S save(S entity);

	Category getOne(Integer id);

	Category getById(Integer id);

	void flush();

	<S extends Category> Optional<S> findOne(Example<S> example);

	Optional<Category> findById(Integer id);

	<S extends Category, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	List<Category> findAllById(Iterable<Integer> ids);

	<S extends Category> Page<S> findAll(Example<S> example, Pageable pageable);

	Page<Category> findAll(Pageable pageable);

	<S extends Category> List<S> findAll(Example<S> example, Sort sort);

	<S extends Category> List<S> findAll(Example<S> example);

	List<Category> findAll(Sort sort);

	List<Category> findAll();

	boolean existsById(Integer id);

	<S extends Category> boolean exists(Example<S> example);

	void deleteInBatch(Iterable<Category> entities);

	void deleteById(Integer id);

	void deleteAllInBatch(Iterable<Category> entities);

	void deleteAllInBatch();

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	void deleteAllById(Iterable<? extends Integer> ids);

	void deleteAll(Iterable<? extends Category> entities);

	void deleteAll();

	void delete(Category entity);

	<S extends Category> long count(Example<S> example);

	long count();

	
}
