package com.futcleats.config.constraints;

import com.futcleats.config.validation.NotEmptyList;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class NotEmptyListValidator implements ConstraintValidator<NotEmptyList, List> {

    public boolean isValid(List list,
                           ConstraintValidatorContext constraintValidatorContext){
        return list != null && !list.isEmpty();
    }

    public void initialize(NotEmptyList constraintAnnotation){
        constraintAnnotation.message();
    }
}
