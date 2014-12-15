package me.aaa.qstns.service.qstn;

import me.aaa.qstns.basis.enums.QstnStatus;
import me.aaa.qstns.domain.Qstn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QstnRepository extends JpaRepository<Qstn, Long> {
    List<Qstn> findByCountry(String country);
    List<Qstn> findAll();
    List<Qstn> findByStatus(QstnStatus status);
}
