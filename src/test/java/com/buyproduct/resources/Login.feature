Feature: Validate that user is able to succesfully login to Amazon.in using correct credentials 


Scenario Outline:  User tries to login to Amazon.in using valid credentials 
Given User is in Amazon.in website
When User hovers to signIn text
And Click to signIn button
And I entered the valid "<mobileNumber>" and clicks to button
And now "<passsword>" and clicks to button
And validate user gets land to homepage


Examples:
| mobileNumber | passsword |
| 9634517163 | Shaniya@2023|
| 9634517162 | Shaniya@2023|
| 9634517163 | Shaniya@2021|





