package com.his.service.impl;

import com.his.extra.base.BaseServiceImpl;
import com.his.mapper.MessageMapper;
import com.his.service.MessageService;
import com.his.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class MessageServiceImpl extends BaseServiceImpl<Message> implements MessageService {

    @Autowired
    public MessageServiceImpl(MessageMapper mapper) {
        super(mapper);
    }



}
