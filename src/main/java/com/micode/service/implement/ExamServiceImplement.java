package com.micode.service.implement;

import com.micode.model.Exam;
import com.micode.repository.IGenericRepo;
import com.micode.repository.IExamRepo;
import com.micode.service.IExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamServiceImplement extends CRUDImplement<Exam, Integer> implements IExamService {

    private final IExamRepo repo;

    @Override
    protected IGenericRepo<Exam, Integer> getRepo() {
        return repo;
    }

}
