package umc.study.repository.MissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.domain.mapping.MemberMission;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom{

    Page<Mission> findAllByStore(Store store, PageRequest pageRequest);
}
