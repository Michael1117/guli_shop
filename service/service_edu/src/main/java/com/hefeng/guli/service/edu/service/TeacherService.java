package com.hefeng.guli.service.edu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hefeng.guli.service.edu.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hefeng.guli.service.edu.entity.vo.TeacherQueryVo;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author Michael
 * @since 2020-10-26
 */
public interface TeacherService extends IService<Teacher> {


    IPage<Teacher> selectPage(Long page, Long limit, TeacherQueryVo teacherQueryVo);
}
