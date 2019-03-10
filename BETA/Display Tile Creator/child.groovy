/**
 *  
 *
 *  Copyright 2019 Andrew Parker
 *  
 *  This App is Free!
 *
 *  Donations to support development efforts are accepted via: 
 *
 *  Paypal at: https://www.paypal.me/smartcobra
 *  
 *
 *  I'm very happy for you to use this app without a donation, but if you find it useful
 *  then it would be nice to get a 'shout out' on the forum! -  @Cobra
 *  Have an idea to make this app better?  - Please let me know :)
 *
 *  
 *
 *-------------------------------------------------------------------------------------------------------------------
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *-------------------------------------------------------------------------------------------------------------------
 *
 *  If modifying this project, please keep the above header intact and add your comments/credits below - Thank you! -  @Cobra
 *
 *-------------------------------------------------------------------------------------------------------------------
 *
 *  Last Update: 10/03/2019
 *
 *  Changes:
 *
 *  V1.0.0 - POC
 *
 */



definition(
    name:"Display Tile Creator Child",
    namespace: "Cobra",
    author: "Andrew Parker",
    description: " ",
    category: "Convenience",
	
	parent: "Cobra:Display Tile Creator",
	
    iconUrl: "",
    iconX2Url: "",
    iconX3Url: ""
    )

preferences {
	page name: "mainPage", title: "", install: true, uninstall: true
	page name: "line1"
	page name: "line2"
	page name: "line3"
	page name: "line4"
	page name: "line5"
	page name: "line6"
	page name: "line7"
	page name: "line8"
}



def installed() {initialize()}
def updated() {initialize()}
def initialize() {
	version()
	unsubscribe()
    log.info "Initialised with settings: ${settings}"
    subscribeNow() 
	def refreshIntervalCmd = (settings?.refreshInterval ?: "5 Minutes").replace(" ", "")
    if(refreshInterval == "Manual Refresh Only"){log.info "MANUAL REFRESH ONLY"}
    else{ "runEvery${refreshIntervalCmd}"(sendLines)}
	sendLines()
}

def mainPage() {
    dynamicPage(name: "mainPage") {   

		section (){input "vDevice", "device.Display_Tile_Device", title: "Virtual Display Device", required: true}	
		section (){input "refreshInterval", "enum", title: "Auto Refresh Interval", required: true, defaultValue: "1 Minutes", options: ["Disabled", "1 Minute", "5 Minutes", "10 Minutes", "15 Minutes", "30 Minutes", "1 Hour", "3 Hours"]}
	
		
		section(){
		href "line1", title:"Click here to configure Line 1", description: ""
        href "line2", title:"Click here to configure Line 2", description: ""
		href "line3", title:"Click here to configure Line 3", description: ""
		href "line4", title:"Click here to configure Line 4", description: ""
        href "line5", title:"Click here to configure Line 5", description: ""
		href "line6", title:"Click here to configure Line 6", description: ""
		href "line7", title:"Click here to configure Line 7", description: ""
		href "line8", title:"Click here to configure Line 8", description: ""	
		}		 
		section() {input "logLevel", "enum", title: "Set Logging Level", required:true, defaultValue: "NONE", options: ["NONE", "INFO", "DEBUG & INFO"]}
		section() {label title: "Enter a name for this automation", required: false}		 
				 
	 
  }
}

def subscribeNow(){

	if(device1){subscribe(device1, device1attrib, device1Handler)} 
	if(device2){subscribe(device2, device2attrib, device2Handler)}
	if(device3){subscribe(device3, device3attrib, device3Handler)}
	if(device4){subscribe(device4, device4attrib, device4Handler)}
	if(device5){subscribe(device5, device5attrib, device5Handler)}
	if(device6){subscribe(device6, device6attrib, device6Handler)}
	if(device7){subscribe(device7, device7attrib, device7Handler)}
	if(device8){subscribe(device8, device8attrib, device8Handler)}
	if(device9){subscribe(device9, device9attrib, device9Handler)}
	if(device10){subscribe(device10, device10attrib, device10Handler)} 
	if(device11){subscribe(device11, device11attrib, device11Handler)}
	if(device12){subscribe(device12, device12attrib, device12Handler)}
	if(device13){subscribe(device13, device13attrib, device13Handler)}
	if(device14){subscribe(device14, device14attrib, device14Handler)}
	if(device15){subscribe(device15, device15attrib, device15Handler)}
	if(device16){subscribe(device16, device16attrib, device16Handler)}
	if(device17){subscribe(device17, device17attrib, device17Handler)}
	if(device18){subscribe(device18, device18attrib, device18Handler)}
	if(device19){subscribe(device19, device19attrib, device19Handler)}
	if(device20){subscribe(device20, device20attrib, device20Handler)} 
	if(device21){subscribe(device21, device21attrib, device21Handler)}
	if(device22){subscribe(device22, device22attrib, device22Handler)}
	if(device23){subscribe(device23, device23attrib, device23Handler)}
	if(device24){subscribe(device24, device24attrib, device24Handler)}

}

def line1() {
       dynamicPage(name: "line1") {
		
	section ("Line 1 Configuration"){
			   
	input "line1aType", "enum", required: false, title: "Line1 Column A", submitOnChange: true, options: ["Text", "Device Attribute", "Image URL", "Blank"] 	
		if(line1aType == "Text"){input "line1aText", "text", required: true, title: "Text to show?"	}
		if(line1aType == "Device Attribute"){
		input "device1", "capability.*", title: "Select Device", required: true, multiple: false, submitOnChange: true	
		input "device1attrib", "text", title: "Enter Device Attribute", required: true, multiple: false	
		}
		if(line1aType == "Image URL"){
		input "imageURL1a", "text", title: "Image URL", required: true, multiple: false, submitOnChange: true	
		input "imageWidth1a", "number", title: "Enter Width", required: true, multiple: false	
		input "imageHeight1a", "number", title: "Enter Height", required: true, multiple: false	
		input "imageBorder1a", "number", title: "Enter Border Size", required: true, defaultValue: 0 , multiple: false 
		}	
	
	input "line1bType", "enum", required: false, title: "Line1 Column B", submitOnChange: true, options: ["Text", "Device Attribute", "Image URL", "Blank"] 	
		if(line1bType == "Text"){input "line1bText", "text", required: true, title: "Text to show?"	}
		if(line1bType == "Device Attribute"){
		input "device2", "capability.*", title: "Select Device", required: true, multiple: false, submitOnChange: true	
		input "device2attrib", "text", title: "Enter Device Attribute", required: true, multiple: false	
		}	
	if(line1bType == "Image URL"){
		input "imageURL1b", "text", title: "Image URL", required: true, multiple: false, submitOnChange: true	
		input "imageWidth1b", "number", title: "Enter Width", required: true, multiple: false	
		input "imageHeight1b", "number", title: "Enter Height", required: true, multiple: false
		input "imageBorder1b", "number", title: "Enter Border Size", required: true, defaultValue: 0 , multiple: false 
	
		}	
		
	input "line1cType", "enum", required: false, title: "Line1 Column C", submitOnChange: true, options: ["Text", "Device Attribute", "Image URL", "Blank"] 	
		if(line1cType == "Text"){input "line1cText", "text", required: true, title: "Text to show?"	}
		if(line1cType == "Device Attribute"){
		input "device3", "capability.*", title: "Select Device", required: true, multiple: false, submitOnChange: true	
		input "device3attrib", "text", title: "Enter Device Attribute", required: true, multiple: false	
		}
	if(line1cType == "Image URL"){
		input "imageURL1c", "text", title: "Image URL", required: true, multiple: false, submitOnChange: true	
		input "imageWidth1c", "number", title: "Enter Width", required: true, multiple: false	
		input "imageHeight1c", "number", title: "Enter Height", required: true, multiple: false
		input "imageBorder1c", "number", title: "Enter Border Size", required: true, defaultValue: 0 , multiple: false 	
		}	
	 }		
  }  
}

