package org.yeinp.animate.animate_backend.notice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yeinp.animate.animate_backend.entity.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice,Long> {
}
