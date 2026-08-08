## 1. Title
Blood Donation Network and Emergency Matching Platform


## 2. Domain
Healthcare / HealthTech / Full Stack Web Application


## 3. Who is the User? (User Types & Roles)
1. Donor
Register account
Update blood group & availability
Accept or reject blood requests
View donation history
2. Patient / Hospital
Register account
Raise emergency blood request
Search matching donors
Track request status
3. Admin
Manage donors and patients
Verify hospitals
Remove fake accounts
Monitor blood requests and reports


## 4. What problem are we solving?
Many patients face difficulty finding the required blood group during emergencies. Searching for donors through phone calls or social media takes valuable time. Blood banks may not always have the required blood available. This application helps patients quickly find matching nearby donors and enables hospitals to respond faster, improving the chances of saving lives.


## 5. Proposed Solution
The application allows donors to register and update their availability. Patients or hospitals can raise blood requests by specifying the required blood group and location. The system matches the request with available donors using the database. If the request is marked as critical, notifications can be sent to nearby registered donors and hospitals. All requests and donation records are stored and managed securely.


## 6. Core Entities / Database Tables
Users
Donors
Patients
Hospitals
Blood Requests
Donations
Notifications
Admin


## 7. User Roles & Permissions
Admin
Manage all users
Verify hospitals
Remove fake accounts
View reports
Monitor requests
Donor
Register/Login
Update profile
Change availability
Accept/Reject blood requests
Patient/Hospital
Register/Login
Create blood requests
View matching donors
Track request status


## 8. Success Criteria
Donor should be able to register in less than 2 minutes.
Patient should be able to submit an emergency blood request in less than 1 minute.
System should display matching donors within 5–10 seconds.
Admin should be able to monitor all requests through a dashboard.
Emergency notifications should reach registered users quickly.


## 9. Out of Scope
Online payment integration
Ambulance booking
Live GPS tracking
Video calling between donor and patient
Medical diagnosis features
(Indha features future enhancement-la add pannalaam.)


## 10. Chosen Track
Java (Spring Boot)
Frontend: React.js / HTML, CSS, JavaScript
Backend: Spring Boot (Java)
Database: MySQL
Cloud Deployment: Render / Railway / AWS
Version Control: Git & GitHub