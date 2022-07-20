package com.ibrahim.test.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Student {

    Integer studentId;
    Integer totalClasses;
    PersonalInfo personalInfo;
}
