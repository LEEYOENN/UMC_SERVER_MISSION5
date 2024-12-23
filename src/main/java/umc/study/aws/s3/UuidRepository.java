package umc.study.aws.s3;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Uuid;

public interface UuidRepository extends JpaRepository<Uuid, Long>{
}
