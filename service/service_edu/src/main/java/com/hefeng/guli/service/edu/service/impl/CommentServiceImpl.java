package com.hefeng.guli.service.edu.service.impl;

import com.hefeng.guli.service.edu.entity.Comment;
import com.hefeng.guli.service.edu.mapper.CommentMapper;
import com.hefeng.guli.service.edu.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author Michael
 * @since 2020-10-26
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