def line2() {
       dynamicPage(name: "line2") {
		
	section ("Line 2 Configuration"){
			   
	input "line2aType", "enum", required: false, title: "Line2 Column A", submitOnChange: true, options: ["Text", "Device Attribute", "Image URL", "Blank"] 	
		if(line2aType == "Text"){input "line2aText", "text", required: true, title: "Text to show?"	}
		if(line2aType == "Device Attribute"){
		input "device4", "capability.*", title: "Select Device", required: true, multiple: false, submitOnChange: true	
		input "device4attrib", "text", title: "Enter Device Attribute", required: true, multiple: false	
		}
		if(line2aType == "Image URL"){
		input "imageURL2a", "text", title: "Image URL", required: true, multiple: false, submitOnChange: true	
		input "imageWidth2a", "number", title: "Enter Width", required: true, multiple: false	
		input "imageHeight2a", "number", title: "Enter Height", required: true, multiple: false	
		input "imageBorder2a", "number", title: "Enter Border Size", required: true, defaultValue: 0 , multiple: false 
		}	
	
	input "line2bType", "enum", required: false, title: "Line2 Column B", submitOnChange: true, options: ["Text", "Device Attribute", "Image URL", "Blank"] 		
		if(line2bType == "Text"){input "line2bText", "text", required: true, title: "Text to show?"	}
		if(line2bType == "Device Attribute"){
		input "device5", "capability.*", title: "Select Device", required: true,  multiple: false, submitOnChange: true	
		input "device5attrib", "text", title: "Enter Device Attribute", required: true, multiple: false	
		}
		
	if(line2bType == "Image URL"){
		input "imageURL2b", "text", title: "Image URL", required: true, multiple: false, submitOnChange: true	
		input "imageWidth2b", "number", title: "Enter Width", required: true, multiple: false	
		input "imageHeight2b", "number", title: "Enter Height", required: true, multiple: false	
		input "imageBorder2b", "number", title: "Enter Border Size", required: true, defaultValue: 0 , multiple: false 
		}		
		
	input "line2cType", "enum", required: false, title: "Line2 Column C", submitOnChange: true, options: ["Text", "Device Attribute", "Image URL", "Blank"] 	
		if(line2cType == "Text"){input "line2cText", "text", required: true, title: "Text to show?"	}
		if(line2cType == "Device Attribute"){
		input "device6", "capability.*", title: "Select Device", required: true,  multiple: false, submitOnChange: true	
		input "device6attrib", "text", title: "Enter Device Attribute", required: true, multiple: false	
		}
	if(line2cType == "Image URL"){
		input "imageURL2c", "text", title: "Image URL", required: true, multiple: false, submitOnChange: true	
		input "imageWidth2c", "number", title: "Enter Width", required: true, multiple: false	
		input "imageHeight2c", "number", title: "Enter Height", required: true, multiple: false	
		input "imageBorder2c", "number", title: "Enter Border Size", required: true, defaultValue: 0 , multiple: false 
		}		
	 }		
  }  
}

