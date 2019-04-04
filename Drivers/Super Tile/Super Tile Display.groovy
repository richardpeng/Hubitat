/**
 * Please Note: This driver is NOT released under any open-source license.
 * Please be sure to read the license agreement before installing this code.
 *
 * Copyright 2019 Andrew Parker, Parker IT North East Limited
 *
 * This driver is created and licensed by Parker IT North East Limited. A United Kingdom, Limited Company.
 *
 * This software, along with associated elements, including but not limited to online and/or electronic documentation are
 * protected by international laws and treaties governing intellectual property rights.
 *
 * This software has been licensed to you. All rights are reserved. You may use and/or modify the software.
 * You may not sublicense or distribute this software or any modifications to third parties in any way.
 *
 * You may not distribute any part of this software without the author's express permission
 *
 * By downloading, installing, and/or executing this software you hereby agree to the terms and conditions set forth in the Software license agreement.
 * This agreement can be found on-line at: http://hubitat.uk/software_License_Agreement.txt
 * 
 * Hubitat is the trademark and intellectual property of Hubitat Inc. 
 * Parker IT North East Limited has no formal or informal affiliations or relationships with Hubitat.
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License Agreement
 * for the specific language governing permissions and limitations under the License.
 *
 *-------------------------------------------------------------------------------------------------------------------
 *
 *  
 *  Last Update: 04/04/2019
 *
 *  Changes:
 *
 *  V1.1.0 - Added initial state so it should immediately display attribute in tile selection
 *  V1.0.0 - POC
 *
 */


metadata {
		definition (name: "SuperTileDisplayDevice", namespace: "Cobra", author: "AJ Parker", importUrl: "https://raw.githubusercontent.com/CobraVmax/Hubitat/master/Drivers/Super%20Tile/Super%20Tile%20Display.groovy"){
		capability "Sensor"
        command "line1a", ["string"]
		command "line1b", ["string"]
		command "line1c", ["string"]
		command "line1d", ["string"]
		command "line2a", ["string"]
		command "line2b", ["string"]
		command "line2c", ["string"]
		command "line2d", ["string"]
		command "line3a", ["string"]
		command "line3b", ["string"]
		command "line3c", ["string"]
		command "line3d", ["string"]
		command "line4a", ["string"]
		command "line4b", ["string"]
		command "line4c", ["string"]
		command "line4d", ["string"]
		command "line5a", ["string"]
		command "line5b", ["string"]
		command "line5c", ["string"]
		command "line5d", ["string"]
		command "line6a", ["string"]
		command "line6b", ["string"]
		command "line6c", ["string"]
		command "line6d", ["string"]
		command "line7a", ["string"]
		command "line7b", ["string"]
		command "line7c", ["string"]
		command "line7d", ["string"]
		command "line8a", ["string"]
		command "line8b", ["string"]
		command "line8c", ["string"]
		command "line8d", ["string"]
		command "LastDevice", ["string"]
		command "LastEvent", ["string"]
		command "refresh"
		command "clear"
		command "listOpenContacts", ["string"]
		command "setCurrentMode", ["string"]
		command "setHSMstate", ["string"]
		command "overRide", ["string"]
		attribute "CustomDisplay", "string"
		attribute "currentOpenContacts", "string"
		attribute "currentMode", "string"
		attribute "currentHSMstatus", "string"
		attribute "CharacterNumber", "string"  
		attribute  " ", "string"
        attribute "DriverVersion", "string"
        attribute "DriverStatus", "string"
        attribute "DriverUpdate", "string"}
preferences() {
	   		input "fweight", "enum",  title: "Font Weight", submitOnChange: true, defaultValue: "Normal", options: ["Normal", "Bold"]
	   		input "fstyle", "enum",  title: "Font Style", submitOnChange: true, defaultValue: "Normal", options: ["Normal", "Italic"]
			input "fcolour", "text",  title: "Font Colour (Hex Value)", defaultValue:"FFFFFF", submitOnChange: true
	   		input "fsize", "number",  title: "Initial Font Size", defaultValue:"15", submitOnChange: true
	   		input "debugMode", "bool", title: "Enable debug logging", required: true, defaultValue: false} }	
