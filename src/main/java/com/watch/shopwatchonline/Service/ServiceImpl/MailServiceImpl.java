package com.watch.shopwatchonline.Service.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.watch.shopwatchonline.Model.Customer;
import com.watch.shopwatchonline.Model.Mail;
import com.watch.shopwatchonline.Repository.CustomerRepository;
import com.watch.shopwatchonline.Repository.MailRepository;
import com.watch.shopwatchonline.Service.CustomerService;
import com.watch.shopwatchonline.Service.MailService;

@Service
public class MailServiceImpl implements MailService {
    MailRepository mailRepository;

	@Override
	public <S extends Mail> S save(S entity) {
		return mailRepository.save(entity);
	}

	@Override
	public <S extends Mail> Optional<S> findOne(Example<S> example) {
		return mailRepository.findOne(example);
	}

	@Override
	public List<Mail> findAll() {
		return mailRepository.findAll();
	}

	@Override
	public Page<Mail> findAll(Pageable pageable) {
		return mailRepository.findAll(pageable);
	}

	@Override
	public List<Mail> findAll(Sort sort) {
		return mailRepository.findAll(sort);
	}

	@Override
	public List<Mail> findAllById(Iterable<Integer> ids) {
		return mailRepository.findAllById(ids);
	}

	@Override
	public Optional<Mail> findById(Integer id) {
		return mailRepository.findById(id);
	}

	@Override
	public <S extends Mail> List<S> saveAll(Iterable<S> entities) {
		return mailRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		mailRepository.flush();
	}

	@Override
	public <S extends Mail> S saveAndFlush(S entity) {
		return mailRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return mailRepository.existsById(id);
	}

	@Override
	public <S extends Mail> List<S> saveAllAndFlush(Iterable<S> entities) {
		return mailRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Mail> Page<S> findAll(Example<S> example, Pageable pageable) {
		return mailRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Mail> entities) {
		mailRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Mail> long count(Example<S> example) {
		return mailRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Mail> entities) {
		mailRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return mailRepository.count();
	}

	@Override
	public <S extends Mail> boolean exists(Example<S> example) {
		return mailRepository.exists(example);
	}

	@Override
	public void deleteById(Integer id) {
		mailRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		mailRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Mail entity) {
		mailRepository.delete(entity);
	}

	@Override
	public <S extends Mail, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return mailRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		mailRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		mailRepository.deleteAllInBatch();
	}

	@Override
	public Mail getOne(Integer id) {
		return mailRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Mail> entities) {
		mailRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		mailRepository.deleteAll();
	}

	@Override
	public Mail getById(Integer id) {
		return mailRepository.getById(id);
	}

	@Override
	public <S extends Mail> List<S> findAll(Example<S> example) {
		return mailRepository.findAll(example);
	}

	@Override
	public <S extends Mail> List<S> findAll(Example<S> example, Sort sort) {
		return mailRepository.findAll(example, sort);
	}
    
}
