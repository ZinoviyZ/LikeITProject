
LOGIN
GET
/login
request
{
    private String username;
    private String password;
}
response
current user
{
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String birthday;
    private String registrationDate;
    private int statusCode;   
    private String errorMessage;
}
- if login unsuccess statusCode = 1 and errorMessage have a message about it;

------------------------------------------------------------------------------
USERS

GET
/rest/users/{id}
response
{
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String birthday;
    private String registrationDate;
}

GET
/rest/users/current
response
{
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String birthday;
    private String registrationDate;
    private int statusCode;   
    private String errorMessage;
}

POST
/rest/users
request
{
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String birthday;
}
response
{
    private int statusCode;
    private String errorMessage;
}

PUT
/rest/users/{id}
{
request
{
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String birthday;
}
response
{
    private int statusCode;
    private String errorMessage;
}

------------------------------------------------------------------------------
PHOTO
GET
/rest/photos/{id}
get photo

DELETE
/rest/photos{id}
remove photo

POST
/rest/photos
multipart
request param's name - photo

------------------------------------------------------------------------------
MY PROFILE
GET
/rest/users/current/profile
response:
{
    statusCode
    errorMessage
    data : {
        String email;
        String firstName;
        String lastName;
        String birthDay;
        String photoUrl
        String phoneNumber;
    }
}

NOT MY PROFILE
GET
/rest/users/{id}/profile
response:
{
    statusCode
    errorMessage
    data : {
        String email;
        String firstName;
        String lastName;
        String birthDay;
        String photoUrl
        String phoneNumber;
        String lastVisit;
    }
}

CHANGE SETTING
PUT
request:
{
    String showEmail;
    String showBirthday;
    String showPhoneNumber;
}
response:
{
    int statusCode
    String errorMessage
    data: {
        String showEmail;
        String showBirthday;
        String showPhoneNumber;
    }
}

