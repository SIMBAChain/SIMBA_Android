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

Modifying/Setting up getting
============================

      * Change the baseURL variable in "`TitleScreen.java <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/TitleScreenJava.png>`_" to your API of choice.
      * Change the @GET and @POST commands in the "`SimbaClient.java <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/SimbaClientJavaInterface.png>`_" Interface to commands relating to your chosen API.
      * Add or delete as many elements relating to your API as needed, making new classes where applicable, such as in "`GetSimba.java, Asset.java, and Item.java <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/GetSimbaAssetItemsJava.png>`_."
      * Change the names `of the elements on the screens <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/DescriptiveScreenXML.png>`_ in order to fit the new data from your API.

Links
*****
  `Swagger <https://swagger.io/>`_
  
  `Retrofit <http://square.github.io/retrofit/>`_
  
  `Github Repo <https://github.com/SIMBAChain>`_
  
  `SIMBA Website <https://simbachain.com/>`_
  
