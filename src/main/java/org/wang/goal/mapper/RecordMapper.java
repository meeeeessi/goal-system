package org.wang.goal.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.wang.goal.domain.Record;

import java.util.List;

@Mapper
public interface RecordMapper {

    void insertRecord(Record record);

    List<Record> selectRecord();

}
