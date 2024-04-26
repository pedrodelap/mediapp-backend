package com.micode.service.implement;

import com.micode.model.Specialty;
import com.micode.repository.ISpecialtyRepository;
import com.micode.repository.IGenericRepository;
import com.micode.service.ISpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecialtyServiceImplement extends CRUDImplement<Specialty, Integer> implements ISpecialtyService {

    private final ISpecialtyRepository repo;

    @Override
    protected IGenericRepository<Specialty, Integer> getRepo() {
        return repo;
    }

}
