package com.noxil.carwash.exception;

public class FileException extends BaseException{
    public FileException(String code) {
        super("File."+code);
    }

    public static FileException requestNull(){
        return new FileException("file.null");
    }

    public static FileException fileOverSize(){
        return new FileException("File.Over.Size");
    }

    public static FileException fileNullcontentType(){
        return new FileException("contentType.null");
    }

    public static FileException fileIncorrectContentType(){
        return new FileException("contentType.not.match");
    }
}
