package com.infinite.studentdetails;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
@ManagedBean(name="StudentBio")
public class StudentDAO{
	SessionFactory sFactory;

		public String generateStudentId(){
			sFactory = SessionHelper.getConnection();
			Session session = sFactory.openSession();
			Criteria cr = session.createCriteria(Student.class);
			List<Student> StudentList = cr.list();
			if(StudentList.size()==0){
				return "S001";
			}
			int id = Integer.parseInt(StudentList.get(StudentList.size()-1).getsId().substring(1));
			String hid = String.format("S%03d", ++id);
			return hid;
		}
		//Add StudentDetails
		
		public String addstudent(Student StudentDetails) {	
			sFactory = SessionHelper.getConnection();
			Session session = sFactory.openSession();
			String StudentId=generateStudentId();
			Transaction t = session.beginTransaction();
			StudentDetails.setsId(StudentId);	
			session.save(StudentDetails);
			t.commit();
			return "ShowStudent.xhtml?faces-redirect=true";
			
			
		}
		
		
		//show StudentDetails
		
		
		
		public List<Student> ShowStudentDetails() {
			sFactory = SessionHelper.getConnection();
			Session session = sFactory.openSession();
			Criteria cr = session.createCriteria(Student.class);
	        List<Student> StudentList = cr.list();
	        
//	        Collections.sort(StudentList, new Comparator<Student>(){
//		    	public int compare(Student a1, Student a2){
//		    		return a1.getFirstName().compareTo(a2.getFirstName());
//		    	}
//		    });
			return StudentList;
		}

		
		
//		public List<Student> sortBybranchDescending() {
//			sFactory = SessionHelper.getConnection();
//			Session session = sFactory.openSession();
//			Criteria cr = session.createCriteria(Student.class);
//			cr.addOrder(Order.desc("branch"));
//			List<Student> studentList = cr.list();
//			return studentList; 
//			
//		}
//		public List<Student> sortByAgeDescending() {
//	        sFactory = SessionHelper.getConnection();
//	        Session session = sFactory.openSession();
//	        Criteria cr = session.createCriteria(Student.class);
//	        cr.addOrder(Order.desc("age"));
//	        List<Student> studentList = cr.list(); 
//	        return studentList;
//	    }
//
//	    public List<Student> sortByAgeAscending() {
//	        sFactory = SessionHelper.getConnection();
//	        Session session = sFactory.openSession();
//	        Criteria cr = session.createCriteria(Student.class);
//	        cr.addOrder(Order.asc("age"));
//	        List<Student> studentList = cr.list(); 
//	        return studentList;
//	    }
//
//	    public List<Student> sortByFirstNameDescending() {
//	        sFactory = SessionHelper.getConnection();
//	        Session session = sFactory.openSession();
//	        Criteria cr = session.createCriteria(Student.class);
//	        cr.addOrder(Order.desc("firstName"));
//	        List<Student> studentList = cr.list(); 
//	        return studentList;
//	    }
//
//	    public List<Student> sortByFirstNameAscending() {
//	        sFactory = SessionHelper.getConnection();
//	        Session session = sFactory.openSession();
//	        Criteria cr = session.createCriteria(Student.class);
//	        cr.addOrder(Order.asc("firstName"));
//	        List<Student> studentList = cr.list(); 
//	        return studentList;
//	    }
////
//	    public List<Student> sortByLastNameDescending() {
//	        sFactory = SessionHelper.getConnection();
//	        Session session = sFactory.openSession();
//	        Criteria cr = session.createCriteria(Student.class);
//	        cr.addOrder(Order.desc("lastName"));
//	        List<Student> studentList = cr.list(); 
//	        return studentList;
//	    }
//
//	    public List<Student> sortByLastNameAscending() {
//	        sFactory = SessionHelper.getConnection();
//	        Session session = sFactory.openSession();
//	        Criteria cr = session.createCriteria(Student.class);
//	        cr.addOrder(Order.asc("lastName"));
//	        List<Student> studentList =cr.list(); 
//	        return studentList;
////	     
//	
	  //  }
		    
//		    Collections.sort(StudentList, new Comparator<Student>(){
//		    	public int compare(Student a1, Student a2){
//		    		return a1.getFirstName().compareTo(a2.getFirstName());
//		    	}
//		    });
//		    
//		  
//		    Collections.sort(StudentList, new Comparator<Student>(){
//		    	public int compare(Student a1, Student a2){
//		    		return a1.getLastName().compareTo(a2.getLastName());
//		    	}
//		    });
//		    
//		    Collections.sort(StudentList, new Comparator<Student>(){
//		    	public int compare(Student a1, Student a2){
//		    		return a2.getLastName().compareTo(a1.getLastName());
//		    	}
//		    });
//		    Collections.sort(StudentList, new Comparator<Student>(){
//		    	public int compare(Student a1, Student a2){
//		    		return a1.getBranch().compareTo(a2.getBranch());
//		    	}
//		    });
//		    
//		    Collections.sort(StudentList, new Comparator<Student>(){
//		    	public int compare(Student a1, Student a2){
//		    		return a2.getBranch().compareTo(a1.getBranch());
//		    	}
//		    });
//		    Collections.sort(StudentList, new Comparator<Student>(){
//		    	public int compare(Student a1, Student a2){
//		    		return a1.getYearOfJoin()-(a2.getYearOfJoin());
//		    	}
//		    });
//		    
//	       
//
//
//		}
		public List<Student> showStudentDetailsByFirstNameAsc() {
		    sFactory = SessionHelper.getConnection();
		    Session session = sFactory.openSession();
		    Criteria cr = session.createCriteria(Student.class);
		    List<Student> studentList = cr.list();
		    System.out.println("before sort");
		    System.out.println(studentList);
		    Collections.sort(studentList, new Comparator<Student>(){
		    	public int compare(Student a1, Student a2){
		    		return a1.getFirstName().compareTo(a2.getFirstName());
		    		
		    	}
		    	
		    });
		    System.out.println("after sort");
		    System.out.println(studentList);
		    return studentList;
		}
		public List<Student> showStudentDetailsByFirstNameDsc() {
		    sFactory = SessionHelper.getConnection();
		    Session session = sFactory.openSession();
		    Criteria cr = session.createCriteria(Student.class);
		    List<Student> studentList = cr.list();
		    Collections.sort(studentList, new Comparator<Student>(){
		        public int compare(Student a1, Student a2){
		            return a2.getFirstName().compareTo(a1.getFirstName());
		        }
		    });
		    return studentList;
		}
//
//		public List<Student> ShowStudentDetailsByLastName() {
//		    sFactory = SessionHelper.getConnection();
//		    Session session = sFactory.openSession();
//		    Criteria cr = session.createCriteria(Student.class);
//		    List<Student> studentList = cr.list();
//		    Collections.sort(studentList, new Comparator<Student>(){
//		        public int compare(Student a1, Student a2){
//		            return a1.getLastName().compareTo(a2.getLastName());
//		        }
//		    });
//		    return studentList;
//		}
//
//		public List<Student> ShowStudentDetailsByLastNameDesc() {
//		    sFactory = SessionHelper.getConnection();
//		    Session session = sFactory.openSession();
//		    Criteria cr = session.createCriteria(Student.class);
//		    List<Student> studentList = cr.list();
//		    Collections.sort(studentList, new Comparator<Student>(){
//		        public int compare(Student a1, Student a2){
//		            return a2.getLastName().compareTo(a1.getLastName());
//		        }
//		    });
//		    return studentList;
//		}
//
//		public List<Student> ShowStudentDetailsByBranch() {
//		    sFactory = SessionHelper.getConnection();
//		    Session session = sFactory.openSession();
//		    Criteria cr = session.createCriteria(Student.class);
//		    List<Student> studentList = cr.list();
//		    Collections.sort(studentList, new Comparator<Student>(){
//		        public int compare(Student a1, Student a2){
//		            return a1.getBranch().compareTo(a2.getBranch());
//		        }
//		    });
//		    return studentList;
//		}
//
//		public List<Student> ShowStudentDetailsByBranchDesc() {
//		    sFactory = SessionHelper.getConnection();
//		    Session session = sFactory.openSession();
//		    Criteria cr = session.createCriteria(Student.class);
//		    List<Student> studentList = cr.list();
//		    Collections.sort(studentList, new Comparator<Student>(){
//		        public int compare(Student a1, Student a2){
//		            return a2.getBranch().compareTo(a1.getBranch());
//		        }
//		    });
//		    return studentList;
//		}
//
//		public List<Student> ShowStudentDetailsByYearOfJoin() {
//		    sFactory = SessionHelper.getConnection();
//		    Session session = sFactory.openSession();
//		    Criteria cr = session.createCriteria(Student.class);
//		    List<Student> studentList = cr.list();
//		    Collections.sort(studentList, new Comparator<Student>(){
//		        public int compare(Student a1, Student a2){
//		            return Integer.compare(a1.getYearOfJoin(), a2.getYearOfJoin());
//		        }
//		    });
//		    return studentList;
//		}
//
//		
//
//
}

	
		

		
		

		