def line3() {
       dynamicPage(name: "line3") {
		
	section ("Line 3 Configuration"){
			   
	input "line3aType", "enum", required: false, title: "Line3 Column A", submitOnChange: true, options: ["Text", "Device Attribute", "Image URL", "Blank"] 		
		if(line3aType == "Text"){input "line3aText", "text", required: true, title: "Text to show?"	}
		if(line3aType == "Device Attribute"){
		input "device7", "capability.*", title: "Select Device",  required: true, multiple: false, submitOnChange: true	
		input "device7attrib", "text", title: "Enter Device Attribute", required: true, multiple: false	
		}
	if(line3aType == "Image URL"){
		input "imageURL3a", "text", title: "Image URL", required: true, multiple: false, submitOnChange: true	
		input "imageWidth3a", "number", title: "Enter Width", required: true, multiple: false	
		input "imageHeight3a", "number", title: "Enter Height", required: true, multiple: false	
		input "imageBorder3a", "number", title: "Enter Border Size", required: true, defaultValue: 0 , multiple: false 
		}		
	
	input "line3bType", "enum", required: false, title: "Line3 Column B", submitOnChange: true, options: ["Text", "Device Attribute", "Image URL", "Blank"] 		
		if(line3bType == "Text"){input "line3bText", "text", required: true, title: "Text to show?"	}
		if(line3bType == "Device Attribute"){
		input "device8", "capability.*", title: "Select Device",  required: true, multiple: false, submitOnChange: true	
		input "device8attrib", "text", title: "Enter Device Attribute", required: true, multiple: false	
		}
	if(line3bType == "Image URL"){
		input "imageURL3b", "text", title: "Image URL", required: true, multiple: false, submitOnChange: true	
		input "imageWidth3b", "number", title: "Enter Width", required: true, multiple: false	
		input "imageHeight3b", "number", title: "Enter Height", required: true, multiple: false	
		input "imageBorder3b", "number", title: "Enter Border Size", required: true, defaultValue: 0 , multiple: false 
		}			
		
	input "line3cType", "enum", required: false, title: "Line3 Column C", submitOnChange: true, options: ["Text", "Device Attribute", "Image URL", "Blank"] 	 	
		if(line3cType == "Text"){input "line3cText", "text", required: true, title: "Text to show?"	}
		if(line3cType == "Device Attribute"){
		input "device9", "capability.*", title: "Select Device",  required: true, multiple: false, submitOnChange: true	
		input "device9attrib", "text", title: "Enter Device Attribute", required: true, multiple: false	
		}
	if(line3cType == "Image URL"){
		input "imageURL3c", "text", title: "Image URL", required: true, multiple: false, submitOnChange: true	
		input "imageWidth3c", "number", title: "Enter Width", required: true, multiple: false	
		input "imageHeight3c", "number", title: "Enter Height", required: true, multiple: false	
		input "imageBorder3c", "number", title: "Enter Border Size", required: true, defaultValue: 0 , multiple: false 
		}			
	 }		
  }  
}
def line4() {
       dynamicPage(name: "line4") {
		
	section ("Line 4 Configuration"){
			   
	input "line4aType", "enum", required: false, title: "Line4 Column A", submitOnChange: true, options: ["Text", "Device Attribute", "Image URL", "Blank"] 		
		if(line4aType == "Text"){input "line4aText", "text", required: true, title: "Text to show?"	}
		if(line4aType == "Device Attribute"){
		input "device10", "capability.*", title: "Select Device", required: true,  multiple: false, submitOnChange: true	
		input "device10attrib", "text", title: "Enter Device Attribute", required: true, multiple: false	
		}
	if(line4aType == "Image URL"){
		input "imageURL4a", "text", title: "Image URL", required: true, multiple: false, submitOnChange: true	
		input "imageWidth4a", "number", title: "Enter Width", required: true, multiple: false	
		input "imageHeight4a", "number", title: "Enter Height", required: true, multiple: false	
		input "imageBorder4a", "number", title: "Enter Border Size", required: true, defaultValue: 0 , multiple: false 
		}	
	
	input "line4bType", "enum", required: false, title: "Line4 Column B", submitOnChange: true, options: ["Text", "Device Attribute", "Image URL", "Blank"] 	
		if(line4bType == "Text"){input "line4bText", "text", required: true, title: "Text to show?"	}
		if(line4bType == "Device Attribute"){
		input "device11", "capability.*", title: "Select Device", required: true,  multiple: false, submitOnChange: true	
		input "device11attrib", "text", title: "Enter Device Attribute", required: true, multiple: false	
		}
	if(line4bType == "Image URL"){
		input "imageURL4b", "text", title: "Image URL", required: true, multiple: false, submitOnChange: true	
		input "imageWidth4b", "number", title: "Enter Width", required: true, multiple: false	
		input "imageHeight4b", "number", title: "Enter Height", required: true, multiple: false	
		input "imageBorder4b", "number", title: "Enter Border Size", required: true, defaultValue: 0 , multiple: false 
		}		
		
	input "line4cType", "enum", required: false, title: "Line4 Column C", submitOnChange: true, options: ["Text", "Device Attribute", "Image URL", "Blank"] 	
		if(line4cType == "Text"){input "line4cText", "text", required: true, title: "Text to show?"	}
		if(line4cType == "Device Attribute"){
		input "device12", "capability.*", title: "Select Device", required: true,  multiple: false, submitOnChange: true	
		input "device12attrib", "text", title: "Enter Device Attribute", required: true, multiple: false	
		}
	if(line4cType == "Image URL"){
		input "imageURL4c", "text", title: "Image URL", required: true, multiple: false, submitOnChange: true	
		input "imageWidth4c", "number", title: "Enter Width", required: true, multiple: false	
		input "imageHeight4c", "number", title: "Enter Height", required: true, multiple: false	
		input "imageBorder4c", "number", title: "Enter Border Size", required: true, defaultValue: 0 , multiple: false 
		}		
	 }		
  }  
}


def line5() {
       dynamicPage(name: "line5") {
		
	section ("Line 5 Configuration"){
			   
	input "line5aType", "enum", required: false, title: "Line5 Column A", submitOnChange: true, options: ["Text", "Device Attribute", "Image URL", "Blank"] 	
		if(line5aType == "Text"){input "line5aText", "text", required: true, title: "Text to show?"	}
		if(line5aType == "Device Attribute"){
		input "device13", "capability.*", title: "Select Device",  required: true, multiple: false, submitOnChange: true	
		input "device13attrib", "text", title: "Enter Device Attribute", required: true, multiple: false	
		}
	if(line5aType == "Image URL"){
		input "imageURL5a", "text", title: "Image URL", required: true, multiple: false, submitOnChange: true	
		input "imageWidth5a", "number", title: "Enter Width", required: true, multiple: false	
		input "imageHeight5a", "number", title: "Enter Height", required: true, multiple: false	
		input "imageBorder5a", "number", title: "Enter Border Size", required: true, defaultValue: 0 , multiple: false 
		}		
	
	input "line5bType", "enum", required: false, title: "Line5 Column B", submitOnChange: true, options: ["Text", "Device Attribute", "Image URL", "Blank"] 	
		if(line5bType == "Text"){input "line5bText", "text", required: true, title: "Text to show?"	}
		if(line5bType == "Device Attribute"){
		input "device14", "capability.*", title: "Select Device", required: true, multiple: false, submitOnChange: true	
		input "device14attrib", "text", title: "Enter Device Attribute", required: true, multiple: false	
		}
	if(line5bType == "Image URL"){
		input "imageURL5b", "text", title: "Image URL", required: true, multiple: false, submitOnChange: true	
		input "imageWidth5b", "number", title: "Enter Width", required: true, multiple: false	
		input "imageHeight5b", "number", title: "Enter Height", required: true, multiple: false	
		input "imageBorder5b", "number", title: "Enter Border Size", required: true, defaultValue: 0 , multiple: false 
		}			
		
	input "line5cType", "enum", required: false, title: "Line5 Column C", submitOnChange: true, options: ["Text", "Device Attribute", "Image URL", "Blank"] 		
		if(line5cType == "Text"){input "line5cText", "text", required: true, title: "Text to show?"	}
		if(line5cType == "Device Attribute"){
		input "device15", "capability.*", title: "Select Device", required: true, multiple: false, submitOnChange: true	
		input "device15attrib", "text", title: "Enter Device Attribute", required: true, multiple: false	
		}
		if(line5caType == "Image URL"){
		input "imageURL5c", "text", title: "Image URL", required: true, multiple: false, submitOnChange: true	
		input "imageWidth5c", "number", title: "Enter Width", required: true, multiple: false	
		input "imageHeight5c", "number", title: "Enter Height", required: true, multiple: false	
		input "imageBorder5c", "number", title: "Enter Border Size", required: true, defaultValue: 0 , multiple: false 
		}		
	 }		
  }  
}


