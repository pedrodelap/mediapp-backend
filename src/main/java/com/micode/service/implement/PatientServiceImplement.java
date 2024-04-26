package com.micode.service.implement;

import com.micode.model.Patient;
import com.micode.repository.IGenericRepository;
import com.micode.repository.IPatientRepository;
import com.micode.service.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientServiceImplement extends CRUDImplement<Patient, Integer> implements IPatientService {

    //@Autowired
    private final IPatientRepository repo;// = new PatientRepo();

    @Override
    protected IGenericRepository<Patient, Integer> getRepo() {
        return repo;
    }
}
