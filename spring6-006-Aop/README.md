- 切点表达式用来定义通知（Advice）往哪些方法上切入
`execution([访问控制权限修饰符] 返回值类型 [全限定类名]方法名(形式参数列表) [异常])`
  - 访问控制权限修饰符：
    - 可选项
    - 没写，就是4个权限都包括
    - 写public就表示值包括公开的方法
  - 返回值类型
    - 必填项
    - *表示返回值类型任意
  - 全限定类名
    - 可选项
    - 两个点“..”代表当前包以及子包下的所有类
    - 省略时表示所有的类
  - 方法名
    - 必填项
    - *表示所有方法
    - set*表示所有的set方法
  - 形式参数列表
    - 必填项
    - () 表示没有参数的方法
    - (..) 参数类型和个数随意的方法
    - (*) 只有一个参数的方法
    - (*, String) 第一个参数类型随意，第二个参数是String的
  - 异常
    - 可选项
    - 省略时表示任意异常类型

通知类型
- 前置通知：@Before 目标方法执行之前的通知
- 后置通知：@AfterReturning 目标方法执行之后的通知
- 环绕通知：@Around 目标方法之前添加通知，同时目标方法执行之后添加通知
- 异常通知：@AfterThrowing 发生异常之后执行的通知
- 最终通知：@After 放在finally语句块中的通知
- 出现异常之后，后置通知和环绕通知的结束部分不会执行

切面的先后顺序
如果多个切面的话，顺序如何控制：可以使用@Order注解来标识切面类，为@Order注解的value指定一个整数型的数字，数字越小，优先级越高

优化使用切点表达式
```
@Pointcut("execution(* service.OrderService.*(..))")
public void pointcut(){}

    @Around("pointcut()")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知开始");
        // 执行目标方法。
        proceedingJoinPoint.proceed();
        System.out.println("环绕通知结束");
    }

    @Before("pointcut()")
    public void beforeAdvice(){
        System.out.println("前置通知");
    }

    @AfterReturning("pointcut()")
    public void afterReturningAdvice(){
        System.out.println("后置通知");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowingAdvice(){
        System.out.println("异常通知");
    }

    @After("pointcut()")
    public void afterAdvice(){
        System.out.println("最终通知");
    }
```
- 使用@Pointcut注解来定义独立的切点表达式
- 注意这个@Pointcut注解标注的方法随意，只是起到一个能够让@Pointcut注解编写的位置