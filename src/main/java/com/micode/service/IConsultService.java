package com.micode.service;

import com.micode.model.Consult;
import com.micode.model.Exam;

import java.time.LocalDateTime;
import java.util.List;

public interface IConsultService extends ICRUD<Consult, Integer> {

    Consult saveTransactional(Consult consult, List<Exam> exams);
    List<Consult> search(String dni, String fullname);
    List<Consult> searchByDates(LocalDateTime date1, LocalDateTime date2);

}
