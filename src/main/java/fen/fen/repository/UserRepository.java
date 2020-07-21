package fen.fen.repository;

import fen.fen.model.dto.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author chenyufeng
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
    Page<UserEntity> findAllByUsernameLike(String name, Pageable pageable);
}