def line6() {
       dynamicPage(name: "line6") {
		
	section ("Line 6 Configuration"){
			   
	input "line6aType", "enum", required: false, title: "Line6 Column A", submitOnChange: true, options: ["Text", "Device Attribute", "Image URL", "Blank"] 	
		if(line6aType == "Text"){input "line6aText", "text", required: true, title: "Text to show?"	}
		if(line6aType == "Device Attribute"){
		input "device16", "capability.*", title: "Select Device", required: true, multiple: false, submitOnChange: true	
		input "device16attrib", "text", title: "Enter Device Attribute", required: true, multiple: false	
		}
	if(line6aType == "Image URL"){
		input "imageURL6a", "text", title: "Image URL", required: true, multiple: false, submitOnChange: true	
		input "imageWidth6a", "number", title: "Enter Width", required: true, multiple: false	
		input "imageHeight6a", "number", title: "Enter Height", required: true, multiple: false	
		input "imageBorder6a", "number", title: "Enter Border Size", required: true, defaultValue: 0 , multiple: false 
		}			
	
	input "line6bType", "enum", required: false, title: "Line6 Column B", submitOnChange: true, options: ["Text", "Device Attribute", "Image URL", "Blank"] 	
		if(line6bType == "Text"){input "line6bText", "text", required: true, title: "Text to show?"	}
		if(line6bType == "Device Attribute"){
		input "device17", "capability.*", title: "Select Device", required: true, multiple: false, submitOnChange: true	
		input "device17attrib", "text", title: "Enter Device Attribute", required: true, multiple: false	
		}	
	if(line6bType == "Image URL"){
		input "imageURL6b", "text", title: "Image URL", required: true, multiple: false, submitOnChange: true	
		input "imageWidth6b", "number", title: "Enter Width", required: true, multiple: false	
		input "imageHeight6b", "number", title: "Enter Height", required: true, multiple: false	
		input "imageBorder6b", "number", title: "Enter Border Size", required: true, defaultValue: 0 , multiple: false 
		}			
		
	input "line6cType", "enum", required: false, title: "Line6 Column C", submitOnChange: true, options: ["Text", "Device Attribute", "Image URL", "Blank"] 	 	
		if(line6cType == "Text"){input "line6cText", "text", required: true, title: "Text to show?"	}
		if(line6cType == "Device Attribute"){
		input "device18", "capability.*", title: "Select Device", required: true, multiple: false, submitOnChange: true	
		input "device18attrib", "text", title: "Enter Device Attribute", required: true, multiple: false	
		}	
	if(line6cType == "Image URL"){
		input "imageURL6c", "text", title: "Image URL", required: true, multiple: false, submitOnChange: true	
		input "imageWidth6c", "number", title: "Enter Width", required: true, multiple: false	
		input "imageHeight6c", "number", title: "Enter Height", required: true, multiple: false	
		input "imageBorder6c", "number", title: "Enter Border Size", required: true, defaultValue: 0 , multiple: false 
		}			
	 }		
  }  
}


def line7() {
       dynamicPage(name: "line7") {
		
	section ("Line 7 Configuration"){
			   
	input "line7aType", "enum", required: false, title: "Line7 Column A", submitOnChange: true, options: ["Text", "Device Attribute", "Image URL", "Blank"] 	 	
		if(line7aType == "Text"){input "line7aText", "text", required: true, title: "Text to show?"	}
		if(line7aType == "Device Attribute"){
		input "device19", "capability.*", title: "Select Device", required: true, multiple: false, submitOnChange: true	
		input "device19attrib", "text", title: "Enter Device Attribute", required: true, multiple: false	
		}
	if(line7aType == "Image URL"){
		input "imageURL7a", "text", title: "Image URL", required: true, multiple: false, submitOnChange: true	
		input "imageWidth7a", "number", title: "Enter Width", required: true, multiple: false	
		input "imageHeight7a", "number", title: "Enter Height", required: true, multiple: false	
		input "imageBorder7a", "number", title: "Enter Border Size", required: true, defaultValue: 0 , multiple: false 
		}			
	
	input "line7bType", "enum", required: false, title: "Line7 Column B", submitOnChange: true, options: ["Text", "Device Attribute", "Image URL", "Blank"] 	
		if(line7bType == "Text"){input "line7bText", "text", required: true, title: "Text to show?"	}
		if(line7bType == "Device Attribute"){
		input "device20", "capability.*", title: "Select Device", required: true, multiple: false, submitOnChange: true	
		input "device20attrib", "text", title: "Enter Device Attribute", required: true, multiple: false	
		}	
	if(line7bType == "Image URL"){
		input "imageURL7b", "text", title: "Image URL", required: true, multiple: false, submitOnChange: true	
		input "imageWidth7b", "number", title: "Enter Width", required: true, multiple: false	
		input "imageHeight7b", "number", title: "Enter Height", required: true, multiple: false	
		input "imageBorder7b", "number", title: "Enter Border Size", required: true, defaultValue: 0 , multiple: false 
		}			
		
	input "line7cType", "enum", required: false, title: "Line7 Column C", submitOnChange: true, options: ["Text", "Device Attribute", "Image URL", "Blank"] 	
		if(line7cType == "Text"){input "line7cText", "text", required: true, title: "Text to show?"	}
		if(line7cType == "Device Attribute"){
		input "device21", "capability.*", title: "Select Device", required: true, multiple: false, submitOnChange: true	
		input "device21attrib", "text", title: "Enter Device Attribute", required: true, multiple: false	
		}	
	if(line7cType == "Image URL"){
		input "imageURL7c", "text", title: "Image URL", required: true, multiple: false, submitOnChange: true	
		input "imageWidth7c", "number", title: "Enter Width", required: true, multiple: false	
		input "imageHeight7c", "number", title: "Enter Height", required: true, multiple: false	
		input "imageBorder7c", "number", title: "Enter Border Size", required: true, defaultValue: 0 , multiple: false 
		}			
	 }		
  }  
}


