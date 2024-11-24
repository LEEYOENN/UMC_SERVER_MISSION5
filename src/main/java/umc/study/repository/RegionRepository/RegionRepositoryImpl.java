package umc.study.repository.RegionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RegionRepositoryImpl {
    private final EntityManager em;
    private final JPAQueryFactory jpaQueryFactory;
}
