package com.hefeng.guli.service.edu.controller.admin;


//import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hefeng.guli.service.edu.entity.Teacher;
import com.hefeng.guli.service.edu.entity.vo.TeacherQueryVo;
import com.hefeng.guli.service.edu.feign.OssFileService;
import com.hefeng.guli.service.edu.service.TeacherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hefeng.guli.common.base.result.R;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/admin/edu/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private OssFileService ossFileService;

    @ApiOperation("所有讲师列表")
    @GetMapping("list")
    public R listAll(){
        //return teacherService.list(null);
        List<Teacher> list = teacherService.list();
        return R.ok().data("items", list).message("获取讲师列表成功");

    }

    @ApiOperation(value = "根据ID删除讲师", notes = "根据ID删除讲师")
    @DeleteMapping("remove/{id}")
    public R removeById(@PathVariable String id){
        boolean result = teacherService.removeById(id);
        if (result){
            return R.ok().message("删除成功");
        } else {
            return R.error().message("数据不存在");
        }
    }

    @ApiOperation("分页讲师列表")
    @GetMapping("list/{page}/{limit}")
    public R listPage(@ApiParam(value = "当前页码" ,required = true) @PathVariable Long page,
                      @ApiParam(value = "每页记录数", required = true) @PathVariable Long limit,
                      @ApiParam("讲师列表查询对象")TeacherQueryVo teacherQueryVo) {
        /*Page<Teacher> pageParam = new Page<>();
        Page<Teacher> pageModel = teacherService.page(pageParam);
        List<Teacher> records = pageModel.getRecords();
        long total = pageModel.getTotal();*/
        IPage<Teacher> pageModel = teacherService.selectPage(page, limit, teacherQueryVo);
        List<Teacher> records = pageModel.getRecords();
        long total = pageModel.getTotal();

        return R.ok().data("total", total).data("rows", records);

    }

    @ApiOperation("新增讲师")
    @PostMapping("save")
    public R save(@ApiParam(value = "讲师对象", required = true) @RequestBody Teacher teacher){
        boolean result = teacherService.save(teacher);
        if(result) {
            return R.ok().message("保存成功");
        } else {
            return R.error().message("保存失败");
        }
    }

    @ApiOperation("更新讲师")
    @PostMapping("update")
    public R updateById(@ApiParam(value = "讲师对象", required = true) @RequestBody Teacher teacher){
        boolean result = teacherService.updateById(teacher);
        if(result) {
            return R.ok().message("修改成功");
        } else {
            return R.error().message("数据不存在");
        }
    }


    @ApiOperation("根据id获取讲师信息")
    @GetMapping("get/{id}")
    public R getById(@ApiParam(value = "讲师ID", required = true) @PathVariable String id){
        Teacher teacher = teacherService.getById(id);
        if(teacher != null){
            return R.ok().data("item", teacher);
        } else {
            return R.error().message("数据不存在");
        }
    }


    @ApiOperation("测试服务调用")
    @GetMapping("test")
    public R test(){
        ossFileService.test();
        return R.ok();
    }

}
