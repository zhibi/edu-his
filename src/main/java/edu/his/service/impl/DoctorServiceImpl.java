package edu.his.service.impl;

import edu.his.extra.base.BaseServiceImpl;
import edu.his.mapper.DoctorMapper;
import edu.his.service.DoctorService;
import edu.his.vo.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class DoctorServiceImpl extends BaseServiceImpl<Doctor> implements DoctorService {

    @Autowired
    public DoctorServiceImpl(DoctorMapper mapper) {
        super(mapper);
    }

}
