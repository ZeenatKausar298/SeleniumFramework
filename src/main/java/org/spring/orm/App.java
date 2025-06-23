package org.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.spring.orm.dao.CakeDao;
import org.spring.orm.entities.Cake;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println( "Hello World 23jh" );
        System.out.println( "Hello World 27jh" );
        ApplicationContext context = new ClassPathXmlApplicationContext("ormConfig.xml");
        CakeDao cakeDao= context.getBean("cakeDao", CakeDao.class);
        /*Cake cake = new Cake(1, "Death By Chocolate Cake", 500, "Chocolate");
        int r = cakeDao.insert(cake);
        System.out.println("done" +r);*/
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        while(flag) {
        	System.out.println("Enter 1 for inserting data");
        	System.out.println("Enter 2 for getting a single data");
        	System.out.println("Enter 3 for getting all cakes");
        	System.out.println("Enter 4 for updating a cake data");
        	System.out.println("Enter 5 for deleting data");
        	System.out.println("Enter 6 for to exit");
        	
        	try {
        		int input = Integer.parseInt(br.readLine());
            	switch(input) {
            		case 1 : //insert data
            			System.out.println("Enter Cake id:");
            			int cId = Integer.parseInt(br.readLine());
            			System.out.println("Enter the cake name :");
            			String cName = br.readLine();
            			System.out.println("Enter the cake price : ");
            			double cPrice =Double.parseDouble(br.readLine());
            			System.out.println("Enter the cake flavour :");
            			String cFlavour = br.readLine();
            			Cake c = new Cake();
            			c.setId(cId);
            			c.setCakeName(cName);
            			c.setCakePrice(cPrice);
            			c.setCakeFlavour(cFlavour);
            			int r = cakeDao.insert(c);
            			System.out.println(r+"Cake added");
            			break;
            			
            		case 2 : //get a data
            			System.out.println("Enter the id :");
            			int cid = Integer.parseInt(br.readLine());
            			Cake cak = cakeDao.get(cid);
            			System.out.println("Cake id :" +cak.getId());
            			System.out.println("Cake name : " +cak.getCakeName());
            			System.out.println("Cake price :" +cak.getCakePrice());
            			System.out.println("Cake flavour :" +cak.getCakeFlavour());
            			System.out.println("_".repeat(30));
            			break;
            			
            		case 3 : //get all the data;
            			List<Cake> cakes = cakeDao.getAllCakes();
            			for(Cake ca : cakes) {
            				System.out.println("Cake id :" +ca.getId());
                			System.out.println("Cake name : " +ca.getCakeName());
                			System.out.println("Cake price :" +ca.getCakePrice());
                			System.out.println("Cake flavour :" +ca.getCakeFlavour());
                			System.out.println("_".repeat(30));
            			}
            			System.out.println("_".repeat(30));
            			break;
            		case 4: //update data;
            			System.out.println("Enter the id of the cake which you want to update:");
            			int i = Integer.parseInt(br.readLine());
            			System.out.println("Enter the cake name :");
            			String cNamee = br.readLine();
            			System.out.println("Enter the cake price : ");
            			double cPricee =Double.parseDouble(br.readLine());
            			System.out.println("Enter the cake flavour :");
            			String cFlavourr = br.readLine();
            			Cake cake =  new Cake();
            			cake.setId(i);
            			cake.setCakeName(cNamee);
            			cake.setCakePrice(cPricee);
            			cake.setCakeFlavour(cFlavourr);
            			cakeDao.updateCake(cake);
            			System.out.println("Cake details updated");
            			break;
            		case 5 : //delete data
            			System.out.println("Enter the id of cake which you want to delete :");
            			int id = Integer.parseInt(br.readLine());
            			cakeDao.deleteCake(id);
            			System.out.println("Cake deleted.....");
            			break;
            		case 6 : //exit
            			flag = false;
            			break;
            			
            	}
        	} catch(Exception e) {
        		System.out.println("Invalid input, please enter a valid input which makes sense");
        		System.out.println(e.getMessage());
        	}
        	
        }
        System.out.println("Thank You for using my Application \nSee you soon");
    }
}
