package com.example.room.service.roles;


import com.example.room.model.Role;
import com.example.room.service.GeneralService;

import java.util.Optional;

public interface IRoleService extends GeneralService<Role> {
    Optional<Role> findByName(String name);
}
