package com.noxil.carwash.exception;

public class ProductException extends BaseException{

    public ProductException(String code) {
        super("Product."+code);
    }

    public static ProductException nameIsNull(){
        return new ProductException("name.null");
    }

    public static ProductException notFound(){
        return new ProductException("not.found");
    }
}
