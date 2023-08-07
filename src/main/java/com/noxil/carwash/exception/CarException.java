package com.noxil.carwash.exception;

public class CarException extends BaseException{

    public CarException(String code) {
        super("Car." + code);
    }
    public static CarException licenseCodeIsNull() {
        return new CarException("LicenseCode.null");
    }
    public static CarException licenseCodeDuplicate(){
        return new CarException("LicenseCode.duplicate");
    }
    public static CarException carSizeIsNull() {
        return new CarException("CarSize.null");
    }
    public static CarException brandIsNull() {
        return new CarException("Brand.null");
    }
    public static CarException detailIsNull() {
        return new CarException("Detail.null");
    }
}
