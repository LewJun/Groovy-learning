package org.example.lewjun

/**
 * 雇员信息
 * @author LewJun
 */
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
}