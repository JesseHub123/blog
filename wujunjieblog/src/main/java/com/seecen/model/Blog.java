package com.seecen.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;
@Data
public class Blog {
    private Integer blogId;

    private Integer blogTypeId;

    private String blogSign;

    private String blogTitle;

    private String blogContent;

    private String blogImage;

    private String blogAuthor;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp blogCreatetime;

    private Integer blogView;
    private Type type;
    private Integer count;
    private Integer blogComments;


}