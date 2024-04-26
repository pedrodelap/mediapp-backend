package com.micode.service.implement;

import com.micode.model.Consult;
import com.micode.model.Exam;
import com.micode.repository.IConsultExamRepository;
import com.micode.repository.IConsultRepository;
import com.micode.repository.IGenericRepository;
import com.micode.service.IConsultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultServiceImplement extends CRUDImplement<Consult, Integer> implements IConsultService {

    private final IConsultRepository consultRepo;
    private final IConsultExamRepository ceRepo;

    @Override
    protected IGenericRepository<Consult, Integer> getRepo() {
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

    @Override
    public List<Consult> search(String dni, String fullname) {
        return consultRepo.search(dni, fullname);
    }

    @Override
    public List<Consult> searchByDates(LocalDateTime date1, LocalDateTime date2) {
        final int OFFSET_DAYS = 1;
        return consultRepo.searchByDates(date1, date2.plusDays(OFFSET_DAYS));
    }


}
