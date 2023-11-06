package com.example.demo.Users;

import com.example.demo.partners.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserServiceRepository extends JpaRepository<UsersEntity, String> {

}
