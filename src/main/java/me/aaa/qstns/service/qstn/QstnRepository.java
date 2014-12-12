package me.aaa.qstns.service.qstn;

import me.aaa.qstns.domain.Qstn;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by aaa on 12/12/14.
 */
public interface QstnRepository extends CrudRepository<Qstn, Long> {
    List<Qstn> findByCountry(String country);
    List<Qstn> findAll();
}
