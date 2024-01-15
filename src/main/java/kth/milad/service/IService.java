package kth.milad.service;


import java.util.List;

public interface IService <E> {
    List<E> getAll();
    E getById(int entity);
    E create(E entity);

}
