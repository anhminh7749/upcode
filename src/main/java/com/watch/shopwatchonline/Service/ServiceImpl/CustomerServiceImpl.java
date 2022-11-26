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
import com.watch.shopwatchonline.Repository.CustomerRepository;
import com.watch.shopwatchonline.Service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository;
    
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public <S extends Customer> S save(S entity) {
        return customerRepository.save(entity);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public List<Customer> findAll(Sort sort) {
        return customerRepository.findAll(sort);
    }

    @Override
    public List<Customer> findAllById(Iterable<Integer> ids) {
        return customerRepository.findAllById(ids);
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public <S extends Customer> List<S> saveAll(Iterable<S> entities) {
        return customerRepository.saveAll(entities);
    }

    @Override
    public void flush() {
        customerRepository.flush();
    }

    @Override
    public <S extends Customer> S saveAndFlush(S entity) {
        return customerRepository.saveAndFlush(entity);
    }

    @Override
    public boolean existsById(Integer id) {
        return customerRepository.existsById(id);
    }

    @Override
    public <S extends Customer> List<S> saveAllAndFlush(Iterable<S> entities) {
        return customerRepository.saveAllAndFlush(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Customer> entities) {
        customerRepository.deleteAllInBatch(entities);
    }

    @Override
    public long count() {
        return customerRepository.count();
    }

    @Override
    public <S extends Customer> boolean exists(Example<S> example) {
        return customerRepository.exists(example);
    }

    @Override
    public void deleteById(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> ids) {
        customerRepository.deleteAllByIdInBatch(ids);
    }

    @Override
    public void delete(Customer entity) {
        customerRepository.delete(entity);
    }

    @Override
    public <S extends Customer, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        return customerRepository.findBy(example, queryFunction);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> ids) {
        customerRepository.deleteAllById(ids);
    }

    @Override
    public void deleteAllInBatch() {
        customerRepository.deleteAllInBatch();
    }

    @Override
    public void deleteAll(Iterable<? extends Customer> entities) {
        customerRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        customerRepository.deleteAll();
    }

    @Override
    public Customer getById(Integer id) {
        return customerRepository.getById(id);
    }
    
}
