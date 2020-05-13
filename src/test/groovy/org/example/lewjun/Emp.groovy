package org.example.lewjun

import groovy.transform.ToString

/**
 * 雇员信息
 * @author LewJun
 */
@ToString
class Emp {
    int empno
    String ename
    String job
    int mgr
    Date hiredate
    int deptno
    boolean sex
    float height
    float weight

    String display() {
        return "I am $ename, my empno is $empno"
    }

    void fuck() {
        println "fuck"
    }
}