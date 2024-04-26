package com.micode.service.implement;

import com.micode.model.Exam;
import com.micode.repository.IGenericRepository;
import com.micode.repository.IExamRepository;
import com.micode.service.IExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamServiceImplement extends CRUDImplement<Exam, Integer> implements IExamService {

    private final IExamRepository repo;

    @Override
    protected IGenericRepository<Exam, Integer> getRepo() {
        return repo;
    }

}
