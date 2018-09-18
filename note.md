遇见问题
1.首先第一个是，项目可以启动，但是输入地址的之后，无法跳转。

要注意启动类的位置，启动类默认情况下扫描 本身所在的包和子包。

2.启动不成功，弹出信息说无法加载bean.
    可能出现的原因是，mapper包所在位置不在 启动类所在的包中，也不在子包中。可以通过@mapperSCAN  @componentScan注释限定范围
    
3. Property 'sqlSessionFactory' or 'sqlSessionTemplate' are required 报错出现这个信息
    是因为pom中没有添加  mybatis-spring-boot-starter 依赖
    
    

    