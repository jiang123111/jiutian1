package com.jiutian.jiutian.mapper;

import com.jiutian.jiutian.entity.Video;
import org.apache.ibatis.annotations.Select;

public interface CourseMapper {
    @Select("select c.title,c.play_number,c.detail,c.creat_data,g.grade_name,p.project_name from course c,grade g,project p where c.grade_id = g.id and c.project_id = p.id and c.id =#{id}")
    Video selectCourseById(int id);
}
