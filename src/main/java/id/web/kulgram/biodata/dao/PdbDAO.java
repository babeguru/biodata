package id.web.kulgram.biodata.dao;

import id.web.kulgram.biodata.model.Pdb;
import org.springframework.data.repository.CrudRepository;

public interface PdbDAO extends CrudRepository<Pdb, Long> {
}
