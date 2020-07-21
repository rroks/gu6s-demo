package fen.fen.service.sys;

import fen.fen.model.dto.UserEntity;
import fen.fen.model.query.FindPagedUsersQuery;
import org.springframework.data.domain.Page;

public interface UserInfoService {
    UserEntity findByUsername(String username);
    Page<UserEntity> findAllByUsernameLike(FindPagedUsersQuery query);
}
