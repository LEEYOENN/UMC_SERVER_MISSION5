package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.validation.annotation.ExistStore;

public class ExistStoreValidator implements ConstraintValidator<ExistStore, Long> {

    @Autowired
    private StoreRepository storeRepository; //가게정보 확인 리포

    @Override
    public boolean isValid(Long storeId, ConstraintValidatorContext context) {
        if(storeId == null){
            return false;
        }
        return storeRepository.existsById(storeId);//가게 존재여부 확인
    }
}
