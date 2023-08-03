package com.noxil.carwash.business;

import com.noxil.carwash.entity.Product;
import com.noxil.carwash.exception.BaseException;
import com.noxil.carwash.exception.FileException;
import com.noxil.carwash.exception.ProductException;
import com.noxil.carwash.mapper.ProductMapper;
import com.noxil.carwash.model.MProductRequest;
import com.noxil.carwash.model.MProductResponse;
import com.noxil.carwash.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class ProductBusiness {

    private final ProductService productService;

    private final ProductMapper productMapper;

    public ProductBusiness(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    public String getProductById(String id) throws BaseException {

        if(Objects.equals("1234",id)){
            throw ProductException.notFound();
        }
        return id;
    }

    public String uploadProductPicture(MultipartFile file) throws BaseException {
        if(file == null){
            throw FileException.requestNull();
        }

        if(file.getSize() > (1048576 * 2)){
            throw FileException.fileOverSize();
        }

        String contentType = file.getContentType();
        if(contentType == null){
            throw FileException.fileNullcontentType();
        }

        List<String> supportTypes = Arrays.asList("image/jpeg","image/png");
        if(!supportTypes.contains(contentType)){
            throw FileException.fileIncorrectContentType();
        }

        try {
            byte[] bytes = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    public MProductResponse createNew(MProductRequest request) throws BaseException {
        if (request == null) {
            throw ProductException.nameIsNull();
        }

        Product product = productService.create(request.getName(),request.getDetail(),request.getPrice());

        return productMapper.toProductResponse(product);
    }
}
