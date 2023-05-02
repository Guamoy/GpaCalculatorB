# GpaCalculator
Team 7: Debug Thugs
Created By Esteban Leal (tei192) and Georgy Vinogradov (klr151) for UTSA CS 3443 in Spring 2023

The GPA Calculator is an app to quickly calculate a User's GPA and the effect of various theoretical outcomes on said GPA from specific course grades. 
Additionally, there is an additional function for students of CS 3443 to quickly calculate what grade they need to achieve on the final for their desired
course grade based on their current assignment grades.

Functionality: 
  - SimpleGrades Activity functions as intended with proper calculations
  - Settings Activity properly reads initial state from file and saves changes to file
  - GradeNeeded Activity can be used to calculate the grade needed on the final exam for CS 3443 to ahieve a desired letter grade in the course

Does not Work / Not Implemented: 
  - The Dark Mode Theme Switch does not properly change the app's theme
  - A "remove previous entry" button has not been added to the GPA Calculator
  - Weights in "GradeNeeded" activity for the project grades are incorrect with the assumption that each portion of the project is weighted equally (they are not)
  - "GradeNeeded" model does not account for case where a greater final exam grade replaces the score of the midterm
  
 How to Clone File to Android Studio from Github: 
  
 Method 1 - 
  1. Go to Repository page on Github and grab the link or copy from here: https://github.com/UTSA-CS-3443/GPACalculator.git
  2. Open Android Studio, go to File > New > Project from Version Control
  3. In the new pop-up, select Git from the Version Control Drop-down
  4. Paste in the repository URL ending in .git into URL
  (Optional). Choose the directory you wish to download the project into
  5. Click Clone 
  6. To run, go to the "run" tab and press run "app".
  
 Method 2 - 
  1. Go to Repository page on Github and grab the link or copy from here: https://github.com/UTSA-CS-3443/GPACalculator.git
  2. Open Android Studio and click on "Checkout Project from Version Control", choose Git from the dropdown menu
  3. Paste the link above ending in .git into the URL and choose your directory. 
  4. Click on the Clone button
  5. To run, go to the "run" tab and press run "app".