def line8() {
       dynamicPage(name: "line8") {
		
	section ("Line 8 Configuration"){
			   
	input "line8aType", "enum", required: false, title: "Line8 Column A", submitOnChange: true, options: ["Text", "Device Attribute", "Image URL", "Blank"] 		
		if(line8aType == "Text"){input "line8aText", "text", required: true, title: "Text to show?"	}
		if(line8aType == "Device Attribute"){
		input "device22", "capability.*", title: "Select Device", required: true, multiple: false, submitOnChange: true	
		input "device22attrib", "text", title: "Enter Device Attribute", required: true, multiple: false	
		}
	if(line8aType == "Image URL"){
		input "imageURL8a", "text", title: "Image URL", required: true, multiple: false, submitOnChange: true	
		input "imageWidth8a", "number", title: "Enter Width", required: true, multiple: false	
		input "imageHeight8a", "number", title: "Enter Height", required: true, multiple: false	
		input "imageBorder8a", "number", title: "Enter Border Size", required: true, defaultValue: 0 , multiple: false 
		}			
	
	input "line8bType", "enum", required: false, title: "Line8 Column B", submitOnChange: true, options: ["Text", "Device Attribute", "Image URL", "Blank"] 	
		if(line8bType == "Text"){input "line8bText", "text", required: true, title: "Text to show?"	}
		if(line8bType == "Device Attribute"){
		input "device23", "capability.*", title: "Select Device", required: true, multiple: false, submitOnChange: true	
		input "device23attrib", "text", title: "Enter Device Attribute", required: true, multiple: false	
		}
	if(line8bType == "Image URL"){
		input "imageURL8b", "text", title: "Image URL", required: true, multiple: false, submitOnChange: true	
		input "imageWidth8b", "number", title: "Enter Width", required: true, multiple: false	
		input "imageHeight8b", "number", title: "Enter Height", required: true, multiple: false	
		input "imageBorder8b", "number", title: "Enter Border Size", required: true, defaultValue: 0 , multiple: false 
		}		
		
	input "line8cType", "enum", required: false, title: "Line8 Column C", submitOnChange: true, options: ["Text", "Device Attribute", "Image URL", "Blank"] 	
		if(line8cType == "Text"){input "line8cText", "text", required: true, title: "Text to show?"	}
		if(line8cType == "Device Attribute"){
		input "device24", "capability.*", title: "Select Device", required: true, multiple: false, submitOnChange: true	
		input "device24attrib", "text", title: "Enter Device Attribute", required: true, multiple: false	
		}
	if(line8cType == "Image URL"){
		input "imageURL8c", "text", title: "Image URL", required: true, multiple: false, submitOnChange: true	
		input "imageWidth8c", "number", title: "Enter Width", required: true, multiple: false	
		input "imageHeight8c", "number", title: "Enter Height", required: true, multiple: false	
		input "imageBorder8c", "number", title: "Enter Border Size", required: true, defaultValue: 0 , multiple: false 
		}	
	 }		
  }  
}






