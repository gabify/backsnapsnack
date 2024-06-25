package com.gabify.co.backsnapsnack.Assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.gabify.co.backsnapsnack.Controllers.ProductController;
import com.gabify.co.backsnapsnack.Model.Product;

@Component
public class ProductModelAssembler implements RepresentationModelAssembler<Product, EntityModel<Product>> {

    @Override
    public EntityModel<Product> toModel(Product product){

        return EntityModel.of(product,
            linkTo(methodOn(ProductController.class).getProduct(product.getProductId())).withSelfRel(),
            linkTo(methodOn(ProductController.class).getProducts()).withRel("products"));
    }

}
