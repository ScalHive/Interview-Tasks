Task-1
I have run project https://github.com/dataengi/crm-seed using "Try in PWD" in cloud.
I have read project general documentation https://github.com/dataengi/crm-seed/wiki
I have logged in on web interface with default credentials
Task-2
I have discovered front-end project https://github.com/dataengi/crm-seed-ui and documentation for it  https://github.com/dataengi/crm-seed-ui/wiki/Customer%20contacts
1.	User story for Customer contact add

Main goal CRM: to manage and analyze customer interactions and data throughout the customer lifecycle, with the goal of improving business relationships with customers, assisting in customer retention and driving sales growth.

as a user I can create Customers database 
as a user I can create a CONTACT with detail information about my customers
•	there is possibility to add customer’s emails, phones as much as I need
•	there possibility to edit CONTACT 
•	there is possibility to delete CONTACT
as a user I can filter CONTACTS by Id, Name, Company, Phone, Email
as a user I can sort CONTACTS  by Id, Name, Company
as a user I can search a CONTACT  by Id, Name, Company, Email
as a user I can group created CONTACTS
•	there is possibility to add each contact to one or more groups
•	there is possibility to delete contact from a Group
•	there possibility to edit Groups
•	there is possibility to delete Groups
as a administrator I can invite / cancel invitation of new users with different roles (deploying representative, root, manager, invoicing representative, company manager, sales  representative, testing representative)
as a administrator I can see invitation statuses (Waiting, Registered,  Expired)
as a administrator I can activate / deactivate users
as a administrator I can view Contact book of each Company’s member
as a administrator I can manage own CONTACTS

2.	 Use cases for Customer contact add

As sales representative user can manage Contacts with detailed information  such as emails, phones, company, position in company, language, address. 
Also user can group Contacts by divisions, sales offices, product groups, by interest, quantities of purchases, regions etc. with possibility to create own Groups and to add Contacts to one or more groups and remove them from its.

As company manager user can manage own Contact book, create Contact books of partners, suppliers, sales  representative, end customers,  and share it between  other departments. Also  user can group Contacts by divisions, sales offices, product groups, regions etc. with possibility to create own Groups and to add Contacts to one or more groups
As company manager user can invite other users in different roles by sending invitation email.
3.	Requirements for Customer contact add 
Required fields: Name, email, phone
There is possibility to add email with one of the types 
There is possibility to add phone with one of the types 

Bug report according to above restrictions according to example: https://github.com/dataengi/crm-seed-ui/issues/6
1. There is no possibility to sort by "Email" fld. 
expected behavior
There should be a possibility to sort by "Email" fld.
actual behavior
There is no possibility to sort by "Email" fld.
Sorting works only by "Id", "Name", "Company" fld.
steps to reproduce
Go to Contacts > 
Try to sort Contacts by clicking on "Email" in the table header
 
2. There is no warning message for invalid Address fields
expected behavior
Invalid fields should be highlighted
actual behavior
There is no warning for invalid Address fields: “Street”, “City”, “State” 
"Submit" btn. is inactive
steps to reproduce
Fill in required fields >
Fill in "Street", "City" "State" with more than 50 characters (>50) >
"Submit" btn. is inactive
There is no warning for invalid "Street", "City" "State" fields
 
3. Server error while creating Contact with only Space in “Name” fld.
expected behavior
Should clear Spaces before and after the text in the input fields
actual behavior
Server error while creating Contact with only Space in "Name" fld.
steps to reproduce
Fill in "Name" fld. with Spaces >
Fill in the rest of the required fields >
Click on "Submit" btn.
 
4. Not all required fields are highlighted
expected behavior
All required fields are highlighted
actual behavior
“Email”, “Phone” fld. are not highlighted
Only "Name" fld. is highlighted
steps to reproduce
Go to Contacts > 
Add Contact > 
Try to submit new contact
https://www.screencast.com/t/DtcF2ilt6N
 
5. Deleted Group is displayed in "Groups" fld. of the Contact which was added to this group
expected behavior
Group is deleted from all Contacts which was added to this group after Group 's deleting
actual behavior
Deleted Group is displayed in "Groups" fld. of the Contact which was added to this group
Precondition
There is created Contact
There is created Group
Step to reproduce
Add selected Contact to the Group >
Go to the "Groups">
Delete the Group > confirm deleting >
Open the Contact
Bug: Deleted Group is displayed in "Groups" fld.
https://www.screencast.com/t/Thyzx4AaN1MJ
Task-3
1.	I have discovered backend API for UI requests
2.	Discover Swagger implementation https://github.com/dataengi/crm-seed/blob/master/conf/routes. I’ve tried use Swager webUI http://[host:9000]/docs
There are not all API request that are used in CRM program, for example:
auth/api/v1/invites/1
/auth/invite
auth/api/v1/companies/all
auth/api/v1/companies/create
/api/v1/profile/get/users
auth/api/v1/management/users/company/current/members