def sendLines(){
		LOGDEBUG("Running sendlines... Updating data in each line & sending data to the dashboard")
	state.imageURL1a = "<img src='" +imageURL1a +"' width='" +imageWidth1a +"' height='" +imageHeight1a +"' border='" +imageBorder1a +"'>"
	state.imageURL1b = "<img src='" +imageURL1b +"' width='" +imageWidth1b +"' height='" +imageHeight1b +"' border='" +imageBorder1b +"'>"
	state.imageURL1c = "<img src='" +imageURL1c +"' width='" +imageWidth1c +"' height='" +imageHeight1c +"' border='" +imageBorder1c +"'>"
	state.imageURL2a = "<img src='" +imageURL2a +"' width='" +imageWidth2a +"' height='" +imageHeight2a +"' border='" +imageBorder2a +"'>"
	state.imageURL2b = "<img src='" +imageURL2b +"' width='" +imageWidth2b +"' height='" +imageHeight2b +"' border='" +imageBorder2b +"'>"
	state.imageURL2c = "<img src='" +imageURL2c +"' width='" +imageWidth2c +"' height='" +imageHeight2c +"' border='" +imageBorder2c +"'>"
	state.imageURL3a = "<img src='" +imageURL3a +"' width='" +imageWidth3a +"' height='" +imageHeight3a +"' border='" +imageBorder3a +"'>"
	state.imageURL3b = "<img src='" +imageURL3b +"' width='" +imageWidth3b +"' height='" +imageHeight3b +"' border='" +imageBorder3b +"'>"
	state.imageURL3c = "<img src='" +imageURL3c +"' width='" +imageWidth3c +"' height='" +imageHeight3c +"' border='" +imageBorder3c +"'>"
	state.imageURL4a = "<img src='" +imageURL4a +"' width='" +imageWidth4a +"' height='" +imageHeight4a +"' border='" +imageBorder4a +"'>"
	state.imageURL4b = "<img src='" +imageURL4b +"' width='" +imageWidth4b +"' height='" +imageHeight4b +"' border='" +imageBorder4b +"'>"
	state.imageURL4c = "<img src='" +imageURL4c +"' width='" +imageWidth4c +"' height='" +imageHeight4c +"' border='" +imageBorder4c +"'>"
	state.imageURL5a = "<img src='" +imageURL5a +"' width='" +imageWidth5a +"' height='" +imageHeight5a +"' border='" +imageBorder5a +"'>"
	state.imageURL5b = "<img src='" +imageURL5b +"' width='" +imageWidth5b +"' height='" +imageHeight5b +"' border='" +imageBorder5b +"'>"
	state.imageURL5c = "<img src='" +imageURL5c +"' width='" +imageWidth5c +"' height='" +imageHeight5c +"' border='" +imageBorder5c +"'>"
	state.imageURL6a = "<img src='" +imageURL6a +"' width='" +imageWidth6a +"' height='" +imageHeight6a +"' border='" +imageBorder6a +"'>"
	state.imageURL6b = "<img src='" +imageURL6b +"' width='" +imageWidth6b +"' height='" +imageHeight6b +"' border='" +imageBorder6b +"'>"
	state.imageURL6c = "<img src='" +imageURL6c +"' width='" +imageWidth6c +"' height='" +imageHeight6c +"' border='" +imageBorder6c +"'>"
	state.imageURL7a = "<img src='" +imageURL7a +"' width='" +imageWidth7a +"' height='" +imageHeight7a +"' border='" +imageBorder7a +"'>"
	state.imageURL7b = "<img src='" +imageURL7b +"' width='" +imageWidth7b +"' height='" +imageHeight7b +"' border='" +imageBorder7b +"'>"
	state.imageURL7c = "<img src='" +imageURL7c +"' width='" +imageWidth7c +"' height='" +imageHeight7c +"' border='" +imageBorder7c +"'>"
	state.imageURL8a = "<img src='" +imageURL8a +"' width='" +imageWidth8a +"' height='" +imageHeight8a +"' border='" +imageBorder8a +"'>"
	state.imageURL8b = "<img src='" +imageURL8b +"' width='" +imageWidth8b +"' height='" +imageHeight8b +"' border='" +imageBorder8b +"'>"
	state.imageURL8c = "<img src='" +imageURL8c +"' width='" +imageWidth8c +"' height='" +imageHeight8c +"' border='" +imageBorder8c +"'>"

	if(line1aType == "Blank" || line1aType == null){state.line1aVal = " "}
	if(line1aType == "Text"){state.line1aVal = line1aText}
	if(line1aType == "Device Attribute"){state.line1aVal = state.dev1Val}
	if(line1aType == "Image URL"){state.line1aVal = state.imageURL1a}
	vDevice.line1a(state.line1aVal)	
	if(line1bType == "Blank" || line1bType == null){state.line1bVal = " "}
	if(line1bType == "Text"){state.line1bVal = line1bText}
	if(line1bType == "Device Attribute"){state.line1bVal = state.dev2Val}
	if(line1bType == "Image URL"){state.line1bVal = state.imageURL1b}
	vDevice.line1b(state.line1bVal)	
	if(line1cType == "Blank" || line1cType == null){state.line1cVal = " "}
	if(line1cType == "Text"){state.line1cVal = line1cText}
	if(line1cType == "Device Attribute"){state.line1cVal = state.dev3Val}
	if(line1cType == "Image URL"){state.line1cVal = state.imageURL1c}
	vDevice.line1c(state.line1cVal)	
	if(line2aType == "Blank" || line2aType == null){state.line2aVal = " "}
	if(line2aType == "Text"){state.line2aVal = line2aText}
	if(line2aType == "Device Attribute"){state.line2aVal = state.dev4Val}
	if(line2aType == "Image URL"){state.line2aVal = state.imageURL2a}
	vDevice.line2a(state.line2aVal)	
	if(line2bType == "Blank" || line2bType == null){state.line2bVal = " "}
	if(line2bType == "Text"){state.line2bVal = line2bText}
	if(line2bType == "Device Attribute"){state.line2bVal = state.dev5Val}
	if(line2bType == "Image URL"){state.line2bVal = state.imageURL2b}
	vDevice.line2b(state.line2bVal)	
	if(line2cType == "Blank" || line2cType == null){state.line2cVal = " "}
	if(line2cType == "Text"){state.line2cVal = line2cText}
	if(line2cType == "Device Attribute"){state.line2cVal = state.dev6Val}
	if(line2cType == "Image URL"){state.line2cVal = state.imageURL2c}
	vDevice.line2c(state.line2cVal)	
	if(line3aType == "Blank" || line3aType == null){state.line3aVal = " "}
	if(line3aType == "Text"){state.line3aVal = line3aText}
	if(line3aType == "Device Attribute"){state.line3aVal = state.dev7Val}
	if(line3aType == "Image URL"){state.line3aVal = state.imageURL3a}
	vDevice.line3a(state.line3aVal)	
	if(line3bType == "Blank" || line3bType == null){state.line3bVal = " "}
	if(line3bType == "Text"){state.line3bVal = line3bText}
	if(line3bType == "Device Attribute"){state.line3bVal = state.dev8Val}
	if(line3bType == "Image URL"){state.line3bVal = state.imageURL3b}
	vDevice.line3b(state.line3bVal)	
	if(line3cType == "Blank" || line3cType == null){state.line3cVal = " "}
	if(line3cType == "Text"){state.line3cVal = line3cText}
	if(line3cType == "Device Attribute"){state.line3cVal = state.dev9Val}
	if(line3cType == "Image URL"){state.line3cVal = state.imageURL3c}
	vDevice.line3c(state.line3cVal)	
	if(line4aType == "Blank" || line4aType == null){state.line4aVal = " "}
	if(line4aType == "Text"){state.line4aVal = line4aText}
	if(line4aType == "Device Attribute"){state.line4aVal = state.dev10Val}
	if(line4aType == "Image URL"){state.line4aVal = state.imageURL4a}
	vDevice.line4a(state.line4aVal)
	if(line4bType == "Blank" || line4bType == null){state.line4bVal = " "}
	if(line4bType == "Text"){state.line4bVal = line4bText}
	if(line4bType == "Device Attribute"){state.line4bVal = state.dev11Val}
	if(line4bType == "Image URL"){state.line4bVal = state.imageURL4b}
	vDevice.line4b(state.line4bVal)	
	if(line4cType == "Blank" || line4cType == null){state.line4cVal = " "}
	if(line4cType == "Text"){state.line4cVal = line4cText}
	if(line4cType == "Device Attribute"){state.line4cVal = state.dev12Val}
	if(line4cType == "Image URL"){state.line4cVal = state.imageURL4c}
	vDevice.line4c(state.line4cVal)	
	if(line5aType == "Blank" || line5aType == null){state.line5aVal = " "}
	if(line5aType == "Text"){state.line5aVal = line5aText}
	if(line5aType == "Device Attribute"){state.line5aVal = state.dev13Val}
	if(line5aType == "Image URL"){state.line5aVal = state.imageURL5a}
	vDevice.line5a(state.line5aVal)	
	if(line5bType == "Blank" || line5bType == null){state.line5bVal = " "}
	if(line5bType == "Text"){state.line5bVal = line5bText}
	if(line5bType == "Device Attribute"){state.line5bVal = state.dev14Val}
	if(line5bType == "Image URL"){state.line5bVal = state.imageURL5b}
	vDevice.line5b(state.line5bVal)	
	if(line5cType == "Blank" || line5cType == null){state.line5cVal = " "}
	if(line5cType == "Text"){state.line5cVal = line5cText}
	if(line5cType == "Device Attribute"){state.line5cVal = state.dev15Val}
	if(line5cType == "Image URL"){state.line5cVal = state.imageURL5c}
	vDevice.line5c(state.line5cVal)	
	if(line6aType == "Blank" || line6aType == null){state.line6aVal = " "}
	if(line6aType == "Text"){state.line6aVal = line6aText}
	if(line6aType == "Device Attribute"){state.line6aVal = state.dev16Val}
	if(line6aType == "Image URL"){state.line6aVal = state.imageURL6a}
	vDevice.line6a(state.line6aVal)	
	if(line6bType == "Blank" || line6bType == null){state.line6bVal = " "}
	if(line6bType == "Text"){state.line6bVal = line6bText}
	if(line6bType == "Device Attribute"){state.line6bVal = state.dev17Val}
	if(line6bType == "Image URL"){state.line6bVal = state.imageURL6b}
	vDevice.line6b(state.line6bVal)	
	if(line6cType == "Blank" || line6cType == null){state.line6cVal = " "}
	if(line6cType == "Text"){state.line6cVal = line6cText}
	if(line6cType == "Device Attribute"){state.line6cVal = state.dev18Val}
	if(line6cType == "Image URL"){state.line6cVal = state.imageURL6c}
	vDevice.line6c(state.line6cVal)	
	if(line7aType == "Blank" || line7aType == null){state.line7aVal = " "}
	if(line7aType == "Text"){state.line7aVal = line7aText}
	if(line7aType == "Device Attribute"){state.line7aVal = state.dev19Val}
	if(line7aType == "Image URL"){state.line7aVal = state.imageURL7a}
	vDevice.line7a(state.line7aVal)	
	if(line7bType == "Blank" || line7bType == null){state.line7bVal = " "}
	if(line7bType == "Text"){state.line7bVal = line7bText}
	if(line7bType == "Device Attribute"){state.line7bVal = state.dev20Val}
	if(line7bType == "Image URL"){state.line7bVal = state.imageURL7b}
	vDevice.line7b(state.line7bVal)	
	if(line7cType == "Blank" || line7cType == null){state.line7cVal = " "}
	if(line7cType == "Text"){state.line7cVal = line7cText}
	if(line7cType == "Device Attribute"){state.line7cVal = state.dev21Val}
	if(line7cType == "Image URL"){state.line7cVal = state.imageURL7c}
	vDevice.line7c(state.line7cVal)	
	if(line8aType == "Blank" || line8aType == null){state.line8aVal = " "}
	if(line8aType == "Text"){state.line8aVal = line8aText}
	if(line8aType == "Device Attribute"){state.line8aVal = state.dev22Val}
	if(line8aType == "Image URL"){state.line8aVal = state.imageURL8a}
	vDevice.line8a(state.line8aVal)	
	if(line8bType == "Blank" || line8bType == null){state.line8bVal = " "}
	if(line8bType == "Text"){state.line8bVal = line8bText}
	if(line8bType == "Device Attribute"){state.line8bVal = state.dev23Val}
	if(line8bType == "Image URL"){state.line8bVal = state.imageURL8b}
	vDevice.line8b(state.line8bVal)
	if(line8cType == "Blank" || line8cType == null){state.line8cVal = " "}
	if(line8cType == "Text"){state.line8cVal = line8cText}
	if(line8cType == "Device Attribute"){state.line8cVal = state.dev24Val}
	if(line8cType == "Image URL"){state.line8cVal = state.imageURL8c}
	vDevice.line8c(state.line8cVal)	
	vDevice.refresh()	
}






