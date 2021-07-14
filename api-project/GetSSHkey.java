
import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GetSSHkey {
 
	//declare request specification
	RequestSpecification requestSpec;
	
	//Declare SSH key
	 ResponseSpecification responseSpec;
	String sshkey="ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQC/7+KDVl6SIQDucrO+E4MEbpbsQ5wEiIMmeZ9GZjC38yxx2kZBPkB8eib/tYizKGeDcW9DZOXsngNmqFWyCkM5/xoKaxz+66npDPBDAi0W2m3422SSg5OQrYdEHk1vSqGf0C54v+L3jAg/6DG4TldDiR1t2Zf60cDeaYtHwBJzEghPoDK0XJqih8TcuwIm8R9y3/3HOBye4878/aN9Sy+ctfOs8nAjbzJ2DgMmnX5GWY+7KJEqso9wgNTGHM7FkO2l3KzjXwm2SZGm7UYCa7kIPhozr3sceQllZ9atfm+bJiPRpBHKnUGTX9dGnu3ciwv0pPcIu8Ba9NaLAZjfBd0N";
	int sshid;
	
	@BeforeClass
	public void setUp() {
		 // Create request specification
        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "token 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")
                .setBaseUri("https://api.github.com")
                .build();
		
	}
	
	@Test(priority=1)
    public void sendSSHKey() {    	
        String reqBody = "{\"title\": \"TestAPIKey\", \"key\":\""+sshkey+"\"}";
        
        Response response = given().spec(requestSpec) // Use requestSpec
                .body(reqBody) // Send request body
                .when().post("/user/keys"); // Send POST request
        
        sshid = response.then().extract().path("id");
        
        response.then().statusCode(201);
    }
	
	@Test(priority=2)
    public void getSSHKey() { 
    	
        Response response = given().spec(requestSpec) // Use requestSpec
        		.pathParam("sshId", sshid)
                .when().get("/user/keys/{sshId}"); // Send GET request
        
        System.out.println(response.asPrettyString());
        
        response.then().statusCode(200);
    }
	
	  @Test(priority=3)
	    public void deleteSSHKey() { 
	    	
	        Response response = given().spec(requestSpec) // Use requestSpec
	        		.pathParam("sshId", sshid)
	                .when().delete("/user/keys/{sshId}"); // Send DELTE request
	        
	        System.out.println(response.asPrettyString());
	        
	        response.then().statusCode(204);
	    }
	
}
