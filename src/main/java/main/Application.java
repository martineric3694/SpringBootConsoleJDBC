package main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import model.Employees;
import util.Connector;

@SpringBootApplication
public class Application implements ApplicationRunner {

	@Autowired
	EmployeeDao empDao;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);	
	}
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception{
		System.out.println("Hello World from Application Runner");
//		empDao.getAll();
		
		List<Employees> result = empDao.getAll();
		
		for(Employees emp:result) {
			System.out.println(emp.getEmployeeId()+"."+emp.getFirstName()+" "+emp.getLastName());
		}
	}
	
	@Bean
	public EmployeeDaoImpl getEmployeeDao() {
		return new EmployeeDaoImpl();
	}
	
	@Bean
	public Connector getConnector() {
		return new Connector();
	}
	
	@Bean
	public Employees getEmployees() {
		return new Employees();
	}

}
