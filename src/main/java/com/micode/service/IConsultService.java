package com.micode.service;

import com.micode.model.Consult;
import com.micode.model.Exam;

import java.util.List;

public interface IConsultService extends ICRUD<Consult, Integer> {

    Consult saveTransactional(Consult consult, List<Exam> exams);

}
