package com.micode.service.implement;

import com.micode.model.Medic;
import com.micode.repository.IGenericRepo;
import com.micode.repository.IMedicRepo;
import com.micode.service.IMedicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicServiceImplement extends CRUDImplement<Medic, Integer> implements IMedicService {

    //@Autowired
    private final IMedicRepo repo;// = new MedicRepo();

    @Override
    protected IGenericRepo<Medic, Integer> getRepo() {
        return repo;
    }

}
