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
import com.watch.shopwatchonline.Model.Mail;

public interface MailService {

	<S extends Mail> List<S> findAll(Example<S> example, Sort sort);

	<S extends Mail> List<S> findAll(Example<S> example);

	Mail getById(Integer id);

	void deleteAll();

	void deleteAll(Iterable<? extends Mail> entities);

	Mail getOne(Integer id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Integer> ids);

	<S extends Mail, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Mail entity);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	void deleteById(Integer id);

	<S extends Mail> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Mail> entities);

	<S extends Mail> long count(Example<S> example);

	void deleteInBatch(Iterable<Mail> entities);

	<S extends Mail> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Mail> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Integer id);

	<S extends Mail> S saveAndFlush(S entity);

	void flush();

	<S extends Mail> List<S> saveAll(Iterable<S> entities);

	Optional<Mail> findById(Integer id);

	List<Mail> findAllById(Iterable<Integer> ids);

	List<Mail> findAll(Sort sort);

	Page<Mail> findAll(Pageable pageable);

	List<Mail> findAll();

	<S extends Mail> Optional<S> findOne(Example<S> example);

	<S extends Mail> S save(S entity);


}
