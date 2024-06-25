package com.gabify.co.backsnapsnack.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabify.co.backsnapsnack.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
