# finalExam_android
DICE ROLLING APP - Individual
For the final  you are to write a simple dice rolling app that can roll 1 die at a time. The user should be able to select from a list of dice and roll one. The user should also have a button to roll the die twice and show both results. You are free to use any resource on the internet, but please do not rely on pages that explain exactly how to make a dice rolling app (how to generate random numbers, how to show/hide Views is fine). It is expected that you are working on this app on your own without the help of others. I will be available on Zoom, Moodle, and email to answer any questions during our regular class time.

Using RadioButtons, a Spinner, Buttons, ListView/ RecyclerView, allow the user to select which die to roll 
Basic sides: 4, 6, 8, 10, 12, 20
Depending on your choice, you may need to add a Button to actually roll and display the result
Allow the user to enter their own number of sides of dice (full marks)
For more marks, store a String of the entered values (eg myVals = “2, 14, 24”; and save it in SharedPreferences)
There is a second option for less marks:

Before adding the ability to add custom dice, get just the basics to work. This submission will be worth part marks
How to generate random numbers and save in an integer. maxValue should be the number of sides on the die. This still needs to be switched to a String for the setString method:

int randomVal = (int)(Math.random() * maxValue) + 1
