package umc.study.repository.MissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mapping.MemberMission;

public interface MissionRepository extends JpaRepository<MemberMission, Long>, MissionRepositoryCustom{
}
