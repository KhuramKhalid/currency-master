package org.cdcaims.repos;

import org.cdcaims.models.StatusMaster;
import org.springframework.data.repository.CrudRepository;

/**
 * @author khuramkhalid
 * @version 02/09/2016
 */
public interface StatusRepository extends CrudRepository<StatusMaster, String> {
}