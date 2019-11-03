package com.jiutian.jiutian.controller;

import com.jiutian.jiutian.resultVo.ResultVo;
import com.jiutian.jiutian.service.AfterCourse1Service;

import com.jiutian.jiutian.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "课程管理",tags = "课程管理")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("/api/select/courseById")
    @ApiOperation(value = "通过id删除课程", notes = "通过id删除课程")
    public ResultVo selectCourseById(int id){

        return courseService.selectCourseById(id) ;
    }
}
