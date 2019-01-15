package id.web.kulgram.biodata.dao;

import id.web.kulgram.biodata.model.Biodata;
import org.springframework.data.repository.CrudRepository;

public interface BiodataDAO extends CrudRepository<Biodata, Long> {
}
