# Portal 42 Application

## Overview
As a student of [42 Silicon Valley](https://www.42.us.org) I decided to build our school’s app. The app utilizes our school API [42 API](https://api.intra.42.fr/apidoc).


## Details and Description

### Functionality

With Portal 42 you can search for students by their login


![55869293_2194850053938436_3295630948564992000_n](https://user-images.githubusercontent.com/33399226/55455390-4a36b500-5598-11e9-8b0f-74689e7c77e0.png)

Here is the list of valid student logins for testing:
* **ydeineha**
* **dgonor**
* **mpetruse**
* **vmuradia**

If a login is valid the information about a student will be displayed. In particular, his **name, surname, profile picture, number of wallet points, evaluation points, phone number, email, cursus, grade** etc.

![56398418_333080147344961_1389735057731616768_n (1)](https://user-images.githubusercontent.com/33399226/55456973-5ffaa900-559d-11e9-8174-3b70817189a7.png)

The second tab contains the list of his achievements with the following information name of the achievement, its description and icon

![56691319_290800148519180_4015601079512203264_n](https://user-images.githubusercontent.com/33399226/55455451-85d17f00-5598-11e9-8f67-8a2e6b0547f0.png)

In order to search for other students one can press the search icon on the app bar or select options menu Home

![55917842_582745415535097_3318798204023078912_n](https://user-images.githubusercontent.com/33399226/55456871-05614d00-559d-11e9-8e9b-f14eb5a7acb0.png)

## App Requirements
  
### Activities: 2
  * The app contains 2 Activities:
    - [x] MainActivity class - is the home page class
    - [x] UserActivity class - is the class which holds the 2 Fragments
 ### Fragments: 2 
  * The 2 Fragments are:
      - [x] InfoFragment class - displays the basic information about the user
      - [x] AchievementsFragment class - displays user’s achievements with the help of Recycler View
  
  ### Services: 0
- [x] My idea was to use IntentService to get information about the user from the API, but due to the lack of time I didn’t implement it
 ### UI components from the Android Material Design Component Library: 5
      
  - [x] Text Input
  - [x] Material Button
  - [x] Top App Bar
  - [x] Tab Layout
  - [x] Card View
      
  ### MVVM Architecture: is partially used
 

#### Model

All the classes in model package. These are POJO classes used for parsing JSON data and a separate Model class.

Model class is a singleton. It holds an object of MutableLiveData User class and other information about the user. NetworkService class parses this information from the API and stores it to Model class. This is not the best implementation. If I had more time I would have implemented it differently. I would store the information to the Database and would observe it with the help of LiveData

#### View

View is represented by XML files: activity_main.xml and fragment_info.xml

#### ViewModel
View is represented by MainViewModel class. Two classes (MainActivity class and InfoFragment class) are bound to it. I used both one-way and two-way databinding for this project

## Additional Frameworks
This project uses Retrofit Library for API. I was learning this library from scratch in order to be able to use our school’s API

## **Developed with love and passion by**

Yuliya Deinega
