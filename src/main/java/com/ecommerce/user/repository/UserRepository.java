package com.ecommerce.user.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

// import com.ecom.ecom_application.models.User;
import com.ecommerce.user.model.*;


@Repository

public interface UserRepository extends MongoRepository<User,String>{

}
