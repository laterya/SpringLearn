# Bean的生命周期
1. 实例化Bean
2. Bean属性赋值
3. 初始化Bean
4. 使用Bean
5. 销毁Bean

注意的点：
1. 只有正常关闭spring容器，bean的销毁方法才会被调用
2. ClassPathXmlApplicationContext类才有close()方法
3. 配置文件中的init-method指定初始化方法。destroy-method指定销毁方法

在以上的5步中，第3步是初始化Bean，可以在初始化前和初始化后添加代码，可以加入“Bean后处理器”

# new的对象交给Spring管理
