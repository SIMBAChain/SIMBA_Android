.. figure:: Simba-NS.png
   :align:   center
   
SIMBA_iOS
*********

Installation
************

* Hit the "`Clone or Download <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/Install1.png>`_" button in upper right corner of the github page
* Hit the "`Download ZIP <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/Install2.png>`_" button.
* "`Extract the file <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/Install3.png>`_" with your extractor of choice.
* Open Android Studio and click "`Open an existing Android Studio Project <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/Install4.png>`_."
* Navigate to where the extracted project is and `select the project directory <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/Install5.png>` of the project (the one that contains the "app" folder) and hit "OK."
* After a brief install, Android Studio should `open the project <https://github.com/SIMBAChain/SIMBA_Android/blob/master/Screenshots/Install6.png>`_.

Prerequisites
*************
.. note::
  These are already packaged in the app when you clone it.

  * Retrofit
  * Swagger


Usage
*****

There are several views in the app
==================================

    * `View Controller <https://github.com/SIMBAChain/SIMBA_iOS/blob/master/ScreenShots/View%20Controller.png>`_ | This is the main view of the app here you can go to the other views as well as select an account.
    * `Most Recent Audits Scene <https://github.com/SIMBAChain/SIMBA_iOS/blob/master/ScreenShots/Most%20Recent%20Audits%20Scene.png>`_ | This is the view that displays the last 10 audits you can click on any of them.
    * `Detail View Controller <https://github.com/SIMBAChain/SIMBA_iOS/blob/master/ScreenShots/Detail%20View%20Controller.png>`_  | This is the view that pops up whenever you click on one of the last 10 audits.
    * `Post View Controller <https://github.com/SIMBAChain/SIMBA_iOS/blob/master/ScreenShots/Post%20View%20Controller.png>`_ | This is the view where you can post items. Fields can be left empty or populated when posting.

Modifying/Setting up getting
============================

      * Change the URL in "`APIs.Swift <https://github.com/SIMBAChain/SIMBA_iOS/blob/master/ScreenShots/APIs.png>`_"
      * Setup the model in "`Model.Swift <https://github.com/SIMBAChain/SIMBA_iOS/blob/master/ScreenShots/Model.png>`_" under the folder "Models"
      * Change the path in "`DefaultAPI.Swift <https://github.com/SIMBAChain/SIMBA_iOS/blob/master/ScreenShots/DefaultAPI.png>`_" under the folder "APIs"
      * Setup the decoder in "`Models.Swift <https://github.com/SIMBAChain/SIMBA_iOS/blob/master/ScreenShots/Models.png>`_"
      * Change the `view controller <https://github.com/SIMBAChain/SIMBA_iOS/blob/master/ScreenShots/AuditViewController.png>`_ to use the right data for the model
      * Change the `view layout and outlets <https://github.com/SIMBAChain/SIMBA_iOS/blob/master/ScreenShots/Outlets.png>`_ to fit the new model

Links
*****
  `Swagger <https://swagger.io/>`_
  
  `Retrofit <http://square.github.io/retrofit/>`_
  
  `Github Repo <https://github.com/SIMBAChain>`_
  
  `SIMBA Website <https://simbachain.com/>`_
  
