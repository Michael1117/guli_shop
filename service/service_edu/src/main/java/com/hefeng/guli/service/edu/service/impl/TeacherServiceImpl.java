package com.hefeng.guli.service.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hefeng.guli.service.edu.entity.Teacher;
import com.hefeng.guli.service.edu.entity.vo.TeacherQueryVo;
import com.hefeng.guli.service.edu.mapper.TeacherMapper;
import com.hefeng.guli.service.edu.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author Michael
 * @since 2020-10-26
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Override
    public IPage<Teacher> selectPage(Long page, Long limit, TeacherQueryVo teacherQueryVo) {
        Page<Teacher> pageParam = new Page<>(page, limit);

        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");

        if(teacherQueryVo == null){
            return baseMapper.selectPage(pageParam, queryWrapper);
        }

        String name = teacherQueryVo.getName();
        Integer level = teacherQueryVo.getLevel();
        String begin = teacherQueryVo.getJoinDateBegin();
        String end = teacherQueryVo.getJoinDateEnd();

        if(!StringUtils.isEmpty(name)){
            queryWrapper.likeRight("name", name);
        }

        if(level != null){
            queryWrapper.eq("level", level);
        }

        if(!StringUtils.isEmpty(begin)){
            queryWrapper.ge("join_date", begin);
        }

        if(!StringUtils.isEmpty(end)){
            queryWrapper.le("join_date", end);
        }

        return baseMapper.selectPage(pageParam, queryWrapper);
    }
}
