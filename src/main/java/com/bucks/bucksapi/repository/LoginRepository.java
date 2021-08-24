package com.bucks.bucksapi.repository;

import com.bucks.bucksapi.models.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Integer> {

}
