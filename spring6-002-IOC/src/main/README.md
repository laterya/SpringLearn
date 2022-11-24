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
