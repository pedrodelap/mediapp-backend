package com.micode.service.implement;

import com.micode.model.Patient;
import com.micode.repository.IGenericRepo;
import com.micode.repository.IPatientRepo;
import com.micode.service.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientServiceImplement extends CRUDImplement<Patient, Integer> implements IPatientService {

    //@Autowired
    private final IPatientRepo repo;// = new PatientRepo();

    @Override
    protected IGenericRepo<Patient, Integer> getRepo() {
        return repo;
    }
}
