package com.micode.service.implement;

import com.micode.model.Menu;
import com.micode.repository.IGenericRepository;
import com.micode.repository.IMenuRepository;
import com.micode.service.IMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuServiceImplement extends CRUDImplement<Menu, Integer> implements IMenuService {

    private final IMenuRepository repo;

    @Override
    protected IGenericRepository<Menu, Integer> getRepo() {
        return repo;
    }

}
