package com.his.service.impl;

import com.his.extra.base.BaseServiceImpl;
import com.his.mapper.DoctorMapper;
import com.his.service.DoctorService;
import com.his.vo.Doctor;
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