def device1Handler(evt){
	def dev1evt = evt.value
	state.dev1Val = dev1evt
	LOGINFO("$device1 = $dev1evt")
	sendLines()
	}
	
def device2Handler(evt){
	def dev2evt = evt.value
	state.dev2Val = dev2evt
	LOGINFO( "$device2 = $dev2evt")
	sendLines()
	}	
	
def device3Handler(evt){
	def dev3evt = evt.value
	state.dev3Val = dev3evt
	LOGINFO("$device3 = $dev3evt")
	sendLines()
	}	
	
def device4Handler(evt){
	def dev4evt = evt.value
	state.dev4Val = dev4evt
	LOGINFO("$device4 = $dev4evt")
	sendLines()
	}	
def device5Handler(evt){
	def dev5evt = evt.value
	state.dev5Val = dev5evt
	LOGINFO("$device5 = $dev5evt")
	sendLines()
	}	

def device6Handler(evt){
	def dev6evt = evt.value
	state.dev6Val = dev6evt
	LOGINFO("$device6 = $dev6evt")
	sendLines()
	}	
def device7Handler(evt){
	def dev7evt = evt.value
	state.dev7Val = dev7evt
	LOGINFO("$device7 = $dev7evt")
	sendLines()
	}	
def device8Handler(evt){
	def dev8evt = evt.value
	state.dev8Val = dev8evt
	LOGINFO("$device8 = $dev8evt")
	sendLines()
	}	
def device9Handler(evt){
	def dev9evt = evt.value
	state.dev9Val = dev9evt
	LOGINFO("$device9 = $dev9evt")
	sendLines()
	}	
def device10Handler(evt){
	def dev10evt = evt.value
	state.dev10Val = dev10evt
	LOGINFO("$device10 = $dev10evt")
	sendLines()
	}
	
def device11Handler(evt){
	def dev11evt = evt.value
	state.dev11Val = dev11evt
	LOGINFO("$device11 = $dev11evt")
	sendLines()
	}	
	
def device12Handler(evt){
	def dev12evt = evt.value
	state.dev12Val = dev12evt
	LOGINFO("$device12 = $dev12evt")
	sendLines()
	}	
	
def device13Handler(evt){
	def dev13evt = evt.value
	state.dev13Val = dev13evt
	LOGINFO("$device13 = $dev13evt")
	sendLines()
	}

def device14Handler(evt){
	def dev14evt = evt.value
	state.dev14Val = dev14evt
	LOGINFO("$device14 = $dev14evt")
	sendLines()
	}
	
def device15Handler(evt){
	def dev15evt = evt.value
	state.dev15Val = dev15evt
	LOGINFO("$device15 = $dev15evt")
	sendLines()
	}	
	
def device16Handler(evt){
	def dev16evt = evt.value
	state.dev16Val = dev16evt
	LOGINFO("$device16 = $dev16evt")
	sendLines()
	}	
	
def device17Handler(evt){
	def dev17evt = evt.value
	state.dev17Val = dev17evt
	LOGINFO("$device17 = $dev17evt")
	sendLines()
	}	
def device18Handler(evt){
	def dev18evt = evt.value
	state.dev18Val = dev18evt
	LOGINFO("$device18 = $dev18evt")
	sendLines()
	}
	
def device19Handler(evt){
	def dev19evt = evt.value
	state.dev19Val = dev19evt
	LOGINFO("$device19 = $dev19evt")
	sendLines()
	}	
	
def device20Handler(evt){
	def dev20evt = evt.value
	state.dev20Val = dev20evt
	LOGINFO("$device20 = $dev20evt")
	sendLines()
	}		

def device21Handler(evt){
	def dev21evt = evt.value
	state.dev21Val = dev21evt
	LOGINFO("$device21 = $dev21evt")
	sendLines()
	}
	
def device22Handler(evt){
	def dev22evt = evt.value
	state.dev22Val = dev22evt
	LOGINFO("$device22 = $dev22evt")
	sendLines()
	}	
	
def device23Handler(evt){
	def dev23evt = evt.value
	state.dev23Val = dev23evt
	LOGINFO("$device23 = $dev23evt")
	sendLines()
	}	
	
def device24Handler(evt){
	def dev24evt = evt.value
	state.dev24Val = dev24evt
	LOGINFO("$device24 = $dev24evt")
	sendLines()
	}	



def version(){
	setDefaults()
	updateCheck()
	pauseOrNot()
	logCheck()
	resetBtnName()
	schedule("${state.checkCron}", updateCheck) //  Check for updates every Friday
	checkButtons()
   
}




def logCheck(){
    state.checkLog = logLevel
	if(state.checkLog == "INFO"){log.info "Informational Logging Enabled"}
	if(state.checkLog == "DEBUG & INFO"){log.info "Debug & Info Logging Enabled"}
	if(state.checkLog == "NONE"){log.info "Further Logging Disabled"}
}


