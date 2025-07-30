package com.xworkz.collegeevent.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "college_info")
public class CollegeEventEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name="college_Id")
    private  int college_Id;

    @Column(name="collegeName")
    private  String collegeName;

    @Column(name="principal")
    private  String principal;

    @Column(name="studentName")
    private  String studentName;

    @Column(name="course")
    private  String course;




}


