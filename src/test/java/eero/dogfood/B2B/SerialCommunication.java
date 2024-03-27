package eero.dogfood.B2B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SerialCommunication {
	public static void main(String[] args) throws IOException, InterruptedException {
		// Define your curl command
		String curlCommand = "curl -L -X GET \"https://admin.stage.e2ro.com/api/eeroca3upgrade/allowlist\" -H \"X-Admin-Token: 69262|UwvG05_J3DQZE9qdIePB9ZG0WIC89_U-YX8NwCsL-_fq1ZZAajCKow==\" -H \"Content-Type: application/json\"";
		// Execute the command
		Process process = Runtime.getRuntime().exec(curlCommand);
		process.waitFor();
		// Print the output
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		// Set up serial communication
		ProcessBuilder modeProcessBuilder = new ProcessBuilder("cmd", "/c", "mode", "COM17:115200,N,8,1");
		modeProcessBuilder.redirectErrorStream(true);
		Process modeProcess = modeProcessBuilder.start();
		modeProcess.waitFor();
		// Get user input for command
		BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter command: ");
		String command = userInputReader.readLine();
		// Write command to serial port (replace COM1 with your specific COM port)

		Process writeProcess = Runtime.getRuntime().exec("cmd.exe /c echo " + command + " > COM17");
		writeProcess.waitFor();
		// Read from serial port
		BufferedReader serialReader = new BufferedReader(new InputStreamReader(modeProcess.getInputStream()));
		String serialLine;
		while ((serialLine = serialReader.readLine()) != null) {
			System.out.println(serialLine);
			if (serialLine.contains("DE")) {
				System.out.println("String present");
			} else {
				System.out.println("string not present");
			}
		}
	}
}