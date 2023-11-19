package com.micode.service.implement;

import com.micode.model.Consult;
import com.micode.model.Exam;
import com.micode.repository.IConsultExamRepo;
import com.micode.repository.IConsultRepo;
import com.micode.repository.IGenericRepo;
import com.micode.service.IConsultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultServiceImplement extends CRUDImplement<Consult, Integer> implements IConsultService {

    private final IConsultRepo consultRepo;
    private final IConsultExamRepo ceRepo;

    @Override
    protected IGenericRepo<Consult, Integer> getRepo() {
        return consultRepo;
    }

    @Transactional//(timeout = 300)
    @Override
    public Consult saveTransactional(Consult consult, List<Exam> exams) {
        //consult.getDetails().forEach(det -> det.setConsult(consult));
        consultRepo.save(consult); //GUARDADO MAESTRO DETALLE
        exams.forEach(ex -> ceRepo.saveExam(consult.getIdConsult(), ex.getIdExam()));

        return consult;
    }
}
