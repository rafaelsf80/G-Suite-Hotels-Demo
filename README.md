# Drive for Work backend - Hospitality (Hotels) Android app #

[![GitHub license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/rafaelsf80/d4wretail/blob/master/LICENSE.txt)

Drive for Work customizable apk to demonstrate hospitality use case with Google Spreadsheets and Google Forms.

The apk uses this [public form in Spanish](https://docs.google.com/forms/d/1WBP8Fp-ZEQomoe0i22xTCi2wvqXUsoJILqzsRB0fT84/viewform) and this [spreadsheet as backend](https://docs.google.com/spreadsheets/d/1VDWN6xkPANGKIXO_fjnm94JTX8cHZFkBMnrWj24p2uw/edit?usp=sharing), mandatory to execute the apk. 
The apk makes use of JSON download functionality of Google Spreadsheets as explained [in this video](https://www.youtube.com/watch?v=RSgMEtRl0sw). 

The spreadsheet contains one Google Apps Script project in order to download data and certain parameters, like colors.

See info on Google for Work here: [http://www.google.com/work](http://www.google.com/work)


## Android application Usage

1) Launch the apk

2) If desired, open the backend (spreadsheet) and customize text and colors.

## Workflow

1) The client fills a public form to select the hotel activit.

2) Hotel manager can see in real time number of clients and related activities. Only hotel manager has access to the apk and the spreadsheet.

![image alt text](screenshots/Workflow.png "Workflow Form->Spreadsheet->Android")


## Backend

The backend is a [Google Spreadheet](https://docs.google.com/spreadsheets/d/1VDWN6xkPANGKIXO_fjnm94JTX8cHZFkBMnrWj24p2uw/edit?usp=sharing), hosted on Drive for Work.
Some information on the spreadsheet is populated through this [Google Form](https://docs.google.com/forms/d/1WBP8Fp-ZEQomoe0i22xTCi2wvqXUsoJILqzsRB0fT84/viewform) associated to the spreadsheet


## Dependencies
The following dependency needs to be added to build.gradle:

```groovy  
   compile 'com.android.volley:volley:1.0.0'
```


## Screenshots

![image alt text](screenshots/Google_Form.png "Google Form") ![image alt text](screenshots/Spreadsheet_Hotels.png "Google Spreadsheet") ![image alt text](screenshots/main.png "Android app")
