package edu.his.service.impl;

import edu.his.extra.base.BaseServiceImpl;
import edu.his.mapper.MessageMapper;
import edu.his.service.MessageService;
import edu.his.vo.Message;
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
