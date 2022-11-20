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

import com.watch.shopwatchonline.Model.Staff;
import com.watch.shopwatchonline.Repository.StaffRepository;
import com.watch.shopwatchonline.Service.StaffService;

@Service
public class StaffServiceImpl implements StaffService {
    StaffRepository staffRepository;

    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public <S extends Staff> S save(S entity) {
        return staffRepository.save(entity);
    }

    @Override
    public <S extends Staff> Optional<S> findOne(Example<S> example) {
        return staffRepository.findOne(example);
    }

    @Override
    public List<Staff> findAll() {
        return staffRepository.findAll();
    }

    @Override
    public Page<Staff> findAll(Pageable pageable) {
        return staffRepository.findAll(pageable);
    }

    @Override
    public List<Staff> findAll(Sort sort) {
        return staffRepository.findAll(sort);
    }

    @Override
    public List<Staff> findAllById(Iterable<Integer> ids) {
        return staffRepository.findAllById(ids);
    }

    @Override
    public Optional<Staff> findById(Integer id) {
        return staffRepository.findById(id);
    }

    @Override
    public <S extends Staff> List<S> saveAll(Iterable<S> entities) {
        return staffRepository.saveAll(entities);
    }

    @Override
    public void flush() {
        staffRepository.flush();
    }

    @Override
    public <S extends Staff> S saveAndFlush(S entity) {
        return staffRepository.saveAndFlush(entity);
    }

    @Override
    public boolean existsById(Integer id) {
        return staffRepository.existsById(id);
    }

    @Override
    public <S extends Staff> List<S> saveAllAndFlush(Iterable<S> entities) {
        return staffRepository.saveAllAndFlush(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Staff> entities) {
        staffRepository.deleteAllInBatch(entities);
    }

    @Override
    public long count() {
        return staffRepository.count();
    }

    @Override
    public <S extends Staff> boolean exists(Example<S> example) {
        return staffRepository.exists(example);
    }

    @Override
    public void deleteById(Integer id) {
        staffRepository.deleteById(id);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> ids) {
        staffRepository.deleteAllByIdInBatch(ids);
    }

    @Override
    public void delete(Staff entity) {
        staffRepository.delete(entity);
    }

    @Override
    public <S extends Staff, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        return staffRepository.findBy(example, queryFunction);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> ids) {
        staffRepository.deleteAllById(ids);
    }

    @Override
    public void deleteAllInBatch() {
        staffRepository.deleteAllInBatch();
    }

    @Override
    public void deleteAll(Iterable<? extends Staff> entities) {
        staffRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        staffRepository.deleteAll();
    }

    @Override
    public Staff getById(Integer id) {
        return staffRepository.getById(id);
    }
    
}
