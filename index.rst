.. figure:: Simba-NS.png
   :align:   center
   
SIMBA_Android
*************

Installation
************

* Hit the "`Clone or Download <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/Install1.png>`_" button in upper right corner of the github page
* Hit the "`Download ZIP <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/Install2.png>`_" button.
* "`Extract the file <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/Install3.png>`_" with your extractor of choice.
* Open Android Studio and click "`Open an existing Android Studio Project <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/Install4.png>`_."
* Navigate to where the extracted project is and `select the project directory <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/Install5.png>`_ of the project (the one that contains the "app" folder) and hit "OK."
* After a brief install, Android Studio should `open the project <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/Install6.png>`_.

Prerequisites
*************
.. note::
  These are already packaged in the app when you clone it.

  * Retrofit
  * Swagger


Usage
*****

There are several screens in the app
====================================

    * `TitleScreen <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/TitleScreen.png>`_ | This is the main screen of the app, where you can access the other screens and select an account.
    * `Most Recent Audits Screen <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/MostRecentAuditsScreen.png>`_ | This is the screen that displays the last 10 audits. You can click on any of them.
    * `Descriptive Screen <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/DescriptiveView.png>`_  | This is the screen that pops up whenever you click on one of the last 10 audits. It lists every element listed with the audit.
    * `Post Screen <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/PostScreen.png>`_ | This is the screen where you can post an audit. Fields can be left empty or populated when posting.
    * More info for all of these screens in the section "More Info."

Modifying/Setting up getting
============================

      * Change the baseURL variable in "`TitleScreen.java <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/TitleScreenJava.png>`_" to your API of choice.
      * Change the @GET and @POST commands in the "`SimbaClient.java <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/SimbaClientJavaInterface.png>`_" Interface to commands relating to your chosen API.
      * Add or delete as many elements relating to your API as needed, making new classes where applicable, such as in "`GetSimba.java, Asset.java, and Item.java <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/GetSimbaAssetItemsJava.png>`_."
      * Change the names `of the elements on the screens <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/DescriptiveScreenXML.png>`_ in order to fit the new data from your API.
      
More Info
*********

TitleScreen
===========
      * From the Title Screen, you can access the others screens of the app.
      * Tapping the "`POST Button <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/TitleScreenPostButton.png>`_" will send you to the Post screen.
      * Tapping the "`AUDIT Button <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/TitleScreenAuditButton.png>`_" will send you to the Most Recent Audits screen.
      * Tapping the "`Account Selector <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/TitleScreenAccountPicker.png>`_" at the top will show a list of all the accounts you can choose from.
      
Most Recent Audits
==================
      * From the Most Recent Audits Screen, you can see the ten most recent audits.
      * You can click on one of the "`audit tabs <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/MRAuditScreenRecycler.png>`_" to access the Descriptive Screen for that audit.
      * Or, you can press the "`BACK <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/MRAuditScreenBack.png>`_" button at the top to go back to the Title Screen.


Descriptive Audits
==================
      * From the Descriptive Audits Screen, you can see all the elements associated with a particular audit, such as `this description <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/DescriptiveScreenDescription.png>`_.
      * Tapping an element will bring up a `pop-up <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/DescriptiveScreenDescriptionPopout.png>`_ with the element in larger text, in case it is hard to read.
      * Tapping either the `CORRECT or INCORRECT button <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/DescriptiveScreenVerifications.png>`_ will verify the audit as either correct or incorrect.
      * Tapping the "`Account Selector <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/DescriptiveScreenAccountSelector.png>`_" at the top will show a list of all the accounts you can choose from.
      * Or, you can press the "`BACK <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/DescriptiveScreenBack.png>`_" button at the top to go back to the Most Recent Audit Screen.


Post
====
      * From the Post Screen, you can create an audit and post it to the API.
      * By tapping the white spaces, you can `edit a certain field's text <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/PostScreenEditTexts.png>`_ to send to the API.
      * By tapping the `POST <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/PostScreenPostButton.png>`_ button, you can send all that you have typed to API.
      * Tapping the "`Account Selector <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/PostScreenAccountSelector.png>`_" at the top will show a list of all the accounts you can choose from.
      * Or, you can press the "`BACK <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/PostScreenBack.png>`_" button at the top to go back to the Title Screen.

Links
*****
  `Swagger <https://swagger.io/>`_
  
  `Retrofit <http://square.github.io/retrofit/>`_
  
  `Github Repo <https://github.com/SIMBAChain>`_
  
  `SIMBA Website <https://simbachain.com/>`_
  