def initialize(){updated()}	
def updated() {
    log.info "Updated called"
    version()
	logCheck()
	initialState()}
	def overRide(countIn){
	state.status = countIn
	if(state.status != "stop"){
	log.warn "supertileDevice - state.status = $state.status"
	sendEvent(name: "CustomDisplay", value: "Initial State - Awaiting Data from App", isStateChange: true)}
	if(state.status == "stop"){refresh()}}	
	def setCurrentMode(modeIn){
	state.modeNow = modeIn
	sendEvent(name: "currentMode", value: state.modeNow, isStateChange: true)}
	def setHSMstate(hsmIn){
	state.hsmNow = hsmIn
	sendEvent(name: "currentHSMstatus", value: state.hsmNow, isStateChange: true)}	
	def listOpenContacts(openNow){
	state.openContacts = openNow
	sendEvent(name: "currentOpenContacts", value: state.openContacts, isStateChange: true)}
	def logsOff() {
    log.warn "Debug logging disabled..."
	device.updateSetting("debugMode", [value: "false", type: "bool"])}
	def initialState(){sendEvent(name: "CustomDisplay", value: "Initial State - Awaiting Data from App", isStateChange: true)}
	def refresh(){compile()}
	def clear(){
	state.dashFormat = " "
	state.in1a = " "
	state.in2a = " "
	state.in3a = " "
	state.in4a = " "
	state.in5a = " "
	state.in6a = " "
	state.in7a = " "
	state.in8a = " "
	state.in1b = " "
	state.in2b = " "
	state.in3b = " "
	state.in4b = " "
	state.in5b = " "
	state.in6b = " "
	state.in7b = " "
	state.in8b = " "
	state.in1c = " "
	state.in2c = " "
	state.in3c = " "
	state.in4c = " "
	state.in5c = " "
	state.in6c = " "
	state.in7c = " "
	state.in8c = " "	
	state.in1d = " "
	state.in2d = " "
	state.in3d = " "
	state.in4d = " "
	state.in5d = " "
	state.in6d = " "
	state.in7d = " "
	state.in8d = " "
	state.dashFormat = " "
	state.openContacts = " "
	state.modeNow = " "
	state.hsmNow = " "
	sendEvent(name: "CustomDisplay", value: state.dashFormat, isStateChange: true)
	sendEvent(name: "currentOpenContacts", value: state.openContacts, isStateChange: true)
	sendEvent(name: "currentMode", value: state.modeNow, isStateChange: true)
	sendEvent(name: "currentHSMstatus", value: state.hsmNow, isStateChange: true)
	compile()}
	def compile() {
	LOGDEBUG( "compile")
	if(state.in1a == null){state.in1a = " "}
	if(state.in1b == null){state.in1b = " "}
	if(state.in1c == null){state.in1c = " "}
	if(state.in1d == null){state.in1d = " "}
	if(state.in2a == null){state.in2a = " "}
	if(state.in2b == null){state.in2b = " "}
	if(state.in2c == null){state.in2c = " "}
	if(state.in2d == null){state.in2d = " "}
	if(state.in3a == null){state.in3a = " "}
	if(state.in3b == null){state.in3b = " "}
	if(state.in3c == null){state.in3c = " "}
	if(state.in3d == null){state.in3d = " "}
	if(state.in4a == null){state.in4a = " "}
	if(state.in4b == null){state.in4b = " "}
	if(state.in4c == null){state.in4c = " "}
	if(state.in4d == null){state.in4d = " "}
	if(state.in5a == null){state.in5a = " "}
	if(state.in5b == null){state.in5b = " "}
	if(state.in5c == null){state.in5c = " "}
	if(state.in5d == null){state.in5d = " "}
	if(state.in6a == null){state.in6a = " "}
	if(state.in6b == null){state.in6b = " "}
	if(state.in6c == null){state.in6c = " "}
	if(state.in6d == null){state.in6d = " "}
	if(state.in7a == null){state.in7a = " "}
	if(state.in7b == null){state.in7b = " "}
	if(state.in7c == null){state.in7c = " "}
	if(state.in7d == null){state.in7d = " "}
	if(state.in8a == null){state.in8a = " "}
	if(state.in8b == null){state.in8b = " "}
	if(state.in8c == null){state.in8c = " "}
	if(state.in8d == null){state.in8d = " "} 
	standardDash()}
	def standardDash(){
	setFont()
	state.dashFormat = ""	
	state.dashFormat += "<div style='color: #$state.fc;font-size:$state.fs"
	state.dashFormat += "px;font-weight: $state.fw; $state.stl'>"
	state.dashFormat +="${state.in1a} ${state.in1b} ${state.in1c} ${state.in1d}<br>"
	state.dashFormat +="${state.in2a} ${state.in2b} ${state.in2c} ${state.in2d}<br>"
	state.dashFormat +="${state.in3a} ${state.in3b} ${state.in3c} ${state.in3d}<br>"
	state.dashFormat +="${state.in4a} ${state.in4b} ${state.in4c} ${state.in4d}<br>"
	state.dashFormat +="${state.in5a} ${state.in5b} ${state.in5c} ${state.in5d}<br>"
	state.dashFormat +="${state.in6a} ${state.in6b} ${state.in6c} ${state.in6d}<br>"
	state.dashFormat +="${state.in7a} ${state.in7b} ${state.in7c} ${state.in7d}<br>"
	state.dashFormat +="${state.in8a} ${state.in8b} ${state.in8c} ${state.in8d}"
	state.dashFormat += "</div>"
	state.CharNumber = state.dashFormat.length()
	if(state.CharNumber > 1024){
		LOGDEBUG("Too many characters for an attribute tile")
	overRide("Unable to Display<br>Please Check Character Number<br>(1024 Max)")
	}
	sendEvent(name: "CustomDisplay", value: state.dashFormat, isStateChange: true)
	LOGDEBUG( "Attribute Content: $state.dashFormat")
	sendEvent(name: "CharacterNumber", value: state.CharNumber, isStateChange: true)}
