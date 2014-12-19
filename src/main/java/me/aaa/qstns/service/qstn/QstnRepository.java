package me.aaa.qstns.service.qstn;

import me.aaa.qstns.basis.enums.QstnStatus;
import me.aaa.qstns.domain.Qstn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.util.List;

public interface QstnRepository extends JpaRepository<Qstn, Long> {
    List<Qstn> findByCountryAndStatus(String country, QstnStatus status);

    List<Qstn> findAll();

    List<Qstn> findByStatus(QstnStatus status);

    @Query("select count(q) from Qstn q where q.time >= :from and q.country = :country")
    Integer countByTimerameAndCountry(@Param("from") Time from, @Param("country") String country);
}
