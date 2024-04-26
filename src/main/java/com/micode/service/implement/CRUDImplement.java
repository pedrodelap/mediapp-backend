package com.micode.service.implement;

import com.micode.exception.ModelNotFoundException;
import com.micode.repository.IGenericRepository;
import com.micode.service.ICRUD;

import java.util.List;

public abstract class CRUDImplement<T, ID> implements ICRUD<T, ID> {

    protected abstract IGenericRepository<T, ID> getRepo();

    @Override
    public T save(T t) {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND " + id));
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) {
        return getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND " + id));
    }

    @Override
    public void delete(ID id) {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND " + id));
        getRepo().deleteById(id);
    }
}