Incorrect "Example Value | Model" in SWAGGER with which it is impossible to send request, for example:
/api/v1/contacts/create
https://www.screencast.com/t/Sb4QGlKmQtao
There are used incorrect request method which isn’t appropriate for the requested resource, for example:
POST /api/v1/contacts/delete >> It should be DELETE method
POST /api/v1/contacts/group/delete >> It should be PUT method
There are the requested resources, which do the same functions, for example:
DELETE /api/v1/contacts/delete/{id}/advertiser  >> The same is POST /api/v1/contacts/delete
POST /api/v1/contacts/group/update (Update group data) >> The same is POST /api/v1/contacts/group/create (Create new group)

There are returned incorrect proper status code according to the operation completed, for example:
“Undocumented: TypeError: Failed to fetch” returns with Status 200
https://www.screencast.com/t/4XbgulCIhu54
“Unknown response type” returns with Status 200
https://www.screencast.com/t/wsZDsULS

3.	I've verified Customer contacts management (Customer contacts managements) according API Security Checklist

Checks	Status
Authentication

Don't use Basic Auth Use standard authentication (e.g. JWT, OAuth).	Pass
Don't reinvent the wheel in Authentication, token generation, password storage. Use the standards.	Pass
Use Max Retry and jail features in Login.	Not explored
Use encryption on all sensitive data.	Pass
JWT (JSON Web Token)

Use a random complicated key (JWT Secret) to make brute forcing the token very hard.	Pass
Don't extract the algorithm from the payload. Force the algorithm in the backend (HS256 or RS256).	Not explored
Make token expiration (TTL, RTTL) as short as possible.	Not explored
Don't store sensitive data in the JWT payload, it can be decoded easily.

OAuth

Always validate redirect_uri server-side to allow only whitelisted URLs.	Not explored
Always try to exchange for code and not tokens (don't allow response_type=token).	Pass
Use state parameter with a random hash to prevent CSRF on the OAuth authentication process.	Pass
Define the default scope, and validate scope parameters for each application.	Not explored
Access

Limit requests (Throttling) to avoid DDoS / brute-force attacks.	
Use HTTPS on server side to avoid MITM (Man In The Middle Attack).	Not explored
Use HSTS header with SSL to avoid SSL Strip attack.	Not explored
Input

Use the proper HTTP method according to the operation: GET (read), POST (create), PUT/PATCH (replace/update), and DELETE (to delete a record), and respond with 405 Method Not Allowed if the requested method isn't appropriate for the requested resource.	Faild
Validate content-type on request Accept header (Content Negotiation) to allow only your supported format (e.g. application/xml, application/json, etc) and respond with 406 Not Acceptable response if not matched.	Pass
Validate content-type of posted data as you accept (e.g. application/x-www-form-urlencoded, multipart/form-data, application/json, etc).	Not explored
Validate User input to avoid common vulnerabilities (e.g. XSS, SQL-Injection, Remote Code Execution, etc).	Not explored
Don't use any sensitive data (credentials, Passwords, security tokens, or API keys) in the URL, but use standard Authorization header.	Not explored
Use an API Gateway service to enable caching, Rate Limit policies (e.g. Quota, Spike Arrest, Concurrent Rate Limit) and deploy APIs resources dynamically.	Not explored
Processing

Check if all the endpoints are protected behind authentication to avoid broken authentication process.	Not explored
User own resource ID should be avoided. Use /me/orders instead of /user/654321/orders.	Not explored
Don't auto-increment IDs. Use UUID instead.	Pass
If you are parsing XML files, make sure entity parsing is not enabled to avoid XXE (XML external entity attack).	Not explored
If you are parsing XML files, make sure entity expansion is not enabled to avoid Billion Laughs/XML bomb via exponential entity expansion attack.	Not explored
Use a CDN for file uploads.	Not explored
If you are dealing with huge amount of data, use Workers and Queues to process as much as possible in background and return response fast to avoid HTTP Blocking.	Not explored
Do not forget to turn the DEBUG mode OFF.	Not explored
Output

Send X-Content-Type-Options: nosniff header.	Not explored
Send X-Frame-Options: deny header.	Not explored
Send Content-Security-Policy: default-src 'none' header.	Not explored
Remove fingerprinting headers - X-Powered-By, Server, X-AspNet-Version etc.	Not explored
Force content-type for your response, if you return application/json then your response content-type is application/json.	Pass
Don't return sensitive data like credentials, Passwords, security tokens.	Not explored
Return the proper status code according to the operation completed. (e.g. 200 OK, 400 Bad Request, 401 Unauthorized, 405 Method Not Allowed, etc).	Faild
CI & CD

Audit your design and implementation with unit/integration tests coverage.	Not explored
Use a code review process and disregard self-approval.	Not explored
Ensure that all components of your services are statically scanned by AV software before push to production, including vendor libraries and other dependencies.	Not explored
Design a rollback solution for deployments.	Not explored

