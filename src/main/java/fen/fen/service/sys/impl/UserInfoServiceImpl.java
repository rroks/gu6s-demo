package fen.fen.service.sys.impl;

import fen.fen.model.dto.UserEntity;
import fen.fen.model.query.FindPagedUsersQuery;
import fen.fen.repository.UserRepository;
import fen.fen.service.sys.UserInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    UserRepository userRepository;

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Page<UserEntity> findAllByUsernameLike(FindPagedUsersQuery query) {
        Pageable pageConditions = PageRequest.of(query.getPageIndex(), query.getPageSize());
        String likeFormat = "%" + query.getUsername() + "%";
        return userRepository.findAllByUsernameLike(likeFormat, pageConditions);
    }
}
