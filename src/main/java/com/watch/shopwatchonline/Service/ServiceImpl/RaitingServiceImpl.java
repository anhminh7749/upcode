package com.watch.shopwatchonline.Service.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.watch.shopwatchonline.Model.Raiting;
import com.watch.shopwatchonline.Repository.RaitingRepository;
import com.watch.shopwatchonline.Service.RaitingService;

public class RaitingServiceImpl implements RaitingService{
    RaitingRepository raitingRepository;

	@Override
	public List<Raiting> findByProductId(int id_pro) {
		return raitingRepository.findByProductId(id_pro);
	}

	@Override
	public String AvgByProductId(int id_pro) {
		return raitingRepository.AvgByProductId(id_pro);
	}

	@Override
	public Page<Raiting> findByKeyWord(String keyword, Short active, Pageable pageable) {
		return raitingRepository.findByKeyWord(keyword, active, pageable);
	}

	@Override
	public <S extends Raiting> S save(S entity) {
		return raitingRepository.save(entity);
	}

	@Override
	public <S extends Raiting> Optional<S> findOne(Example<S> example) {
		return raitingRepository.findOne(example);
	}

	@Override
	public Page<Raiting> findByActive(Short active, Pageable pageable) {
		return raitingRepository.findByActive(active, pageable);
	}

	@Override
	public List<Raiting> findAll() {
		return raitingRepository.findAll();
	}

	@Override
	public Page<Raiting> findAll(Pageable pageable) {
		return raitingRepository.findAll(pageable);
	}

	@Override
	public List<Raiting> findAll(Sort sort) {
		return raitingRepository.findAll(sort);
	}

	@Override
	public List<Raiting> findAllById(Iterable<Integer> ids) {
		return raitingRepository.findAllById(ids);
	}

	@Override
	public Optional<Raiting> findById(Integer id) {
		return raitingRepository.findById(id);
	}

	@Override
	public <S extends Raiting> List<S> saveAll(Iterable<S> entities) {
		return raitingRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		raitingRepository.flush();
	}

	@Override
	public <S extends Raiting> S saveAndFlush(S entity) {
		return raitingRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return raitingRepository.existsById(id);
	}

	@Override
	public <S extends Raiting> List<S> saveAllAndFlush(Iterable<S> entities) {
		return raitingRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Raiting> Page<S> findAll(Example<S> example, Pageable pageable) {
		return raitingRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Raiting> entities) {
		raitingRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Raiting> long count(Example<S> example) {
		return raitingRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Raiting> entities) {
		raitingRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return raitingRepository.count();
	}

	@Override
	public <S extends Raiting> boolean exists(Example<S> example) {
		return raitingRepository.exists(example);
	}

	@Override
	public void deleteById(Integer id) {
		raitingRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		raitingRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Raiting entity) {
		raitingRepository.delete(entity);
	}

	@Override
	public <S extends Raiting, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return raitingRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		raitingRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		raitingRepository.deleteAllInBatch();
	}

	@Override
	public Raiting getOne(Integer id) {
		return raitingRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Raiting> entities) {
		raitingRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		raitingRepository.deleteAll();
	}

	@Override
	public Raiting getById(Integer id) {
		return raitingRepository.getById(id);
	}

	@Override
	public <S extends Raiting> List<S> findAll(Example<S> example) {
		return raitingRepository.findAll(example);
	}

	@Override
	public <S extends Raiting> List<S> findAll(Example<S> example, Sort sort) {
		return raitingRepository.findAll(example, sort);
	}
    
}
