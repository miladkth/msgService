package kth.milad.service;

import kth.milad.entity.Doctor;
import kth.milad.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DoctorServiceImp implements IService<Doctor>{

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> getAll() {
        List<Doctor> list = doctorRepository.findAll();
        System.out.println("doctorList = in service imp " + list);
        return list;
    }

    @Override
    public Doctor getById(int entity) {
        return doctorRepository.findById(entity).get();
    }

    public Doctor getByEmail(String email) { return doctorRepository.findByEmail(email);}

    @Override
    public Doctor create(Doctor entity) {
        return doctorRepository.save(entity);
    }
}
