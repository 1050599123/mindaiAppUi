#mindaiappui
<h1>简介</h1>
这是一个AppUi自动化测试框架该APP自动化测试框架是用java语言编写的，基于selenium webdriver Appium的开源自动化测试框架，该框架结合了testng,selenium,webdriver，Appium,jxl，jodd-http 等工具。该框架基于页面对象模型（POM）架构，实现了关键字驱动技术，数据驱动,无需掌握多少编程知识即可编写脚本，同时实现了数据与代码分离的功能：1、元素定位信息保存在对象库文件中 2、测试用例数据可以存储在excel中。从而实现，页面元素位置变化，无需改动脚本，只需修改对应的元素定位信息即可。
该框架实现了检查点及用例失败自动截图功能，自动生成html测试报告及自动发送html邮件测试报告功能。
目前框架还不是特别完善，还需要写一些脚本实现自动化；学习该框架需要熟悉一定的安卓APP 和java基础，后续可以考虑自动编码的实现
<h1>主要功能</h1>
1、实现关键字驱动技术，编写用例简单
2、实现数据驱动技术，减少用例代码
3、支持元素对象库管理，页面元素信息与代码分离,支持XML,YAML管理对象库
3、支持检查点、用例断言设置
4、检查点失败截图，一个检查点失败不影响用例后续执行
5、用例失败自动截图
6、用例之间依赖少，可以自由组合测试用例执行
7、支持安卓系统常用触摸操作
8、支持APP控件常用操作
9、用例集执行完毕自动生成简介美观的html报告
10、用例执行完毕自动发送详实的html邮件报告，可拓展为有失败用例才发送。
<h1>环境配置</h1>
1、JDK1.8
2、IDEA\Eclipse
3、Android SDK 
4、Maven
5、一台安卓手机或者安卓模拟器
6、Appium Server端
<h1>注意事项</h1>
工程项目编码需要设置成UTF-8否则会出现中文乱码情况

