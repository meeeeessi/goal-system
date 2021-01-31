package org.wang.goal.service;

import org.wang.goal.domain.Record;

import java.util.List;

public interface IRecordService {

    void insertRecord(Record record);

    List<Record> selectRecord();

}
