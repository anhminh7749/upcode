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

import com.watch.shopwatchonline.Model.Brand;
import com.watch.shopwatchonline.Repository.BrandRepository;
import com.watch.shopwatchonline.Service.BrandService;

@Service
public class BrandServiceImpl  implements BrandService{
    @Autowired
    BrandRepository brandRepository;
    
    @Override
    public <S extends Brand> S save(S entity) {
        return brandRepository.save(entity);
    }

    @Override
    public <S extends Brand> Optional<S> findOne(Example<S> example) {
        return brandRepository.findOne(example);
    }

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Page<Brand> findAll(Pageable pageable) {
        return brandRepository.findAll(pageable);
    }

    @Override
    public List<Brand> findAll(Sort sort) {
        return brandRepository.findAll(sort);
    }

    @Override
    public List<Brand> findAllById(Iterable<Integer> ids) {
        return brandRepository.findAllById(ids);
    }

    @Override
    public Optional<Brand> findById(Integer id) {
        return brandRepository.findById(id);
    }

    @Override
    public <S extends Brand> List<S> saveAll(Iterable<S> entities) {
        return brandRepository.saveAll(entities);
    }

    @Override
    public void flush() {
        brandRepository.flush();
    }

    @Override
    public <S extends Brand> S saveAndFlush(S entity) {
        return brandRepository.saveAndFlush(entity);
    }

    @Override
    public boolean existsById(Integer id) {
        return brandRepository.existsById(id);
    }

    @Override
    public <S extends Brand> List<S> saveAllAndFlush(Iterable<S> entities) {
        return brandRepository.saveAllAndFlush(entities);
    }

    @Override
    public <S extends Brand> Page<S> findAll(Example<S> example, Pageable pageable) {
        return brandRepository.findAll(example, pageable);
    }

    @Override
    public void deleteInBatch(Iterable<Brand> entities) {
        brandRepository.deleteInBatch(entities);
    }

    @Override
    public <S extends Brand> long count(Example<S> example) {
        return brandRepository.count(example);
    }

    @Override
    public void deleteAllInBatch(Iterable<Brand> entities) {
        brandRepository.deleteAllInBatch(entities);
    }

    @Override
    public long count() {
        return brandRepository.count();
    }

    @Override
    public <S extends Brand> boolean exists(Example<S> example) {
        return brandRepository.exists(example);
    }

    @Override
    public void deleteById(Integer id) {
        brandRepository.deleteById(id);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> ids) {
        brandRepository.deleteAllByIdInBatch(ids);
    }

    @Override
    public void delete(Brand entity) {
        brandRepository.delete(entity);
    }

    @Override
    public <S extends Brand, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        return brandRepository.findBy(example, queryFunction);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> ids) {
        brandRepository.deleteAllById(ids);
    }

    @Override
    public void deleteAllInBatch() {
        brandRepository.deleteAllInBatch();
    }

    @Override
    public Brand getOne(Integer id) {
        return brandRepository.getOne(id);
    }

    @Override
    public void deleteAll(Iterable<? extends Brand> entities) {
        brandRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        brandRepository.deleteAll();
    }

    @Override
    public Brand getById(Integer id) {
        return brandRepository.getById(id);
    }

    @Override
    public <S extends Brand> List<S> findAll(Example<S> example) {
        return brandRepository.findAll(example);
    }

    @Override
    public <S extends Brand> List<S> findAll(Example<S> example, Sort sort) {
        return brandRepository.findAll(example, sort);
    }
    
    
}
