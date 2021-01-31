package org.wang.goal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wang.goal.domain.Record;
import org.wang.goal.mapper.RecordMapper;
import org.wang.goal.service.IRecordService;

import java.util.List;

@Service
public class RecordServiceImpl implements IRecordService {

    @Autowired
    private RecordMapper recordMapper;

    @Override
    public void insertRecord(Record record) {
        recordMapper.insertRecord(record);
    }

    @Override
    public List<Record> selectRecord() {
        return recordMapper.selectRecord();
    }
}
