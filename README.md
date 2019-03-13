# springbucks
springboot实战:线上咖啡馆

## 项目流程图

![Alt text](https://github.com/hanzhonghua/springbucks/blob/master/src/main/resources/static/image/WechatIMG2.png)
1.用户询问服务员菜单信息，然后点菜下单，支付
2.服务员拿到用户订单通知做咖啡，厨房做好通知服务员，服务员通知客服取咖啡
3.流程完毕

## 实体
![Alt text](https://github.com/hanzhonghua/springbucks/blob/master/src/main/resources/static/image/WechatIMG3.png)

1.菜单属于定制好不再轻易改变的，存储缓存
2.客户同步告知服务员要什么类型的咖啡，服务员和制作师傅MQ通信，然后服务员通知客服取咖啡

## 订单状态流转
![Alt text](https://github.com/hanzhonghua/springbucks/blob/master/src/main/resources/static/image/WechatIMG4.png)
