package ir.maktabsharif.loginandregister.repository;


import ir.maktabsharif.loginandregister.model.BaseModel;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseRepository<T extends BaseModel<ID>, ID extends Serializable> {
    void saveOrUpdate(T obj) ;
    void delete(ID id) ;
    Optional<T> findById(ID id) ;
    List<T> findAll() ;
}
