# SpringBootEmail

This Repository contains Restful Api for sending E-mail using `smtp.gmail.com` host.

## Download or clone this project as :

```
Download or clone -> Import project ->Existing Maven Projects -> Run as Spring Boot project
```
## APIs Developed for  :

```
1.sendMail                   

2.sendMailWithAttachment

```
## Edit sender's E-mail address and password at application.properties file.
### Directory location src/main/resource/application.properties
```
spring.mail.username = *********@gmail.com	 
spring.mail.password = *********
```
## Write receiver's email address at RegistrationController.java
```
user.setEmailAddress("Your_Email_Address");
```
## APIs are accessible at the link :

* Send Mail without Attachment :
```
http://localhost:8080/send-mail
```
* Send Mail with Attachment :
```
http://localhost:8080/send-mail-attachment
```

