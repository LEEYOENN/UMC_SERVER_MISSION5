package umc.study.repository.RevieRepository;

public interface ReviewRepositoryCustom {
    void dynamicQueryWithBooleanBuilder(Long memberId, Long storeId, String body, float score);
}