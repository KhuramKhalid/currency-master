package org.cdcaims.repos;

import org.cdcaims.models.CurrencyMaster;
import org.cdcaims.models.StatusMaster;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author khuramkhalid
 * @version 01/09/2016
 */
public interface CurrencyRepository extends CrudRepository<CurrencyMaster, String> {
    List<CurrencyMaster> findAllByCurrencyCode(String code);
    List<CurrencyMaster> findAllByCurrencyDescription(String code);
    List<CurrencyMaster> findAllByStatus(StatusMaster statusMaster);
}