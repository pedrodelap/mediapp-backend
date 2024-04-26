package com.micode.repository;

import com.micode.model.Consult;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface IConsultRepository extends IGenericRepository<Consult, Integer> {

    //FR: JAIME
    //BK BD: jaime
    @Query("FROM Consult c WHERE c.patient.dni = :dni OR LOWER(c.patient.firstName) LIKE %:fullname% OR LOWER(c.patient.lastName) LIKE %:fullname%")
    //JPQL Java Persistence Query Language
    List<Consult> search(@Param("dni") String dni, @Param("fullname") String fullname);

    // >=  |  <
    //10-07-23 | 16-04-23 | 15
    @Query("FROM Consult c WHERE c.consultDate BETWEEN :date1 AND :date2")
    List<Consult> searchByDates(@Param("date1") LocalDateTime date1, @Param("date2") LocalDateTime date2);

    @Query(value = "select * from fn_list()", nativeQuery = true)
    List<?> callProcedureOrFunctionNative();
}
