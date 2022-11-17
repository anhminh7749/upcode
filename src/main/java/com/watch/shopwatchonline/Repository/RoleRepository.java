package com.watch.shopwatchonline.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.watch.shopwatchonline.Model.Erole;
import com.watch.shopwatchonline.Model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(Erole name);
}
