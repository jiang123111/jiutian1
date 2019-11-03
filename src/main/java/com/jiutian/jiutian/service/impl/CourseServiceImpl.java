package com.jiutian.jiutian.service.impl;

import com.jiutian.jiutian.entity.Video;
import com.jiutian.jiutian.mapper.CourseMapper;
import com.jiutian.jiutian.resultVo.ResultVo;
import com.jiutian.jiutian.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;
    @Override
    public ResultVo selectCourseById(int id) {
        Video video = courseMapper.selectCourseById(id);
        return ResultVo.setOk(video);
    }
}
