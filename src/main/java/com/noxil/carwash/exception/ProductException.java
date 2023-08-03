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

    public static ProductException descIsNull(){
        return new ProductException("desc.null");
    }

    public static ProductException priceIsNull(){
        return new ProductException("price.null");
    }

    public static ProductException pricenotZero(){
        return new ProductException("price.notzero");
    }

    public static ProductException nameDuplicate(){
        return new ProductException("name.duplicate");
    }
}
