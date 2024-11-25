package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import umc.study.validation.annotation.CheckPage;

public class PageValidator implements ConstraintValidator<CheckPage, Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if(value == null || value < 1){
            return false; //페이지 번호는 1이상이어야
        }
        return true;
    }
}
