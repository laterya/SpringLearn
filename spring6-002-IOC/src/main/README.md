# Spring对IoC的实现
## IoC 控制反转
- 控制反转是为了降低程序耦合度，提高程序扩展力，达到OCP原则，达到DIP原则
- 控制反转，反转的是
  - 将对象的创建权利交出去，交给第三方容器负责
  - 将对象和对象之间关系的维护权交出去，交给第三方容器负责
- 控制反转通过依赖注入DI实现

## 依赖注入
- 依赖注入实现了控制反转的思想
- Spring通过依赖注入的方式来完成Bean管理的
- Bean管理说的是：Bean对象的创建，以及Bean对象中属性的赋值（或者叫做Bean对象之间关系的维护）
- 依赖注入
  - 依赖指的是对象与对象之间的关联关系
  - 注入指的是一种数据传递行为，通过注入行为来让对象和对象之间产生关系
- 依赖注入的常见两种实现方式
  - set注入
  - 构造注入

### set注入
```
<bean id="userDaoBean" class="com.laterya.spring6.dao.UserDao"/>

<bean id="userServiceBean" class="com.laterya.spring6.service.UserService">
    <property name="userDao" ref="userDaoBean"/>
</bean>
```
实现原理：
- 通过property标签获取到属性名：userDao
- 通过属性名推断出set方法名：setUserDao
- 通过反射机制调用setUserDao()方法给属性赋值
- property标签的name是属性名，是setUserDao()方法名演变得到的，规律如下
  - setUsername() 演变为 username
  - setPassword() 演变为 password
  - setUserService() 演变为 userService
- property标签的ref是要注入的bean对象的id。(通过ref属性来完成bean的装配，这是bean最简单的一种装配方式。装配指的是：创建系统组件之间关联的动作)
- set注入的核心实现原理：通过反射机制调用set方法来给属性赋值，让两个对象之间产生关系

### 构造注入
```
    <bean id="userDaoBean" class="com.laterya.spring6.dao.UserDao"/>

    <bean id="userServiceBean" class="com.laterya.spring6.service.UserService">
        <property name="userDao" ref="userDaoBean"/>
    </bean>

    <bean id="orderDaoBean" class="com.laterya.spring6.dao.OrderDao"/>

    <bean id="orderServiceBean" class="com.laterya.spring6.service.OrderService">
        <!--index="0"表示构造方法的第一个参数，将orderDaoBean对象传递给构造方法的第一个参数。-->
        <constructor-arg index="0" ref="orderDaoBean"/>
        <constructor-arg index="1" ref="userDaoBean"/>
    </bean>
```
通过构造方法注入的时候
- 可以通过下标
- 可以通过参数名
- 也可以不指定下标和参数名，可以类型自动推断

## set注入专题
### 注入内部Bean
```
    <bean id="userServiceBean" class="com.powernode.spring6.service.UserService">
        <property name="userDao">
            <bean class="com.powernode.spring6.dao.UserDao"/>
        </property>
    </bean>
```
### 注入简单类型
- 如果把Date当做简单类型的话，日期字符串格式不能随便写。格式必须符合Date的toString()方法格式。显然这就比较鸡肋了。如果我们提供一个这样的日期字符串：2010-10-11，在这里是无法赋值给Date类型的属性的。
- spring6之后，当注入的是URL，那么这个url字符串是会进行有效性检测的。如果是一个存在的url，那就没问题。如果不存在则报错
### 注入数组
- 注入List集合的时候使用list标签，如果List集合中是简单类型使用value标签，反之使用ref标签。
- 注入set集合使用<set>标签，set集合中元素是简单类型的使用value标签，反之使用ref标签
- 注入map集合使用<map>标签 如果key是简单类型，使用 key 属性，反之使用 key-ref 属性如果value是简单类型，使用 value 属性，反之使用 value-ref 属性
- 注入Properties java.util.Properties继承java.util.Hashtable，所以Properties也是一个Map集合 使用<props>标签嵌套<prop>标签完成
- 注入空字符串使用：<value/> 或者 value=""
  注入null使用：<null/> 或者 不为该属性赋值
### 注入的值中含有特殊字符
XML中有5个特殊字符，分别是：<、>、'、"、&
以上5个特殊符号在XML中会被特殊对待，会被当做XML语法的一部分进行解析，如果这些特殊符号直接出现在注入的字符串当中，会报错。
解决方法：
1. 特殊符号使用转义字符代替
2. 将含有特殊符号的字符串放到：<![CDATA[]]> 当中。因为放在CDATA区中的数据不会被XML文件解析器解析
3. 使用CDATA时，不能使用value属性，只能使用value标签