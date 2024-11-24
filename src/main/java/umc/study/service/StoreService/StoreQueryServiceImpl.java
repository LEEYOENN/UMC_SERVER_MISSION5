package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.StoreConverter;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.repository.RegionRepository.RegionRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    private final StoreConverter storeConverter;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findStoresByNameAndScore(String name, Float score){
        List<Store> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);

        filteredStores.forEach(store -> System.out.println("Store: " + store));

        return filteredStores;
    }

    @Override
    public Store addStore(StoreRequestDTO.AddDTO storeDTO) {
       //지역이 존재하는 지 확인
        Region region = regionRepository.findById(storeDTO.getRegionId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 지역 아이디입니다."));
        //store 엔티티 생성 및 저장
        Store store = storeConverter.toEntity(storeDTO, region);

        storeRepository.save(store);
        return store;
    }

}
