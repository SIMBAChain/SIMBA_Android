![Simba Logo](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Simba-NS.png)

If you prefer to read this README through ReadTheDocs, please go [here](http://simba-android.readthedocs.io).

# Simba_Android

This app allows the user to connect to a Swagger-based API of their choice and, using Retrofit, allow the user to both get information from and send information to the API.

## Installation

* Hit the "[Clone or Download](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/Install1.png)" button in upper right corner of the github page
* Hit the "[Download ZIP](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/Install2.png)" button.
* "[Extract the file](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/Install3.png)" with your extractor of choice.
* Open Android Studio and click "[Open an existing Android Studio Project](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/Install4.png)."
* Navigate to where the extracted project is and [select the project directory](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/Install5.png) of the project (the one that contains the "app" folder) and hit "OK."
* After a brief install, Android Studio should [open the project](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/Install6.png).

## Prerequisites

```
Note:
These are already packaged in the app when you clone it.

   * Retrofit
   * Swagger
```

## Usage

### There are several screens in the app
* [TitleScreen](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/TitleScreen.png>) | This is the main screen of the app, where you can access the other screens and select an account.
* [Most Recent Audits Screen](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/MostRecentAuditsScreen.png) | This is the screen that displays the last 10 audits. You can click on any of them.
* [Descriptive Screen](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/DescriptiveView.png>) | This is the screen that pops up whenever you click on one of the last 10 audits. It lists every element listed with the audit.
* [Post Screen](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/PostScreen.png>) | This is the screen where you can post an audit. Fields can be left empty or populated when posting.
* More info for all of these screens in the section "More Info."


### Modifying/Setting up getting
* Change the baseURL variable in "[TitleScreen.java](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/TitleScreenJava.png)" to your API of choice.
* Change the @GET and @POST commands in the "[SimbaClient.java](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/SimbaClientJavaInterface.png)" Interface to commands relating to your chosen API.
* Add or delete as many elements relating to your API as needed, making new classes where applicable, such as in "[GetSimba.java, Asset.java, and Item.java](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/GetSimbaAssetItemsJava.png>)."
* Change the names [of the elements on the screens](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/DescriptiveScreenXML.png) in order to fit the new data from your API.

## More Info

### TitleScreen

* From the Title Screen, you can access the others screens of the app.
* Tapping the "[POST Button](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/TitleScreenPostButton.png)" will send you to the Post screen.
* Tapping the "[AUDIT Button](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/TitleScreenAuditButton.png)" will send you to the Most Recent Audits screen.
* Tapping the "[Account Selector](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/TitleScreenAccountPicker.png)" at the top will show a list of all the accounts you can choose from.
      
### Most Recent Audits

* From the Most Recent Audits Screen, you can see the ten most recent audits.
* If you dislike which way the audits are listed (newest to oldest), you can click the "[REVERSE](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/MRAuditScreenReverse.png)" button to show them oldest to newest.
* You can click on one of the "[audit tabs](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/MRAuditScreenRecycler.png)" to access the Descriptive Screen for that audit.
* Or, you can press the "[BACK](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/MRAuditScreenBack.png)" button at the top to go back to the Title Screen.

### Descriptive Audits

* From the Descriptive Audits Screen, you can see all the elements associated with a particular audit, such as [this description](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/DescriptiveScreenDescription.png).
* Tapping an element will bring up a [pop-up](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/DescriptiveScreenDescriptionPopout.png) with the element in larger text, in case it is hard to read.
* Tapping either the [CORRECT or INCORRECT button](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/DescriptiveScreenVerifications.png) will verify the audit as either correct or incorrect.
* Tapping the "[Account Selector](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/DescriptiveScreenAccountSelector.png>)" at the top will show a list of all the accounts you can choose from.
* Or, you can press the "[BACK](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/DescriptiveScreenBack.png)" button at the top to go back to the Most Recent Audit Screen.

### Post

* From the Post Screen, you can create an audit and post it to the API.
* By tapping the white spaces, you can [edit a certain field's text](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/PostScreenEditTexts.png) to send to the API.
* By tapping the "[POST](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/PostScreenPostButton.png)" button, you can send all that you have typed to API.
* Tapping the "[Account Selector](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/PostScreenAccountSelector.png)" at the top will show a list of all the accounts you can choose from.
* Or, you can press the "[BACK](https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/PostScreenBack.png>)" button at the top to go back to the Title Screen.

## Links

[Swagger](https://swagger.io/)
  
[Retrofit](http://square.github.io/retrofit/)
  
[Github Repo](https://github.com/SIMBAChain)
  
[SIMBA Website](https://simbachain.com/)
