package com.fantasist.wfm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.fantasist.wfm.entity.EmployeeEntity;
 
 
@Repository
public class EmployeeDaoImpl implements EmployeeDAO
{
	@PersistenceContext
	private EntityManager entityManager;
	
//    @Autowired
//    private SessionFactory sessionFactory;
	
    @Override
    public void addEmployee(EmployeeEntity employee) {
    	this.entityManager.persist(employee);
        //this.sessionFactory.getCurrentSession().save(employee);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<EmployeeEntity> getAllEmployees() {
    	return this.entityManager.createQuery("from EmployeeEntity").getResultList();
        //return this.sessionFactory.getCurrentSession().createQuery("from EmployeeEntity").list();
    }
    
    @Override
    public void deleteEmployee(Integer employeeId) {
    	EmployeeEntity employee = (EmployeeEntity) entityManager.find(EmployeeEntity.class, employeeId);
        if (null != employee) {
            this.entityManager.remove(employee);
        }

/*        EmployeeEntity employee = (EmployeeEntity) sessionFactory.getCurrentSession().load(
                EmployeeEntity.class, employeeId);
        if (null != employee) {
            this.sessionFactory.getCurrentSession().delete(employee);
        }
*/
    }
    
	public EntityManager getEntityManager() {
		return entityManager;
	}
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
