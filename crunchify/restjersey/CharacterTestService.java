package crunchify.restjersey;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


@Path("/characterservice")
public class CharacterTestService {

	private static Character obj;

	@GET
	//@Produces("application/xml")
	@Produces( MediaType.APPLICATION_JSON )
	@Path("/testservice")
	public Response getStudentDetails() {
		ArrayList <Character> arraylist = new ArrayList<Character>();
		arraylist.add(new Character("Jack", "Napier", 21 ));
		arraylist.add(new Character("Zoey", "Redbird", 21 ));
		arraylist.add(new Character("Bruce", "Wayne", 21 ));
		arraylist.add(new Character("Lois", "Lane", 21 ));
		arraylist.add(new Character("Clark", "Kent", 22 ));
		
		return Response.status(200).entity(arraylist).build();
	}

	@GET
	//@Produces("application/xml")
	@Produces( MediaType.APPLICATION_JSON )
	@Path("/displayservice")
	public Response DisplayStudentDetails(@Context UriInfo info) {
		String firstname = info.getQueryParameters().getFirst("firstname");
		String lastname = info.getQueryParameters().getFirst("lastname");
		String age = info.getQueryParameters().getFirst("age");
		obj = new Character();
		obj.setFirstName(firstname);
		obj.setLastName(lastname);
		obj.setAge(Integer.valueOf(age));
		return Response.status(200).entity("firstname: " + obj.getFirstName() + "lastname:  "
				+ obj.getLastName() + " age: " + obj.getAge()).build();
	} 
}
//http://localhost:8080/StudentRestArray/crunchify/studentservice/testservice