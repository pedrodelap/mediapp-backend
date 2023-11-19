package com.micode.repository;

import com.micode.model.Medic;
import com.micode.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicRepo extends IGenericRepo<Medic, Integer> {

}
