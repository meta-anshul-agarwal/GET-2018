package com.metacube.employee;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * This class provides the web services for the various operations
 * @author Anshul Agarwal
 */
@Path("/employee")
public class Employees {
	
	//static array to store all the employees
	static JSONArray listOfEmployees = new JSONArray();
	@SuppressWarnings("unchecked")
	
	@POST
	@Path("addEmployee")
	@Produces(MediaType.TEXT_PLAIN)
	/**
	 * method to add employee in the list
	 * @param name - name of employee
	 * @param id - id of employee
	 */
	public void addEmployee(@QueryParam("name") String name,@QueryParam("id") String id) {
	
		//creating new json object to store details
		JSONObject employeeDetails = new JSONObject();
		//adding name to employeeDetails
        employeeDetails.put("Name", name);
        //adding id to employeeDetails
        employeeDetails.put("id", id);
        //creating new json object
        JSONObject employeeObject = new JSONObject();
        //adding new attribute to employeeObject to store all details of an employee
        employeeObject.put("employee", employeeDetails);
        //adding employeeObject to the array of employees
        listOfEmployees.add(employeeObject);
        //creating object of File 
        File f = new File("employees.json");
        //for writing objects into file
        try (FileWriter file = new FileWriter(f)) {
        	System.out.println("location = " + f.getAbsolutePath());
            file.write(listOfEmployees.toString());
            System.out.println(listOfEmployees);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
	 }
		
	
		@GET
		@Path("getAll")
		@Produces(MediaType.APPLICATION_JSON)
		/**
		 * method to retrieve all employees
		 * @return JSONArray
		 */
		public JSONArray getAllEmployees() {
			
			//object of json parser
			JSONParser jsonParser = new JSONParser();
			//to read list from file
	        try (FileReader reader = new FileReader("employees.json"))
	        {
	            //Read JSON file
	            Object obj = jsonParser.parse(reader);
	            //storing data in json array
	            JSONArray employeeList = (JSONArray) obj;      
	            return employeeList;
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        return null;
		}
		
		
		@GET
		@Path("id/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		/**
		 * method that calls checkId to retrieve employee details using the given id
		 * @param id - employee id to be searched
		 * @return JSONObject
		 */
		public JSONObject getEmployeeById(@PathParam("id")String id) {
			System.out.println(id);
			JSONParser jsonParser = new JSONParser();
		//to read list from file
	        try (FileReader reader = new FileReader("employees.json"))
	        {
	            //Read JSON file
	           Object obj = jsonParser.parse(reader);
	            //storing data in json array
	           JSONArray employeeList = (JSONArray) obj;
	           //json object to return resultant employee
	           JSONObject resultantEmployee;
	           //Iterate over employee array
	           for(Object ob : employeeList){
	        	   //to check each element's id using method checkId
	        	   resultantEmployee = checkId((JSONObject)ob , id);
	        	   if(resultantEmployee != null) {
	        		   return resultantEmployee;
	        	   }
	           }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
			return null;
		}

		/**
		 * method that checks and returns details of employee of the passed id
		 * @param employee-json object
		 * @param id-id to be searched
		 * @return JSONObject
		 */
		private JSONObject checkId(JSONObject employee, String id) {
			
			JSONObject employeeObject = (JSONObject) employee.get("employee");
			//Get employee  name
	        String Name = (String) employeeObject.get("Name");  
	        //Get employee id
	        String checkId = (String) employeeObject.get("id");
	        //comparing fetched and passed id
	        if(checkId.equals(id)) {
	        	return employeeObject;
	        }
	       return null;		
		}
		
		@GET
		@Path("name/{name}")
		@Produces(MediaType.APPLICATION_JSON)
		/**
		 * method that calls checkName to retrieve employee details using the given name
		 * @param name
		 * @return JSONObject
		 */
		public JSONObject getEmployeeByName(@PathParam("name")String name) {
			
			
			JSONParser jsonParser = new JSONParser();
	        try (FileReader reader = new FileReader("employees.json"))
	        {
	            //Read JSON file
	            Object obj = jsonParser.parse(reader);
	            //storing data in json array
	            JSONArray employeeList = (JSONArray) obj; 
	            //json object to return resultant employee
	            JSONObject resultantEmployee;
	           //Iterate over employee array
	            for(Object ob : employeeList) {
	            	//to check each element's name using method checkName
	        	    resultantEmployee = checkName((JSONObject)ob , name);
	        	    if(resultantEmployee != null){
	        		   return resultantEmployee;
	        	   }
	           }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        return null;
		}

		/**
		 * method that checks and returns details of employee of the passed name
		 * @param employee - object of json
		 * @param name
		 * @return JSONObject
		 */
		private JSONObject checkName(JSONObject employee, String name) {
			
			
			JSONObject employeeObject = (JSONObject) employee.get("employee");
	       //Get employee id
	        String id = (String) employeeObject.get("id");
	        //Get employee name
	        String checkName = (String) employeeObject.get("Name");
	       //comparing fetched and passed name
	        if(checkName.equals(name)){
	        	return employeeObject;
	        }
	        return null;
		}
	   
		@DELETE
		@Path("deleteEmp/{id}")
		/**
		 * method that deletes details of employee from the file 
		 * @param id-id of employee to be deleted
		 * @return JSONArray
		 */
		public JSONArray delEmployeeById(@PathParam("id")String id) {
	    	
			JSONParser jsonParser = new JSONParser();
	        try (FileReader reader = new FileReader("employees.json")) {
	           
	        	//Read JSON file
	            Object obj = jsonParser.parse(reader);
	            //json array to store details
	            JSONArray employeeList = (JSONArray) obj;
	            //loop to iterate over the list to find the employee id to be deleted
	            for(int i = 0; i < employeeList.size(); i++) {
	            	//json object to get  employee 
	            	JSONObject employeeObject = (JSONObject) employeeList.get(i);
	            	//json object to get employeeObject details
	            	JSONObject employeeObject1 = (JSONObject) employeeObject.get("employee");
	            	String checkId = (String) employeeObject1.get("id");
	            	//comparing fetched and passed id
	            	if(checkId.equals(id)) {
	            		 employeeList.remove(i);
	            	 }
	            	 
	            }
	            //to write updated list in the file
	            try (FileWriter file = new FileWriter("employees.json")) {
	           	 
	                file.write(employeeList.toJSONString());
	                file.flush();
	     
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            //to display updated list
	            return getAllEmployees();
	            
	 
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	
}
