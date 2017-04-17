#include <StringTokenizer.h>
#include <SoftwareSerial.h>

#define DEBUG true
SoftwareSerial mySerial(7,8); 
        
void setup(){
  Serial.begin(19200);
  mySerial.begin(19200); 
  getgps();
}

void loop(){
   sendData( "AT+CGNSINF",1000,DEBUG);   
}

void getgps(void){
   sendData( "AT+CGNSPWR=1",1000,DEBUG); 
   sendData( "AT+CGPSINF=0",1000,DEBUG); 
}

void sendData(String command, const int timeout, boolean debug){
    String response = "";    
    mySerial.println(command); 
    delay(5);
    if(debug){
    long int time = millis();   
    while( (time+timeout) > millis()){
      while(mySerial.available()){       
        response += char(mySerial.read());
      }  
    }  
      StringTokenizer tokens(response, ","); 
      tokens.nextToken(); 
      tokens.nextToken(); 
      tokens.nextToken(); 
      String lat = tokens.nextToken();
      String lang = tokens.nextToken();  
      Serial.println("Lattitude: " + lat + " Longitude: " + lang);
      SubmitHttpRequest("Lattitude: " + lat + " Longitude: " + lang);
    }    
}

void SubmitHttpRequest(String message)
{
  mySerial.println("AT+CSQ");
  delay(100);

  ShowSerialData();

  mySerial.println("AT+CGATT?");
  delay(100);

  ShowSerialData();

  mySerial.println("AT+SAPBR=3,1,\"CONTYPE\",\"GPRS\"");//setting the SAPBR, the connection type is using gprs
  delay(1000);

  ShowSerialData();

  mySerial.println("AT+SAPBR=3,1,\"APN\",\"dialogbb\"");//setting the APN
  delay(4000);

  ShowSerialData();

  mySerial.println("AT+SAPBR=1,1");//setting the SAPBR
  delay(5000);

  ShowSerialData();

  mySerial.println("AT+HTTPINIT"); //init the HTTP request

  delay(3000);
  ShowSerialData();

  mySerial.println("AT+HTTPPARA=\"URL\",\"54.202.143.34:8080/PhaseMapsWebService/webresources/device/config\"");// setting the httppara
  delay(3000);

  ShowSerialData();

  mySerial.println("AT+HTTPACTION=0");//submit the request
  delay(10000);//the delay is very important, the delay time is base on the return from the website, if the return datas are very large, the time required longer.
  //while(!mySerial.available());

  ShowSerialData();

  ShowSerialData();

  mySerial.println("");
  delay(100);
}

void ShowSerialData()
{
  while (mySerial.available() != 0)
    Serial.write(mySerial.read());
}
