package vsvn.daw.petshop.dao;
import java.util.Calendar;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import vsvn.daw.petshop.models.Scheduling;
public class SchedulingDAO extends DAO<Scheduling> {

	public SchedulingDAO(Class<Scheduling> objectClass) {
		super(objectClass);
		
	}
	
	@Transactional
	public List<Scheduling> getScheduled() {
		try (EntityManager em = super.getEntityManager()){
			
			Query query = em.createQuery("SELECT s FROM Scheduling s LEFT JOIN FETCH s.services WHERE s.state = :state AND s.schedulingDate >= CURRENT_DATE",
					Scheduling.class);
			query.setParameter("state", "Em aguardo");
			
			
			@SuppressWarnings("unchecked")
			List<Scheduling> scheduling= query.getResultList();
			
			return scheduling;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
    }
	
	@Transactional
	public List<Scheduling> getScheduledAdmin(Calendar date) {
		try (EntityManager em = super.getEntityManager()){
			
			Query query = em.createQuery("SELECT s FROM Scheduling s LEFT JOIN FETCH s.services WHERE s.state = :state AND s.schedulingDate >= :cur_date",
					Scheduling.class);
			query.setParameter("state", "Em aguardo");
			query.setParameter("cur_date", date);
			
			@SuppressWarnings("unchecked")
			List<Scheduling> scheduling= query.getResultList();
			
			return scheduling;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Transactional
	public boolean verifyDate(Calendar date) {
		try (EntityManager em = super.getEntityManager()){
			
			Query query = em.createQuery("SELECT s FROM Scheduling s LEFT JOIN FETCH s.services WHERE s.state = :state AND s.schedulingDate = :cur_date",
					Scheduling.class);
			query.setParameter("state", "Em aguardo");
			query.setParameter("cur_date", date);
			
			@SuppressWarnings("unchecked")
			List<Scheduling> scheduling= query.getResultList();
			if(scheduling == null)
				return true;
			return scheduling.size() == 0; 
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Transactional
	public List<Scheduling> getProvidedSchedulingAdminByDateInterval(Calendar inclusiveInitDate, Calendar inclusiveEndDate) {
		try (EntityManager em = super.getEntityManager()){
			
			Query query = em.createQuery("SELECT s FROM Scheduling s LEFT JOIN FETCH s.services WHERE s.state = :state AND s.schedulingDate >= :init_date AND s.schedulingDate <= :end_date",
					Scheduling.class);
			query.setParameter("state", "Realizado");
			query.setParameter("init_date", inclusiveInitDate);
			query.setParameter("end_date", inclusiveEndDate);
			
			@SuppressWarnings("unchecked")
			List<Scheduling> scheduling= query.getResultList();
			
			return scheduling;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Transactional
	public List<Scheduling> getExecutedService() {
		try (EntityManager em = super.getEntityManager()){
			
			Query query = em.createQuery("SELECT s FROM Scheduling s LEFT JOIN FETCH s.services WHERE s.state = :state",
					Scheduling.class);
			query.setParameter("state", "Realizado");
			
			@SuppressWarnings("unchecked")
			List<Scheduling> scheduling= query.getResultList();
			
			return scheduling;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
		
	
	
	
}
