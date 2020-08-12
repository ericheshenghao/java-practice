package com.Spring5核心原理与30个类手写实战.第二章_spring中常用的设计模式.代理模式.应用场景;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
    private Object orderInfo;
    private Long createTime;
    private String id;


    public Object getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(Object orderInfo) {
        this.orderInfo = orderInfo;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}


class OrderDao{
    public int insert(Order order){
        System.out.println("创建成功");
        return 1;
    }
}


interface IOrderService{
    int createOrder(Order order);
}

class  OrderService implements IOrderService{
    private OrderDao orderDao;

    public OrderService() {
        this.orderDao = new OrderDao();
    }

    @Override
    public int createOrder(Order order) {
        return orderDao.insert(order);
    }
}

class DynamicDataSourceEntry{
    // 默认数据源
    private final static String DEFAULT_SOURCE = null;
    private  final  static ThreadLocal<String> local = new ThreadLocal<>();

    private DynamicDataSourceEntry(){}

    // 清空数据源
    public static  void clear(){
        local.remove();
    }

    // 获取当前正在使用的数据源名字
    public static String get(){
        String s = local.get();
        return s;

    }

    // 还原当前切换的数据源
    public static void restore(){
        local.set(DEFAULT_SOURCE);
    }

    // 设置已知的数据源
     public  static  void set(String source){
        local.set(source);
     }

     // 根据年份动态设置数据源
    public static void set(int year){
        local.set("DB_"+year);
    }

}
//创建切换数据源的代理类

class OrderServiceStaticProxy implements  IOrderService {
   private SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

   private IOrderService iOrderService;

    public OrderServiceStaticProxy(IOrderService iOrderService) {
        this.iOrderService = iOrderService;
    }

    @Override
    public int createOrder(Order order) {
        before();
        Long createTime = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(sdf.format(createTime));
        System.out.println("静态代理类自动分配到数据源DB_"+dbRouter);
        DynamicDataSourceEntry.set(dbRouter);
        iOrderService.createOrder(order);
        after();
        return 0;
    }

    private void after() {
        System.out.println("代理前");
    }

    private void before() {
        System.out.println("代理后");
    }
}

class main{
    public static void main(String[] args) {
        try {
            Order order = new Order();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date parse = simpleDateFormat.parse("2017/02/01");
            order.setCreateTime(parse.getTime());

            IOrderService orderServiceStaticProxy = new OrderServiceStaticProxy(new OrderService());
            orderServiceStaticProxy.createOrder(order);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}