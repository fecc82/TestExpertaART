package com.expertaart.refactorapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.expertaart.refactorapp.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