def line1a(in1a) {state.in1a = in1a}
def line1b(in1b) {state.in1b = in1b}
def line1c(in1c) {state.in1c = in1c}
def line1d(in1d) {state.in1d = in1d}
def line2a(in2a) {state.in2a = in2a}
def line2b(in2b) {state.in2b = in2b}
def line2c(in2c) {state.in2c = in2c}
def line2d(in2d) {state.in2d = in2d}
def line3a(in3a) {state.in3a = in3a}
def line3b(in3b) {state.in3b = in3b}
def line3c(in3c) {state.in3c = in3c}
def line3d(in3d) {state.in3d = in3d}
def line4a(in4a) {state.in4a = in4a}
def line4b(in4b) {state.in4b = in4b}
def line4c(in4c) {state.in4c = in4c}
def line4d(in4d) {state.in4d = in4d}
def line5a(in5a) {state.in5a = in5a}
def line5b(in5b) {state.in5b = in5b}
def line5c(in5c) {state.in5c = in5c}
def line5d(in5d) {state.in5d = in5d}
def line6a(in6a) {state.in6a = in6a}
def line6b(in6b) {state.in6b = in6b}
def line6c(in6c) {state.in6c = in6c}
def line6d(in6d) {state.in6d = in6d}
def line7a(in7a) {state.in7a = in7a}
def line7b(in7b) {state.in7b = in7b}
def line7c(in7c) {state.in7c = in7c}
def line7d(in7d) {state.in7d = in7d}
def line8a(in8a) {state.in8a = in8a}
def line8b(in8b) {state.in8b = in8b}
def line8c(in8c) {state.in8c = in8c}
def line8d(in8d) {state.in8d = in8d}
def setFont(){
dFontW()
dFontC()
dFontS()
fStyle()}
def dFontC(){state.fc = "${fcolour}"}
def dFontS(){state.fs = "${fsize}"}
def dFontW(){
if(fweight == "Normal"){state.fw = "normal"}
if(fweight == "Bold"){state.fw = "bold"	}
if(fweight == "Italic"){
state.stl = "font-style: italic"}}
def fStyle(){
if(fstyle == "Italic"){
state.stl = "font-style: italic"}
if(fstyle != "Italic"){state.stl= "font-style: normal"}}
          

