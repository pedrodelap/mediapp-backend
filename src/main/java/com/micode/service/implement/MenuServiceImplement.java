package com.micode.service.implement;

import com.micode.model.Menu;
import com.micode.repository.IGenericRepo;
import com.micode.repository.IMenuRepo;
import com.micode.service.IMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuServiceImplement extends CRUDImplement<Menu, Integer> implements IMenuService {

    private final IMenuRepo repo;

    @Override
    protected IGenericRepo<Menu, Integer> getRepo() {
        return repo;
    }

}
