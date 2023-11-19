package com.micode.service.implement;

import com.micode.model.Specialty;
import com.micode.repository.ISpecialtyRepo;
import com.micode.repository.IGenericRepo;
import com.micode.service.ISpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecialtyServiceImplement extends CRUDImplement<Specialty, Integer> implements ISpecialtyService {

    private final ISpecialtyRepo repo;

    @Override
    protected IGenericRepo<Specialty, Integer> getRepo() {
        return repo;
    }

}
