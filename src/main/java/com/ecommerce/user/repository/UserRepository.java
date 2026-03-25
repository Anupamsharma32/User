package com.ecommerce.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// import com.ecom.ecom_application.models.User;
import com.ecommerce.user.model.*;


@Repository

public interface UserRepository extends JpaRepository<User,Long>{

}