def LOGDEBUG(txt){
	if(state.checkLog == "DEBUG & INFO"){
    try {
    	log.debug("${app.label.replace(" ","_").toUpperCase()}  (App Version: ${state.version}) - ${txt}") 
    } catch(ex) {
    	log.error("LOGDEBUG unable to output requested data!")
    }
  }
		
}

def LOGINFO(txt){
	if(state.checkLog == "INFO" || state.checkLog == "DEBUG & INFO"){
    try {
    	log.info("${app.label.replace(" ","_").toUpperCase()}  (App Version: ${state.version}) - ${txt}") 
    } catch(ex) {
    	log.error("LOGINFO unable to output requested data!")
    }
  }
}

def display(){
    setDefaults()
    if(state.status){section(){paragraph "<img src='http://update.hubitat.uk/icons/cobra3.png''</img> Version: $state.version <br><font face='Lucida Handwriting'>$state.Copyright </font>"}}
    if(state.status != "<b>** This app is no longer supported by $state.author  **</b>"){section(){input "updateBtn", "button", title: "$state.btnName"}}
    if(state.status != "Current"){section(){paragraph "<hr><b>Updated: </b><i>$state.Comment</i><br><br><i>Changes in version $state.newver</i><br>$state.UpdateInfo<hr><b>Update URL: </b><font color = 'red'> $state.updateURI</font><hr>"}}
    section(){input "pause1", "bool", title: "Pause This App", required: true, submitOnChange: true, defaultValue: false }
}



def checkButtons(){
    LOGDEBUG("Running checkButtons")
    appButtonHandler("updateBtn")
}


def appButtonHandler(btn){
    state.btnCall = btn
    if(state.btnCall == "updateBtn"){
    LOGDEBUG("Checking for updates now...")
    updateCheck()
    pause(3000)
    state.btnName = state.newBtn
    runIn(2, resetBtnName)
    }
    if(state.btnCall == "updateBtn1"){
    state.btnName1 = "Click Here" 
    httpGet("https://github.com/CobraVmax/Hubitat/tree/master/Apps' target='_blank")
    }
    
}   
def resetBtnName(){
    LOGDEBUG("Resetting Button")
    if(state.status != "Current"){
    state.btnName = state.newBtn
    }
    else{
    state.btnName = "Check For Update" 
    }
}    
    

def pushOverUpdate(inMsg){
    if(updateNotification == true){  
    newMessage = inMsg
    LOGDEBUG(" Message = $newMessage ")  
    state.msg1 = '[L]' + newMessage
    speakerUpdate.speak(state.msg1)
    }
}

def pauseOrNot(){
LOGDEBUG(" Calling 'pauseOrNot'...")
    state.pauseNow = pause1
    if(state.pauseNow == true){
    state.pauseApp = true
    if(app.label){
    if(app.label.contains('red')){
    LOGDEBUG( "Paused")}
    else{app.updateLabel(app.label + ("<font color = 'red'> (Paused) </font>" ))
    LOGDEBUG("App Paused - state.pauseApp = $state.pauseApp " )  
    }
   }
  }
    if(state.pauseNow == false){
    state.pauseApp = false
    if(app.label){
    if(app.label.contains('red')){ app.updateLabel(app.label.minus("<font color = 'red'> (Paused) </font>" ))
    LOGDEBUG("App Released - state.pauseApp = $state.pauseApp ")                          
    }
   }
  }    
}


def stopAllChildren(disableChild, msg){
	state.disableornot = disableChild
	state.message1 = msg
	LOGDEBUG(" $state.message1 - Disable app = $state.disableornot")
	state.appgo = state.disableornot
	state.restrictRun = state.disableornot
	if(state.disableornot == true){
	unsubscribe()
//	unschedule()
	}
	if(state.disableornot == false){
	subscribeNow()}

	
}

def updateCheck(){
    setVersion()
    def paramsUD = [uri: "http://update.hubitat.uk/json/${state.CobraAppCheck}"]
    try {
    httpGet(paramsUD) { respUD ->
//  log.warn " Version Checking - Response Data: ${respUD.data}"   // Troubleshooting Debug Code 
       		def copyrightRead = (respUD.data.copyright)
       		state.Copyright = copyrightRead
            def commentRead = (respUD.data.Comment)
       		state.Comment = commentRead

            def updateUri = (respUD.data.versions.UpdateInfo.GithubFiles.(state.InternalName))
            state.updateURI = updateUri   
            
            def newVerRaw = (respUD.data.versions.Application.(state.InternalName))
            state.newver = newVerRaw
            def newVer = (respUD.data.versions.Application.(state.InternalName).replace(".", ""))
       		def currentVer = state.version.replace(".", "")
      		state.UpdateInfo = (respUD.data.versions.UpdateInfo.Application.(state.InternalName))
                state.author = (respUD.data.author)
           
		if(newVer == "NLS"){
            state.status = "<b>** This app is no longer supported by $state.author  **</b>"  
             log.warn "** This app is no longer supported by $state.author **" 
            
      		}           
		else if(currentVer < newVer){
        	state.status = "<b>New Version Available ($newVerRaw)</b>"
        	log.warn "** There is a newer version of this app available  (Version: $newVerRaw) **"
        	log.warn " Update: $state.UpdateInfo "
             state.newBtn = state.status
            state.updateMsg = "There is a new version of '$state.ExternalName' available (Version: $newVerRaw)"
            
       		} 
		else{ 
      		state.status = "Current"
       		LOGDEBUG("You are using the current version of this app")
       		}
      					}
        	} 
        catch (e) {
        	log.error "Something went wrong: CHECK THE JSON FILE AND IT'S URI -  $e"
    		}
    if(state.status != "Current"){
		state.newBtn = state.status
		inform()
        
    }
    else{
        state.newBtn = "No Update Available"
    }
        
        
}


def inform(){
	LOGDEBUG("An update is available - Telling the parent!")
	parent.childUpdate(true,state.updateMsg) 
}



def preCheck(){
	setVersion()
    state.appInstalled = app.getInstallationState()  
    if(state.appInstalled != 'COMPLETE'){
    section(){ paragraph "$state.preCheckMessage"}
    }
    if(state.appInstalled == 'COMPLETE'){
    display()   
 	}
}

def setDefaults(){
    LOGDEBUG("Initialising defaults...")
    if(pause1 == null){pause1 = false}
    if(state.pauseApp == null){state.pauseApp = false}
   }

    
def setVersion(){
		state.version = "1.0.0"	 
		state.InternalName = "TileCentralChild"
    	state.ExternalName = "Tiler Central Child"
		state.preCheckMessage = "This app was designed to use a special 'Virtual Display Device' virtual device to display data on a dashboard tile"
    	state.CobraAppCheck = "tilecentral.json"
		state.checkCron = "0 20 9 ? * FRI *"
}







	