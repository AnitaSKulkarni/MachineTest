package com.niit.employeeinfo.dao.impl;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.employeeinfo.dao.EmployeeDAO;
import com.niit.employeeinfo.model.Employee;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO
{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean addEmployeeInfo(Employee employee) {
		try
		{
			employee.setEmployee_id(employee.getEmployee_id());
			Session session= sessionFactory.getCurrentSession();
			session.save(employee);
			session.flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Employee> getEmployeeInfoByCity(String city) {
		try
		{
			
			Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Employee.class).add(Restrictions.eq("city", city));
			return criteria.list();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateEmployeeInfo(Employee employee) {
		try
		{
			Session session= sessionFactory.getCurrentSession();
			session.update(employee);
			session.flush();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteEmployeeInfo(Employee employee) {
		try
		{
			sessionFactory.getCurrentSession().delete(employee);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public Long getEmployeeCountByDept(String dept) 
	{
		try
		{
			Query q=sessionFactory.getCurrentSession().createQuery("select count(*) from Employee e where e.department=:d");
			q.setParameter("d",dept);
			System.out.println((Long)q.uniqueResult());
			return (Long)q.uniqueResult() ;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return (Long) null;
		}
	}

	@Override
	public Long getEmployeeCountByCity(String city) 
	{
		try
		{
			Query q=sessionFactory.getCurrentSession().createQuery("select count(*) from Employee e where e.city=:c");
			q.setString("c",city);
			System.out.println((Long)q.uniqueResult());
			return (Long)q.uniqueResult() ;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return (Long) null;
		}
	}

}
