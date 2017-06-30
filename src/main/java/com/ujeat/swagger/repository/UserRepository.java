package com.ujeat.swagger.repository;

import com.ujeat.swagger.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户类持久层接口
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
