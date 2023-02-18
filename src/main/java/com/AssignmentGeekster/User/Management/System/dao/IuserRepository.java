package com.AssignmentGeekster.User.Management.System.dao;

import com.AssignmentGeekster.User.Management.System.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("IuserRepository")
public interface IuserRepository extends JpaRepository<User,Integer> {

}
