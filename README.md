**一.代码说明**

1.Controller：根据name返回喜爱程度的字符串

2.ContextHandlerService：装配name - handler的映射关系

3.AbstractHandler：抽象详细的策略方法及所对应的name集合



**二.执行效果**

1.http://localhost:8080/emo?name=榴莲

返回： hate...

2.http://localhost:8080/emo?name=回锅肉

返回：like...

3.http://localhost:8080/emo?name=螺蛳粉

返回：em...

4.http://localhost:8080/emo?name=茄子

返回：i do not know~

