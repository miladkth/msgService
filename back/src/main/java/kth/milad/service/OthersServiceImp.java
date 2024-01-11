package kth.milad.service;

import kth.milad.entity.Others;
import kth.milad.entity.Patient;
import kth.milad.repository.OthersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OthersServiceImp implements IService<Others>{

    @Autowired
    private OthersRepository othersRepository;

    @Override
    public List<Others> getAll() {
        List<Others> list =  othersRepository.findAll();
        System.out.println("othersList = in service imp " + list);
        return list;
    }

    @Override
    public Others getById(int entity) {
        return othersRepository.findById(entity).get();
    }

    @Override
    public Others create(Others entity) {
        System.out.println("In others Service ");
         return othersRepository.save(entity);
    }

    public Others getByEmail(String email) {
        return othersRepository.findByEmail(email);
    }

}
