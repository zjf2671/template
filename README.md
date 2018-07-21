# template
	[INFO] pom ................................................ SUCCESS [  0.594 s]
	[INFO] template-admin ..................................... SUCCESS [  3.327 s]
	[INFO] template-common .................................... SUCCESS [  1.449 s]
	[INFO] templateProject .................................... SUCCESS [ 11.501 s]
	[INFO] temppate-app ....................................... SUCCESS [  2.790 s]
	[INFO] template-facade .................................... SUCCESS [  0.417 s]
	[INFO] template-web ....................................... SUCCESS [  0.991 s]

----------
 1. 项目描述
    - 是一套轻量级的权限系统，主要包括用户管理、角色管理、部门管理、菜单管理、定时任务、参数管理、字典管理、文件上传、系统日志、APP模块等功能。其 中，还拥有多数据源、读写分离、数据权限、Redis缓存动态开启与关闭、zk分布式锁、统一异常处理等技术特点。 
 2. 项目特点
     - 采用SpringBoot、dubbo、MyBatis、Shiro框架，开发的一套权限系统，极低门槛，拿来即用，释放双手，让你专注业务开发。设计之初，就非常注重安全性，为企业系统保驾护航，让一切都变得如此简单。
     - 灵活的权限控制，可控制到页面或按钮，满足绝大部分的权限需求
     - 完善的部门管理及数据权限，通过注解实现数据权限的控制
     - 完善的XSS防范及脚本过滤，彻底杜绝XSS攻击
     - 支持MySQL、Oracle、SQL Server、PostgreSQL等主流数据库
 3. 项目介绍
    > 项目一共分为7个模块

    - template-common为公共模块，其他模块以jar包的形式引入进去，主要提供些工具类，防止一个功能重复多次编写代码。
    - template-admin为后台模块，也是系统的核心，用来开发后台管理系统，可以打包成jar，部署到服务器上运行，或者打包成war，放到Tomcat8.5+容器里运行。
    - template-web为面向前端接口模块，restful风格，主要通过引用template-api，然后可以直接调用dubbo服务层接口,也可以通过引入template-facade间接调用dubbo服务接口。
    - template-app为c端接口模块，主要是简化APP开发，如：为微信小程序、IOS、Android提供接口，拥有一套单独的用户体系，template-admin用户表共用，因为template-admin用户表里存放的是企业内部人员账号，具有后台管理员权限，可以登录后台管理系统，而template-app用户表里存放的是我们的真实用户，不具备登录后台管理系统的权限。template-app主要是实现了用户注册、登录、接口权限认证、获取登录用户等功能，为APP接口的安全调用，提供一套优雅的解决方案，从而简化APP接口开发。
    - template-api为服务接口模块，用于dubbo服务实现的api服务接口定义
    - template-facade为集中封装dubbo服务接口供template-app及template-web调用。
    - templateProject为dubbo服务提供实现接口，实现前后端分离。
    - 项目可以根据你的情况进行随机灵活组合，比如，可以template-api、template-web、template-facade、templateProject做为一个架构组合。
 4. 本地部署
    - 环境要求JDK1.8、Tomcat8.5+、MySQL5.5+
    - git clone https://github.com/zjf2671/template.git
    > 【启动template-admin项目】 
    - 执行数据库脚本，如MySQL数据库，则执行 template-admin/db/template-admin.sql 文件，初始化数据
    - 修改application-dev.yml，更改数据库账号和密码
    - 运行com.ddc.template.AdminApplication.java的main方法，则可启动template-admin项目
    - 项目访问路径：http://localhost:8082/template-admin
    - 账号密码：admin/admin
    - Swagger路径：http://localhost:8082/template-admin/swagger/index.html
    - Swagger注解路径：http://localhost:8082/template-admin/swagger-ui.html
    > 【启动templateProject项目】 
    - 执行数据库脚本，如MySQL数据库，则执行 templateProject/db/template.sql 文件，初始化数据
    - 修改application-dev.yml，更改数据库账号和密码
    - 运行com.ddc.template.AdminApplication.java的main方法，则可启动template-admin项目
    - 项目访问路径：http://localhost:8081/template
    - 账号密码：admin/admin
    - Swagger路径：http://localhost:8081/template/swagger/index.html
    - Swagger注解路径：http://localhost:8081/template/swagger-ui.html
 5. 获取帮助
    - https://github.com/zjf2671/template
    - 如需寻求帮助、项目建议、请提issues、我会第一时间进行解答或回复
      如需关注项目最新动态，请Watch、Star项目，同时也是对项目最好的支持