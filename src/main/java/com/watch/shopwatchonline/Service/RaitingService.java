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

import com.watch.shopwatchonline.Model.Raiting;

@Service
public interface RaitingService {

	<S extends Raiting> List<S> findAll(Example<S> example, Sort sort);

	<S extends Raiting> List<S> findAll(Example<S> example);

	Raiting getById(Integer id);

	void deleteAll();

	void deleteAll(Iterable<? extends Raiting> entities);

	Raiting getOne(Integer id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Integer> ids);

	<S extends Raiting, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Raiting entity);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	void deleteById(Integer id);

	<S extends Raiting> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Raiting> entities);

	<S extends Raiting> long count(Example<S> example);

	void deleteInBatch(Iterable<Raiting> entities);

	<S extends Raiting> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Raiting> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Integer id);

	<S extends Raiting> S saveAndFlush(S entity);

	void flush();

	<S extends Raiting> List<S> saveAll(Iterable<S> entities);

	Optional<Raiting> findById(Integer id);

	List<Raiting> findAllById(Iterable<Integer> ids);

	List<Raiting> findAll(Sort sort);

	Page<Raiting> findAll(Pageable pageable);

	List<Raiting> findAll();

	Page<Raiting> findByActive(Short active, Pageable pageable);

	<S extends Raiting> Optional<S> findOne(Example<S> example);

	<S extends Raiting> S save(S entity);

	Page<Raiting> findByKeyWord(String keyword, Short active, Pageable pageable);

	String AvgByProductId(int id_pro);

	List<Raiting> findByProductId(int id_pro);
    
}
