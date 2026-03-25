package com.ecommerce.user.dto;

// import com.ecom.ecom_application.models.Address;
// import com.ecom.ecom_application.models.UserRole;
import com.ecommerce.user.model.*;

import lombok.Data;

@Data
public class UserResponse {
    private String id;
    private String firstName;
    private String lastName;

    private String email;
    private String phoneNumber;

    private UserRole role;
    private  AddressDTO address; 

    
}
