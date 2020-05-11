package org.example.lewjun

class GroovyTest extends GroovyTestCase {
    /**
     * 变量
     */
    void testVar() {
        def empno = 7399
        def ename = 'King'
        def job = "Master"
        def mgr = 9999
        def hiredate = new Date()
        def deptno = 10
        def sex = true
        def height = 172.3f
        // 对于浮点型字面量为了精度 Groovy 默认使用的类型为 BigDecimal
        def weight = 62.3

        println mgr.getClass() // class java.lang.Integer
        println height.getClass() // class java.lang.Float
        println empno instanceof Integer // true
        println weight.getClass() // class java.math.BigDecimal

        // 在Groovy中，一切皆对象，包括数字也是
        println 123.floatValue().getClass()

        println 123.plus(2)
    }

    /**
     * Groovy 中==等价于 Java 中的equals方法
     */
    void testEquals() {
        assert 1 == 1
        // Groovy 中==等价于 Java 中的equals方法
        assert "1" == "1"
        assert "1".equals("1")
    }

    /**
     * String的使用
     */
    void testString() {
        def n = 5

        def str1 = "${n * 5}str1$n"
        println str1 // 25str15
        println str1[2..2] // s str1[2]的用法是错误的

        def str2 = '${n * 5}str1$n'
        println str2 // ${n * 5}str1$n

        println str1.getClass() // class org.codehaus.groovy.runtime.GStringImpl
        str1 << "hello world" // 赋值，但是不能改变数据
        println str1 // 25str15

        str1 <<= "Hello World" // 赋值并修改数据
        println str1 // 25str15Hello World
        println str1.getClass() // class java.lang.StringBuilder

        str1[3..3] = 3 // 修改第3..3的元素为3
        println str1[2] // s
        println str1[-2] // l 倒数第2个元素
        println str1 // 25s3r15Hello World
        println str1.size() // 长度
        println str1.contains("3")
        println str1.reverse() // dlroW olleH51r3s52

        def fmtStr = '''《静夜思》"李白" // 格式化字符串，会按照3引号中的内容原样输出
床前明月光，
疑似地上霜。
举头望明月，
低头思故乡。
'''
        println fmtStr
    }
}