def logCheck(){
state.checkLog = debugMode
if(state.checkLog == true){
log.info "All Logging Enabled"
}
else if(state.checkLog == false){
log.info "Debug Logging Disabled"
}
if(debugMode){runIn(1800, logsOff)}
}
def LOGDEBUG(txt){
    try {
    	if (settings.debugMode) { log.debug("Device Version: ${state.version}) - ${txt}") }
    } catch(ex) {
    	log.error("LOGDEBUG unable to output requested data!")
    }
}


def version(){
    unschedule()
    schedule("0 30 9 ? * FRI *", updateCheck)  
    updateCheck()
}

def updateCheck(){
    setVersion()
	def paramsUD = [uri: "http://update.hubitat.uk/json/${state.CobraAppCheck}"] 
       	try {
        httpGet(paramsUD) { respUD ->
//			log.warn " Version Checking - Response Data: ${respUD.data}"   // Troubleshooting Debug Code **********************
       		def copyrightRead = (respUD.data.copyright)
       		state.Copyright = copyrightRead
            def newVerRaw = (respUD.data.versions.Driver.(state.InternalName))
//			log.warn "$state.InternalName = $newVerRaw"
  			def newVer = newVerRaw.replace(".", "")
//			log.warn "$state.InternalName = $newVer"
			state.newUpdateDate = (respUD.data.Comment)
       		def currentVer = state.version.replace(".", "")
      		state.UpdateInfo = "Updated: "+state.newUpdateDate + " - "+(respUD.data.versions.UpdateInfo.Driver.(state.InternalName))
            state.author = (respUD.data.author)
			state.icon = (respUD.data.icon)
           
		if(newVer == "NLS"){
            state.Status = "<b>** This driver is no longer supported by $state.author  **</b>"       
            log.warn "** This driver is no longer supported by $state.author **"      
      		}           
		else if(currentVer < newVer){
        	state.Status = "<b>New Version Available (Version: $newVerRaw)</b>"
        	log.warn "** There is a newer version of this driver available  (Version: $newVerRaw) **"
        	log.warn "** $state.UpdateInfo **"
       		} 
		else{ 
      		state.Status = "Current"
      		log.info "You are using the current version of this driver"
       		}
      					}
        	} 
        catch (e) {
        	log.error "Something went wrong: CHECK THE JSON FILE AND IT'S URI -  $e"
    		}
   		if(state.Status == "Current"){
			state.UpdateInfo = "N/A"
		    sendEvent(name: "DriverUpdate", value: state.UpdateInfo, isStateChange: true)
	 	    sendEvent(name: "DriverStatus", value: state.Status, isStateChange: true)
			}
    	else{
	    	sendEvent(name: "DriverUpdate", value: state.UpdateInfo, isStateChange: true)
	     	sendEvent(name: "DriverStatus", value: state.Status, isStateChange: true)
	    }   
 			sendEvent(name: " ", value: state.icon +"<br>" +state.Copyright +"<br> <br>", isStateChange: true)
    		sendEvent(name: "DriverVersion", value: state.version, isStateChange: true)
}

def setVersion(){
    state.version = "1.1.0"
    state.InternalName = "DisplayTile"
   	state.CobraAppCheck = "displaytile.json"     
}












