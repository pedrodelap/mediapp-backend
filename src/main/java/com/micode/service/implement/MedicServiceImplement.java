package com.micode.service.implement;

import com.micode.model.Medic;
import com.micode.repository.IGenericRepository;
import com.micode.repository.IMedicRepository;
import com.micode.service.IMedicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicServiceImplement extends CRUDImplement<Medic, Integer> implements IMedicService {

    //@Autowired
    private final IMedicRepository repo;// = new MedicRepo();

    @Override
    protected IGenericRepository<Medic, Integer> getRepo() {
        return repo;
    }

}
