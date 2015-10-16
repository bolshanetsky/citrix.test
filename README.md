This technical task for Citrix company interview.

How To Run Tests:
1. Run next Maven command in command line, from the root of project:
mvn clean compile test -Dtest=com.citrix.podio.test.* -DargLine="-DPassword=YOUR_PASSWORD -DLogin=YOUR_LOGIN"

Before running please substitude YOUR_PASSWORD and YOUR_LOGIN with valid credentials.

Test Cases in suite:
LoginTest.validLoginTest:
Test: Validate successful login with valid credentials.
Steps:
1. Navigate to login page.
2. Enter valid login and password.
3. Click Login button
Expected result:
3. Home page is loaded

LogintTest.invalidLoginTest:
Test: Validate proper message after unsuccessful login.
Steps:
1. Navigate to login page
2. Enter valid login
3. Enter invalid password
4. Click login button
Expected result:
4. "Sorry, wrong password. Have you forgotten your password?" message is shown.

HomePageTest.publishStatusPostTest:
Test: Verify that status publishing functionality.
Steps:
1. Navigate to Login page.
2. Do login with valid credentials.
3. Enter status text into Status field.
4. Click share button.
5. Pick workspace according to test data.
Expected result:
2. Home page is loaded
4. Status is published and visible.

HomePageTest.publishEmptyStatusTest:
Test: Verify that empty status is not publishing.
Steps:
1. Navigate to Login page.
2. Do login with valid credentials.
3. Enter empty status text into Status field.
4. Click share button.
Expected result:
2. Home page is loaded
4. Status is not published and warning icon is appeared.