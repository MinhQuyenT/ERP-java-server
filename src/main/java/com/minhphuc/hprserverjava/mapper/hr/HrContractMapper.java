package com.minhphuc.hprserverjava.mapper.hr;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.minhphuc.hprserverjava.domain.hr.HrContract;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Automatically generate code by Minh Phúc
 *
 * @author Minh Phúc
 * @date Thu Sep 07 08:15:23 GMT+07:00 2023
 */
@Repository
public interface HrContractMapper extends BaseMapper<HrContract> {

    @Select("SELECT \n" +
            "a.per_code,\n" +
            "a.per_name_vi,\n" +
            "a.per_name_ja,\n" +
            "a.per_name_en,\n" +
            "a.birthday,\n" +
            "a.position_fk,\n" +
            "b.*,\n" +
            "c.type_name_vi,\n" +
            "c.type_name_en,\n" +
            "c.type_name_ja,\n" +
            "c.remake,\n" +
            "c.num_month,\n" +
            "c.part_time\n" +
            "FROM hr_contract b\n" +
            "LEFT JOIN hr_person a ON b.per_fk = a.per_id\n" +
            "LEFT JOIN hr_contract_type c ON c.con_type_id = a.contract_fk")
    List<HrContract> viewBackup();

}