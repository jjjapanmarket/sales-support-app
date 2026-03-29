package com.example.salessupportapp.repository;

import com.example.salessupportapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //CustomerテーブルをJavaから操作できるようにする宣言
}