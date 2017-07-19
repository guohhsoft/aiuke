package aiuke;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import czxy.aiuke.dao.login;
import czxy.aiuke.dao.messageDao;
import czxy.aiuke.dao.pinglundao;
import czxy.aiuke.entity.aiuke;
import czxy.aiuke.entity.pinglun;
import czxy.aiuke.entity.user;



public class test {
	String[] conf={"conf/spring-mybatis.xml","conf/spring-mvc.xml"};
	@Test
	public void denglu(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		login dao =  ac.getBean("login",login.class);
		user us = dao.findByname("张三");
		System.out.println(us);
		}
	@Test
	public void save(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		login dao =  ac.getBean("login",login.class);
		user us = new user();
		us.setId("1212eqw");
		us.setEmail("hah");
		us.setName("李四");
		us.setPassword("123456");
		us.setTelephone("18835573573");
		int count = dao.save(us);
		System.out.println(count);
		}
	@Test
	public void update(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		login dao =  ac.getBean("login",login.class);
		user us = dao.findByname("李四");
		System.out.println(us);
		us.setPassword("adsasdas");
		System.out.println("************************");
		System.out.println(us);
		int count = dao.update(us);
		System.out.println(count);
		}
	@Test
	public void studentsearch(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		messageDao dao =  ac.getBean("messageDao",messageDao.class);
		List<aiuke> list = dao.search("那一段");
		for(aiuke a:list){
			System.out.println(a);
		}
		}
	@Test
	public void studentsave(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		messageDao dao =  ac.getBean("messageDao",messageDao.class);
		aiuke a = new aiuke();
		a.setId("134072100");
		a.setSingname("那一段 日子");
		a.setSinger("光良");
		a.setAddr("dasdasd");
		a.setBeizhu("无");
		int count = dao.save(a);
		System.out.println(count);
		
	}
	@Test
	public void pingluns(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		pinglundao dao = ac.getBean("pinglundao",pinglundao.class);
		List<pinglun> list = dao.search("picture_03.html");
		System.out.println(list.size());
		
	}
	@Test
	public void pinglunsa(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		pinglundao dao = ac.getBean("pinglundao",pinglundao.class);
		pinglun pl = new pinglun();
		pl.setAddr("dasd");
		pl.setId("dasdasd");
		pl.setUsername("haha ");
		pl.setTime("dasdasdas");
		pl.setMessage("哈哈啊");
		int count =dao.save(pl);
		System.out.println(pl);
		
	}
	
}
