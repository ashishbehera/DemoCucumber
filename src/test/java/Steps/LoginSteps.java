package Steps;

import Base.BaseUtil;
import Transformation.EmailTransform;
import Transformation.SalaryCountTransformer;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.ArrayList;
import java.util.List;

public class LoginSteps extends BaseUtil{

    private  BaseUtil base;

    public LoginSteps(BaseUtil base)
    {
        this.base=base;

    }




    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {
        System.out.println("The driver is: "+base.StepInfo);
        System.out.println("Navigate to the login page");
    }

    @And("^I enter the following for login$")
    public void iEnterTheFollowingForLogin(DataTable dataTable) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       /* List<List<String>> data=dataTable.raw();

        System.out.println(data.get(0).get(0));
        System.out.println(data.get(0).get(1));
*/

       //Create an ArrayList of Type UserDetails
        List<User> users=new ArrayList<User>();

        //Store all the userdetails
        users=dataTable.asList(User.class);

        for(User user:users)
        {
            System.out.println("The UserName is: "+ user.username);
            System.out.println("The Password is: "+user.password);
        }

    }

    @And("^I enter the ([^\"]*) and ([^\"]*)$")
    public void iEnterTheUsernameAndPassword(String userName,String password) throws Throwable {
        System.out.println("User Name is: "+userName);
        System.out.println("Password is: "+password);
    }

    @And("^I click login button$")
    public void iClickLoginButton() throws Throwable {
        System.out.println("I click the login button");
    }
    @Then("^I should see the userform page$")
    public void iShouldSeeTheUserformPage() throws Throwable {
        System.out.println("I should see the userForm");
    }

    @And("^I enter the user email address as Email:([^\"]*)")
    public void iEnterTheUserEmailAddressAsEmailAdmin(@Transform(EmailTransform.class) String email) throws Throwable {
        System.out.println("The Email Address is: "+email);
    }

    @And("^I verify the count of my salary digits for Rs (\\d+)$")
    public void iVerifyTheCountOfMySalaryDigitsForRs(@Transform(SalaryCountTransformer.class) int salary) throws Throwable {

        System.out.println("My salary digits count is :"+ salary);

    }


    public class User
{
    public String username;
    public String password;

    public User(String userName,String passWord)
    {
        username=userName;
        password=passWord;
    }


}


}
