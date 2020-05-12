package org.example.lewjun

class AppGroovyTest extends GroovyTestCase {
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

    /**
     * 操作符的使用
     */
    void testOpr() {
        // + - * / % ** > < == *. n++ ++n as
        def x = 3
        def y = 4
        def z = 5
        println(x + y)
        println(x - y)
        println(x * y)
        println(x / y)
        println(x % y)
        println(x**y)
        println(x > y)
        println(x >= y)
        println(x < y)
        println(x <= y)
        println(x <=> y) // x.compareTo(b)
        println(x * x + y * y == z * z)

        println(x++) // 3 后++ 数字在前，操作符在后，先赋值，再操作，所以此行 x还是 3
        println(x) // 4
        println(++y) // 5 前++ 数字在后，操作符在前，先操作，再赋值，所以此行 y是5
        println(y) // 5

        // *.
        String[] words = ["hello", "world"]
        println words*.toUpperCase()

        println "triple" * 3 // tripletripletriple

        // “==”操作符表示两个数的值等价（“==”号调用了对象的 equals 进行比较），而不是判断引用是否相等
        println("abc" == "abc") // true
        println("111" == 111) // false

        // as
        println((x as String).class)
        println((x.asType(String).class))
    }

    /**
     * ranges的使用
     */
    void testRanges() {
        def nums = 5..20 //new IntRange(5, 20)
        println(nums.from)
        println(nums.to)
        println(nums instanceof Range<Integer>)

        5..20.each {
            print "$it "
        }

        println("---------")

        ('a'..'z').reverseEach { print "$it " }

        // 'Z'..<'A' 不包含A
        'z'..<'a'.eachWithIndex { entry, index ->
            println("$index -> $entry")
        }

        println("-------------")
        println((5..20).contains(10))

        def age = 18
        switch (age) {
            case 1..17:
                println("1..17")
                break
            case 18..100:
                println("18..100")
                break
            default:
                break
        }

        def ages = [20, 36, 42, 56, 72]
        println(ages.grep(21..50)) // [36, 42]
    }

    /**
     * lists的使用
     */
    void testLists() {
        def emptyList = []
        def nums = [1, 2, 3, 4, 5, 6]
        println(nums.class) // 声明的list默认是ArrayList
        def nums2 = nums as LinkedList // 可以使用as转为LinkedList
        println(nums2.class)

        // 将range转换为list
        assert (5..20).toList()

        // 获取大小
        println nums2.size()

        // 修改值
        nums2[2] = 22

        println(nums2)
        println nums2.grep(2..4) // 注意grep检索内容为2，3，4的数值
        println nums2[2, 3] // 检索下标为2和3的数值
        println nums2[1..-2] // 检索下标1到倒数第2个数值
        println nums2.contains(22)

        // 向list添加数据
        nums2 << 100 << 101 << 102
        nums2.add(200)
        nums2.addAll([300, 400])
        // 使用这种方式添加两个元素
        nums2 += [500, 600]
        // remove元素
        nums2 -= [300, 900]
        nums2.removeElement(400)
        println nums2.class
        // 会报下标越界的异常 400被当成了下标，而不是被当作元素
//        nums2.remove(400)

        println(nums2)

        println(nums2[0])
        println(nums2.first)
        println(nums2.last)
        println(nums2[-1])

        println(nums2.sum())

        def nums3 = nums2 as Integer[]
        println(nums3)
        println(nums3.class)

//        nums3 << 500 // error 数组的长度是定了的，不能改变

        println(nums3)

        println([1, 2, [3, 4, 5], 6, [7, 8]].flatten())// 将list展开[1,2,3,4,5,6,7,8]

        // 移除并返回第1个元素
        println nums2.pop()
        println nums2
        println nums2.sort()

        println([1, 2, 3].collect { it * 2 })

        def odd = [1, 2, 3].findAll { item ->
            item % 2 == 1
        }

        assert odd == [1, 3]

        println([1, 2, 3].disjoint([2, 5, 8]))

        println nums2.join('-')

        println(nums2.every { it > 20 }) // 所有
        println(nums2.any { it > 20 })// 任意一个

        // inject方法来自Smalltalk，这个方法使用闭包注入一个新的函数，这个函数用来对一个中间结果和遍历的当前元素进行操作，inject方
        //法的第一个参数是中间结果的初始值
        println([4, 2, 3].inject { acc, val -> acc * val }) // 4 * 2 * 3
        println([4, 2, 3].inject { acc, val -> acc + val }) // 4 + 2 + 3

        // fruits 将被不允许修改里面的元素
        def fruits = ["apple", "orange"].asImmutable()
//        fruits.add("banana") // error UnsupportedOperationException
        println fruits
        // countries 可以用于并发访问
        def countries = ['China', 'Japan', "India"].asSynchronized()
    }

    void testMaps() {
        def emptyMap = [:]
        println emptyMap.getClass() // LinkedHashMap

        def map1 = [
                a: 1,
                b: 2
        ]

        println map1
        println map1['a'] // 推荐写法
        println map1.a
        println map1.keySet()
        println map1.values()

        // 修改或添加元素
        map1['c'] = 3 // 推荐写法
        map1.d = 4
//        遍历
        map1.each {
            println "${it.key}, ${it.value}"
        }
        map1.each { key, value ->
            println "$key -- $value"
        }


        def oddMap = map1.findAll { key, value ->
            value % 2 == 0
        }

        println oddMap

        // 根据key来得到子map
        def acMap = map1.subMap(['a', 'c'])
        println acMap

        def doubledList = map1.collect {
            it.value * 2
        }

        println doubledList

        oddMap.clear()


        def textCorpus = """a b c d e a e f c d b a c
"""
        def words = textCorpus.tokenize()
        println words
        def wordFrequency = [:]
        words.each {
            wordFrequency[it] = (wordFrequency[it] ?: 0) + 1
        }

        // 对value进行排序
        wordFrequency = wordFrequency.sort { a, b -> b.value <=> a.value }
        println wordFrequency
    }
}
