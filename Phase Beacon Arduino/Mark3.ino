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